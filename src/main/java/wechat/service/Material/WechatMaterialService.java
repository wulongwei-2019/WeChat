package wechat.service.Material;

import java.io.File;
import java.util.List;

import wechat.domain.WechatMaterial;
import wechat.wechatApi.bean.request.material.AddMaterialRequest;
import wechat.wechatApi.bean.request.material.AddNewsRequest;
import wechat.wechatApi.bean.request.material.BatchgetMaterialRequest;
import wechat.wechatApi.bean.request.material.UploadImgRequest;
import wechat.wechatApi.bean.response.material.GetMaterialcountResponse;
import wechat.wechatApi.bean.response.material.common.MaterialItems;

/**
 * 微信素材管理service
 * @author: wulongwei
 * @date:   2019年1月30日 下午3:18:11     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface WechatMaterialService {
	/**
	 * 获取微信素材对象信息
	 * @Title: getWechatMaterial  
	 * @param id
	 * @param appId
	 * @return      
	 * @return: WechatMaterial
	 */
	WechatMaterial getWechatMaterial(Integer id ,String appId);
	/**
	 * 获取微信素材对象信息
	 * @Title: getWechatMaterial  
	 * @param appId
	 * @param materialId
	 * @return      
	 * @return: WechatMaterial
	 */
	WechatMaterial getMaterialByMaterialId(String appId, String materialId);
	
	/**
	 * 新增其它永久素材(图文素材、视频素材除外)
	 * @Title: saveMaterial  
	 * @param addMaterialRequest
	 * @param appId
	 * @param file
	 * @return      
	 * @return: WechatMaterial
	 */
	WechatMaterial saveMaterial(AddMaterialRequest addMaterialRequest, String appId, File file);
	
	/**
	 * 新增永久图文素材
	 * @Title: saveNews  
	 * @param addNewsRequest
	 * @param appId
	 * @return      
	 * @return: WechatMaterial
	 */
	WechatMaterial saveNews(AddNewsRequest addNewsRequest, String appId);
	/**
	 * 上传图文消息内的图片获取URL
	 * @Title: uploadImg  
	 * @param imgRequest
	 * @param appId
	 * @return      
	 * @return: WechatMaterial
	 */
	String uploadImg(UploadImgRequest imgRequest, String appId);
	/**
	 * 获取素材的数量
	 * @Title: getCount  
	 * @param validateToken
	 * @return      
	 * @return: GetMaterialcountResponse
	 */
	GetMaterialcountResponse getCount(String appId);
	
	/**
	 * 获取素材列表
	 * @Title: getMaterialList  
	 * @return      
	 * @return: BatchgetMaterialResponse
	 */
	List<MaterialItems> getMaterialList(BatchgetMaterialRequest request, String appId);
}
