package wechat.wechatApi.service.material;

import java.io.File;

import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.request.material.AddMaterialRequest;
import wechat.wechatApi.bean.request.material.AddNewsRequest;
import wechat.wechatApi.bean.request.material.BatchgetMaterialRequest;
import wechat.wechatApi.bean.request.material.GetMaterialRequest;
import wechat.wechatApi.bean.request.material.UploadImgRequest;
import wechat.wechatApi.bean.response.material.AddMeterialResponse;
import wechat.wechatApi.bean.response.material.AddNewsResponse;
import wechat.wechatApi.bean.response.material.BatchgetMaterialResponse;
import wechat.wechatApi.bean.response.material.GetMaterialcountResponse;
import wechat.wechatApi.bean.response.material.GetNewsResponse;
import wechat.wechatApi.bean.response.material.UploadImgResponse;

/**
 * 微信素材接口调用service
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:50:34     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface MaterialApiService {

	/**
	 * 新增其它永久素材，如图片（image）、语音（voice）、和缩略图（thumb）
	 */
	AddMeterialResponse addMaterial(AddMaterialRequest addMaterialRequest,ValidateToken validateToken,File file);
	
	/**
	 * 新增永久图文素材
	 * @Title: addNews  
	 * @param addNewsRequest
	 * @param validateToken
	 * @return      
	 * @return: AddNewsResponse
	 */
	AddNewsResponse addNews(AddNewsRequest addNewsRequest, ValidateToken validateToken);
	/**
	 * 上传图文消息内的图片获取URL
	 * 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * @Title: uploadImg  
	 * @return      
	 * @return: UploadImgResponse
	 */
	UploadImgResponse uploadImg(UploadImgRequest uploadImgRequest, ValidateToken validateToken);
	
	/**
	 * 获取永久素材
	 * @Title: getNews  
	 * @param getMaterialRequest
	 * @param validateToken
	 * @return      
	 * @return: GetNewsResponse
	 */
	GetNewsResponse getNews(GetMaterialRequest getMaterialRequest, ValidateToken validateToken);
	
	/**
	 * 获取素材总数
	 * 开发者可以根据本接口来获取永久素材的列表，需要时也可保存到本地。
	 * @Title: getCount  
	 * @param validateToken
	 * @return      
	 * @return: GetMaterialcountResponse
	 */
	GetMaterialcountResponse getCount(ValidateToken validateToken);
	
	/**
	 * 获取素材列表
	 * @Title: getMaterialList  
	 * @param batchgetMaterialRequest
	 * @param validateToken
	 * @return      
	 * @return: BatchgetMaterialResponse
	 */
	BatchgetMaterialResponse getMaterialList(BatchgetMaterialRequest batchgetMaterialRequest, ValidateToken validateToken);
}
