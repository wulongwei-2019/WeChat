package wechat.wechatApi.service.jsapiTicket;

import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.response.token.AuthorizerJsapiTicketResponse;
/**
 * 获取微信的jsapi_ticket公众号用于调用微信JS接口的临时票据
 * @author Administrator
 *
 */
public interface JsapiTicketService {

	/**
	 * 通过token获取jsapi_ticket
	 * @param validateToken
	 * @return
	 */
	AuthorizerJsapiTicketResponse getJsapiTicket(ValidateToken validateToken);
}
