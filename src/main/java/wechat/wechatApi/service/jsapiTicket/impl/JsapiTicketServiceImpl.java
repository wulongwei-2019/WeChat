package wechat.wechatApi.service.jsapiTicket.impl;

import org.springframework.stereotype.Service;
import wechat.ValidWeChatToken;
import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.response.token.AuthorizerJsapiTicketResponse;
import wechat.wechatApi.constant.wechatConstant;
import wechat.wechatApi.service.jsapiTicket.JsapiTicketService;
import wechat.wechatApi.util.HttpReqUtil;

@Service
public class JsapiTicketServiceImpl implements JsapiTicketService{

	
	/**
	 * 这是在获取微信token之后调用，所以这个token一定是有效的
	 */
	@Override
	public AuthorizerJsapiTicketResponse getJsapiTicket(ValidateToken validateToken) {
		/** 新增获取微信端的jsapi_ticket*/
		 String JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + validateToken.getAccessToken() + "&type=jsapi";
		 AuthorizerJsapiTicketResponse response = HttpReqUtil.HttpsDefaultExecute("GET", JSAPI_TICKET, null, null, null, AuthorizerJsapiTicketResponse.class);
		 return response;
	}

}
