package wechat.wechatApi.service.send.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import wechat.ValidWeChatToken;
import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.response.send.MassResponse;
import wechat.wechatApi.constant.wechatConstant;
import wechat.wechatApi.service.send.GroupSendingApiService;
import wechat.wechatApi.util.http.HttpUtil;
/**
 * 微信群发接口调用service实现
 * @Description:TODO
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:49:40     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Service
public class GroupSendingApiServiceImpl implements GroupSendingApiService{
	/**根据OpenID列表群发*/
	public final String MASS_OPENID = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/message/mass/send");
	/**预览接口*/
	public final String MASS_PREVIEW = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/message/mass/preview");
	/**通过标签群发*/
	public final String MASS_SENDALL = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/message/mass/sendall");
	
	public final String ACCESS_TOKEN = "access_token";
	
	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public MassResponse byOpenIDSend(Object object, ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		MassResponse massResponse = HttpUtil.postJsonBean(MASS_OPENID, params, JSONObject.toJSONString(object), MassResponse.class);
		if(massResponse.SUCCESS_CODE.equals(massResponse.getErrcode())) {
			return massResponse;
		}else {
			//抛出异常
			return null;
		}                          
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public MassResponse preview(Object object, ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		MassResponse massResponse = HttpUtil.postJsonBean(MASS_PREVIEW, params, JSONObject.toJSONString(object), MassResponse.class);
		if(massResponse.SUCCESS_CODE.equals(massResponse.getErrcode())) {
			return massResponse;
		}else {
			//抛出异常
			return null;
		}
	}

	@Override
	@ValidWeChatToken(value=wechatConstant.ValidTokenType.COMONTENT_ACCESS_TOKEN)
	public MassResponse sendall(Object object, ValidateToken validateToken) {
		Map<String, String> params = new HashMap<String, String>(16);
		params.put(ACCESS_TOKEN, validateToken.getAccessToken());
		MassResponse massResponse = HttpUtil.postJsonBean(MASS_SENDALL, params, JSONObject.toJSONString(object), MassResponse.class);
		if(massResponse.SUCCESS_CODE.equals(massResponse.getErrcode())) {
			return massResponse;
		}else {
			//抛出异常
			return null;
		}
	}

	
}
