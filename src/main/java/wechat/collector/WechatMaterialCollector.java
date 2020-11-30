package wechat.collector;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;
import wechat.domain.WechatMaterial;
import wechat.service.Material.WechatMaterialService;
import wechat.wechatApi.bean.request.material.AddMaterialRequest;
import wechat.wechatApi.bean.request.material.AddNewsRequest;
import wechat.wechatApi.bean.request.material.BatchgetMaterialRequest;
import wechat.wechatApi.bean.request.material.UploadImgRequest;
import wechat.wechatApi.bean.response.material.GetMaterialcountResponse;
import wechat.wechatApi.bean.response.material.common.MaterialItems;
import wechat.wechatApi.config.WechatConfigureInfo;
import wechat.wechatApi.constant.MaterialConstant;
import wechat.wechatApi.util.StrUtils;

/**
 * 微信素材管理控制层
 * @author: wulongwei
 * @date:   2019年2月11日 下午2:59:11     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Controller
@RequestMapping(value = "/wechatMaterial")
public class WechatMaterialCollector {

	/**
	 * 新增其他类型永久素材
	 * @throws IOException 
	 */
	@PostMapping(value = "/addMaterial")
	@ResponseBody
	public String addMaterial(@RequestParam(value = "uploadFile") MultipartFile mfile,
			@RequestParam(value = "type") String type, HttpServletRequest request) throws IOException {
		// 获取文件名
		String originalFileName = mfile.getOriginalFilename();// 项目流程走向图.png
		// 获取文件后缀
		String prefix = originalFileName.substring(originalFileName.lastIndexOf("."));// .png
		String suffix = prefix.substring(1);// png
		/**
		 * 判断文件类型  如果正确返回200  否则返回""
		 */
        String returnMessage = this.fileType(type, suffix);
        if(!MaterialConstant.SUCCESS_CODE.equals(returnMessage)) {
        	return "文件类型错误";//以后补充，这里应该是自定义异常
        }
		// 获取文件名
		String fileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));// 项目流程走向图
		//1  由于系统未下载微信语音及视频文件至本地，导致无法播放，
        //2 便于系统方便辨识文件的内容且防止生成临时文件出现重名，因此采用原始文件名字加随机6位数组合新的文件名，
        prefix = java.text.Normalizer.normalize(prefix, java.text.Normalizer.Form.NFKD);
        fileName = java.text.Normalizer.normalize(fileName, java.text.Normalizer.Form.NFKD);
        final File file = File.createTempFile(fileName+StrUtils.getRandStr(6), prefix);
    	mfile.transferTo(file);
        
		String appId=WechatConfigureInfo.APP_ID; //以后扩充AppId从数据库中获取
		AddMaterialRequest addMaterialRequest=new AddMaterialRequest();
		addMaterialRequest.setFileName(originalFileName);
		addMaterialRequest.setType(type);
		@SuppressWarnings("unused")
		WechatMaterial wMaterial = materialService.saveMaterial(addMaterialRequest, appId, file);
		// 执行业务之后删除临时文件
		file.delete();
		return "ok";
	}
	
	/**
	 * 新增永久图文
	 * @Title: saveNews  
	 * @param addNewsRequest
	 * @param request
	 * @return      
	 * @return: String
	 */
	@PostMapping(value = "/saveNews")
	@ResponseBody
	public String saveNews(@RequestBody @Validated AddNewsRequest addNewsRequest, HttpServletRequest request){
		String appId=WechatConfigureInfo.APP_ID; //以后扩充AppId从数据库中获取
		materialService.saveNews(addNewsRequest, appId);
		return "ok";
	}
	
	/**
	 * 上传图文消息内的图片获取URL
	 * 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @Title: uploadImg  
	 * @param mfile
	 * @param request
	 * @return      
	 * @return: String
	 * @throws IOException 
	 */
	@PostMapping(value = "/uploadImg")
	@ResponseBody
	public String uploadImg(
			@RequestParam(value = "uploadFile") MultipartFile mfile, HttpServletRequest request) throws IOException {
		        // 获取文件名
				String originalFileName = mfile.getOriginalFilename();
				// 获取文件后缀
				String prefix = originalFileName.substring(originalFileName.lastIndexOf("."));
				// 获取文件名
				String fileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
				// 1 由于系统未下载微信语音及视频文件至本地，导致无法播放，
				// 2 便于系统方便辨识文件的内容且防止生成临时文件出现重名，因此采用原始文件名字加随机6位数组合新的文件名，
				fileName = java.text.Normalizer.normalize(fileName, java.text.Normalizer.Form.NFKD);
				prefix = java.text.Normalizer.normalize(prefix, java.text.Normalizer.Form.NFKD);
				//创建临时文件
				final File file = File.createTempFile(fileName + StrUtils.getRandStr(6), prefix);
				mfile.transferTo(file);

				String appId = WechatConfigureInfo.APP_ID;
				UploadImgRequest uploadImgRequest = new UploadImgRequest();
				uploadImgRequest.setFile(file);
				String url = materialService.uploadImg(uploadImgRequest, appId);
				// 执行业务之后删除临时文件
				file.delete();
				return url;
	}
	
	/**
	 * 获取素材总数
	 * @Title: getMaterialCount  
	 * @param request
	 * @return  {"errcode":"200","image_count":29,"news_count":18,"video_count":0,"voice_count":10}
	 * @return: String
	 */
	@PostMapping(value = "/getMaterialCount")
	@ResponseBody
	public String getMaterialCount(HttpServletRequest request) {
		GetMaterialcountResponse getMaterialcountResponse = materialService.getCount(WechatConfigureInfo.APP_ID);
		return JSON.toJSONString(getMaterialcountResponse);
	}
	
	@PostMapping(value = "/test")
	@ResponseBody
	public String test(HttpServletRequest request) {
		GetMaterialcountResponse getMaterialcountResponse = materialService.getCount(WechatConfigureInfo.APP_ID);
		return JSON.toJSONString(getMaterialcountResponse);
	}
	/**
	 * 同步素材
	 * @Title: batchgetMaterial  
	 * @param type
	 * @param request
	 * @return      
	 * @return: String
	 */
	@PostMapping(value = "/batchgetMaterial")
	@ResponseBody
	public String batchgetMaterial(String type, HttpServletRequest request) {
		BatchgetMaterialRequest materialRequest = new BatchgetMaterialRequest();
		materialRequest.setType("image");
		materialRequest.setOffset(0);
		materialRequest.setCount(20);
		List<MaterialItems> getMaterialcountResponse = materialService.getMaterialList(materialRequest,WechatConfigureInfo.APP_ID);
		return JSON.toJSONString(getMaterialcountResponse);
	}
	
	/**
	 * 判断文件类型是否是微信支持的类型
	 * @Title: fileType  
	 * @param type
	 * @return      
	 * @return: String
	 */
	public String fileType(String type, String fileSuffix) {
		String returnMessage = "";
		switch (type) {
		case MaterialConstant.MaterialType.REQ_MATERIAL_TYPE_IMAGE:
			returnMessage = this.checkImage(fileSuffix);
			break;
		case MaterialConstant.MaterialType.REQ_MATERIAL_TYPE_VOICE:
            returnMessage = this.checkVoice(fileSuffix);
			break;
		case MaterialConstant.MaterialType.REQ_MATERIAL_TYPE_THUMB:
            returnMessage = this.checkThumb(fileSuffix);
			break;
		}
		return returnMessage;
	}
	
	/**
	 * 校验图片的后缀名
	 * @Title: checkImage  
	 * @param fileSuffix
	 * @return      
	 * @return: String
	 */
	public String checkImage(String fileSuffix) {
		String returnMessage = "";
		switch (fileSuffix) {
		case MaterialConstant.ImageSuffix.File_SUFFIX_BMP:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		case MaterialConstant.ImageSuffix.File_SUFFIX_GIG:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		case MaterialConstant.ImageSuffix.File_SUFFIX_JPEG:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		case MaterialConstant.ImageSuffix.File_SUFFIX_JPG:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		case MaterialConstant.ImageSuffix.File_SUFFIX_PNG:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		}
		return returnMessage;
	}
	
	/**
	 * 校验音频的后缀名
	 * @Title: checkVoice  
	 * @param fileSuffix
	 * @return      
	 * @return: String
	 */
	public String checkVoice(String fileSuffix) {
		String returnMessage = "";
		switch (fileSuffix) {
		case MaterialConstant.VoiceSuffix.File_SUFFIX_AMR:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		case MaterialConstant.VoiceSuffix.File_SUFFIX_MP3:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		case MaterialConstant.VoiceSuffix.File_SUFFIX_WAV:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		case MaterialConstant.VoiceSuffix.File_SUFFIX_WMA:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		}
		return returnMessage;
	}
	
	/**
	 * 校验缩略图的后缀名
	 * @Title: checkThumb  
	 * @param fileSuffix
	 * @return      
	 * @return: String
	 */
	public String checkThumb(String fileSuffix) {
		String returnMessage = "";
		switch (fileSuffix) {
		case MaterialConstant.ThumbSuffix.File_SUFFIX_JPG:
			 returnMessage = MaterialConstant.SUCCESS_CODE ;
			break;
		}
		return returnMessage;
	}
	
	@Autowired
	private WechatMaterialService materialService;
}
