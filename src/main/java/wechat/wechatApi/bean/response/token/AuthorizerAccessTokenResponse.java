package wechat.wechatApi.bean.response.token;

import lombok.Data;
import lombok.ToString;
/**
 * 调用微信接口获取accessToKen返回对象
 * @author: wulongwei
 * @date:   2019年2月1日 上午9:33:28     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class AuthorizerAccessTokenResponse {
	
	public AuthorizerAccessTokenResponse(String access_token, Integer expires_in) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
	}
	public AuthorizerAccessTokenResponse() {
		super();
	}
	
    /** 获取到的凭证 */
	private String access_token;
	/** 凭证有效时间，单位：秒*/
	private Integer expires_in;
	
	
}
