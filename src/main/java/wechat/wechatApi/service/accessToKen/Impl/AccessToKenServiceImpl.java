package wechat.wechatApi.service.accessToKen.Impl;

import org.springframework.stereotype.Service;
import wechat.wechatApi.bean.response.token.AuthorizerAccessTokenResponse;
import wechat.wechatApi.constant.SystemConstant;
import wechat.wechatApi.constant.wechatConstant;
import wechat.wechatApi.service.accessToKen.AccessToKenService;
import wechat.wechatApi.util.HttpReqUtil;

@Service
public class AccessToKenServiceImpl implements AccessToKenService{

	@Override
	public AuthorizerAccessTokenResponse getAccessToKen(String appId, String secret) {
		/** 获取AccessToKen*/
		 String getAccessToKen = wechatConstant.DOMAIN.API_URI.concat("/cgi-bin/token?grant_type=client_credential&"
				+ "appid="+ appId +"&secret="+ secret);
		AuthorizerAccessTokenResponse tokenResponse =HttpReqUtil.HttpsDefaultExecute(SystemConstant.GET_METHOD, getAccessToKen, null, null, null, AuthorizerAccessTokenResponse.class);
		return tokenResponse;
	}

}
