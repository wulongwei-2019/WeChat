package wechat.wechatApi.bean.request;

import lombok.Data;
import lombok.ToString;

/**
 * 验证公众号或小程序token参数bean
 * 
 * @author: wulongwei
 * @date: 2019年1月30日 下午6:04:24
 * @Copyright: 江西金磊科技发展有限公司 All rights reserved. Notice
 *             仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class ValidateToken {

	/** appId（含公众号、小程序、开放平台第三方应用） */
	private String appId;
	/** authorizerAccessToken 或者componentAccessToken 必须 */
	private String accessToken;

	public ValidateToken(String appId, String accessToken) {
		super();
		this.appId = appId;
		this.accessToken = accessToken;
	}

	public ValidateToken() {
		super();
	}

}
