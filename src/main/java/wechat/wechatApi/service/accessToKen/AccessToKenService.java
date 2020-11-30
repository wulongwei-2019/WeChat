package wechat.wechatApi.service.accessToKen;
/**
 * 微信token操作service
 * @author: wulongwei
 * @date:   2019年2月1日 上午9:53:34     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
import wechat.wechatApi.bean.response.token.AuthorizerAccessTokenResponse;

public interface AccessToKenService {

	/**
	 * 调用微信端接口获取token
	 */
	AuthorizerAccessTokenResponse getAccessToKen(String appId, String secret);
}
