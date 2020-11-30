package wechat.wechatApi.service.material.Impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import wechat.ValidWeChatToken;
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
import wechat.wechatApi.constant.wechatConstant;
import wechat.wechatApi.service.material.MaterialApiService;
import wechat.wechatApi.util.http.HttpUtil;
/**
 * 微信素材接口调用service实现
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:51:03     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Service
public class MaterialApiServiceImpl implements MaterialApiService{

	/** 新增永久图文素材*/
	public final String ADD_NEWS = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/material/add_news");
	/** 上传图文消息内的图片获取URL*/
	public final String UPLOADIMG = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/media/uploadimg");
	/** 新增其它类型永久素材*/
	public final String ADD_MATERIAL = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/material/add_material");
    /**获取永久素材*/
	public final String GET_MATERIAL = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/material/get_material");
	/**获取素材总数*/
	public final String GET_MATERIAL_COUNT = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/material/get_materialcount");
	/**获取素材列表*/
	public final String GET_BATCHGET_MATERIAL = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/material/batchget_material");
	
	public final String ACCESS_TOKEN = "access_token";
	
	public final String TYPE="type";
	
	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public AddMeterialResponse addMaterial(AddMaterialRequest addMaterialRequest, ValidateToken validateToken,
			File file) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		params.put(TYPE, addMaterialRequest.getType());
		AddMeterialResponse addMeterialResponse=HttpUtil.uploadJsonBean(ADD_MATERIAL, params, null, file, AddMeterialResponse.class);
		//JSONObject jsonObject = 	HttpReqUtil.HttpsDefaultExecute("POST", ADD_MATERIAL+ACCESS_TOKEN+validateToken.getAccessToken()+TYPE+addMaterialRequest.getType(),null, null, null, JSONObject.class);
	    System.out.println(JSONObject.toJSON(addMeterialResponse));
		return addMeterialResponse;
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public UploadImgResponse uploadImg(UploadImgRequest uploadImgRequest, ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		UploadImgResponse addMeterialResponse=HttpUtil.uploadJsonBean(UPLOADIMG, params, null, uploadImgRequest.getFile(), UploadImgResponse.class);
		if(addMeterialResponse.SUCCESS_CODE.equals(addMeterialResponse.getErrcode())) {
			return addMeterialResponse;
		}else {
			//抛出异常
			return null;
		}
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public AddNewsResponse addNews(AddNewsRequest addNewsRequest, ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		System.out.println(JSONObject.toJSONString(addNewsRequest));
		AddNewsResponse addNewsResponse = HttpUtil.postJsonBean(ADD_NEWS, params, JSONObject.toJSONString(addNewsRequest), AddNewsResponse.class);
		if(addNewsResponse.SUCCESS_CODE.equals(addNewsResponse.getErrcode())) {
			return addNewsResponse;
		}else {
			//抛出异常
			return null;
		}
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public GetNewsResponse getNews(GetMaterialRequest getMaterialRequest, ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		GetNewsResponse getNewsResponse = HttpUtil.postJsonBean(GET_MATERIAL, params, JSONObject.toJSONString(getMaterialRequest), GetNewsResponse.class);
		if(getNewsResponse.SUCCESS_CODE.equals(getNewsResponse.getErrcode())) {
			return getNewsResponse;
		}else {
			//抛出异常
			return null;
		}
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public GetMaterialcountResponse getCount(ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		GetMaterialcountResponse getMaterialcountResponse = HttpUtil.getJsonBean(GET_MATERIAL_COUNT, params, GetMaterialcountResponse.class);
		if(getMaterialcountResponse.SUCCESS_CODE.equals(getMaterialcountResponse.getErrcode())) {	
		           return getMaterialcountResponse;
		}else {
			//抛出异常
			return null;
		}
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public BatchgetMaterialResponse getMaterialList(BatchgetMaterialRequest batchgetMaterialRequest, ValidateToken validateToken) {
			Map<String, String> params = new HashMap<String, String>(16);
	params.put(ACCESS_TOKEN, validateToken.getAccessToken());
	BatchgetMaterialResponse batchgetMaterialResponse = HttpUtil.postJsonBean(GET_BATCHGET_MATERIAL, params, JSONObject.toJSONString(batchgetMaterialRequest), BatchgetMaterialResponse.class);
	  if(batchgetMaterialResponse != null && batchgetMaterialResponse.SUCCESS_CODE.equals(batchgetMaterialResponse.getErrcode())) {	
	           return batchgetMaterialResponse;
	  }else {
		//抛出异常
		return null;
	  }
	}

}
