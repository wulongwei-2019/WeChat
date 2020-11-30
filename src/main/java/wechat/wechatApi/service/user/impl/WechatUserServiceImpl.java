package wechat.wechatApi.service.user.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import wechat.ValidWeChatToken;
import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.request.user.TagsAddRequest;
import wechat.wechatApi.bean.request.user.TagsUpdateRequest;
import wechat.wechatApi.bean.request.user.UserInfoRequest;
import wechat.wechatApi.bean.response.user.TagsAddResponse;
import wechat.wechatApi.bean.response.user.TagsResponse;
import wechat.wechatApi.bean.response.user.UserInfoListResponse;
import wechat.wechatApi.bean.response.user.UserListResponse;
import wechat.wechatApi.constant.wechatConstant;
import wechat.wechatApi.service.user.WechatUserService;
import wechat.wechatApi.util.http.HttpUtil;

@Service
public class WechatUserServiceImpl implements WechatUserService{

	/**通过标签群发*/
	public final String CREATE_TAG = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/tags/create");
	/**获取公众号已创建的标签*/
	public final String GET_TAG = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/tags/get");
	/**编辑标签*/
	public final String UPDATE_TAG = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/tags/update");
	/**获取标签下粉丝列表*/ 
	public final String GET_USERS = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/user/get");
	/**批量获取用户基本信息*/
	private final String GET_USER_INFO = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/user/info/batchget");
	
	public final String ACCESS_TOKEN = "access_token";
	
	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public TagsAddResponse addTag(ValidateToken validateToken, TagsAddRequest tagsAddRequest) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		TagsAddResponse massResponse = HttpUtil.postJsonBean(CREATE_TAG, params, JSONObject.toJSONString(tagsAddRequest), TagsAddResponse.class);
		if(massResponse.SUCCESS_CODE.equals(massResponse.getErrcode())) {
			return massResponse;
		}else {
			//抛出异常
			return null;
		}    
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public TagsResponse getTag(ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		TagsResponse massResponse = HttpUtil.getJsonBean(GET_TAG, params, TagsResponse.class);
		if(massResponse.SUCCESS_CODE.equals(massResponse.getErrcode())) {
			return massResponse;
		}else {
			//抛出异常
			return null;
		}    
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public TagsResponse updateTag(ValidateToken validateToken, TagsUpdateRequest updateRequest) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		TagsResponse massResponse = HttpUtil.postJsonBean(UPDATE_TAG, params, JSONObject.toJSONString(updateRequest), TagsResponse.class);
		if(massResponse.SUCCESS_CODE.equals(massResponse.getErrcode())) {
			return massResponse;
		}else {
			//抛出异常
			return null;
		}  
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public UserListResponse getFans(ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		UserListResponse massResponse = HttpUtil.getJsonBean(GET_USERS, params, UserListResponse.class);
		if(massResponse.SUCCESS_CODE.equals(massResponse.getErrcode())) {
			return massResponse;
		}else {
			//抛出异常
			return null;
		}  
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public UserInfoListResponse getUserInfo(ValidateToken validateToken, UserInfoRequest infoRequest) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		UserInfoListResponse massResponse = HttpUtil.postJsonBean(GET_USER_INFO, params, JSONObject.toJSONString(infoRequest), UserInfoListResponse.class);
		if(massResponse.SUCCESS_CODE.equals(massResponse.getErrcode())) {
			return massResponse;
		}else {
			//抛出异常
			return null;
		}  
	}

	

}
