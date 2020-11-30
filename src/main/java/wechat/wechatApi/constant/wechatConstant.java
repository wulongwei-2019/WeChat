package wechat.wechatApi.constant;

/**
 * 微信相关常量
 * 
 * @author: wulongwei
 * @date: 2019年1月30日 下午6:01:14
 * @Copyright: 江西金磊科技发展有限公司 All rights reserved. Notice
 *             仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class wechatConstant {

	public interface DOMAIN {
		String API_URI_HTTP = "http://api.weixin.qq.com";
		String API_URI = "https://api.weixin.qq.com";
		String FILE_URI = "http://file.api.weixin.qq.com";
		String MP_URI = "https://mp.weixin.qq.com";
		String MCH_URI = "https://api.mch.weixin.qq.com";
		String OPEN_URI = "https://open.weixin.qq.com";
		String RISK_URL = "https://fraud.mch.weixin.qq.com";
	}

	public interface Charset {
		String UTF_8 = "UTF-8";
		String ISO_8859_1 = "iso-8859-1";
	}

	public interface Lang {
		String ZH_CN = "zh_CN";
	}

	/**
	 * 定义@ValidWeChatToken注解支持的类型
	 */
	public interface ValidTokenType {
		/** 验证公众平台第三方应用的componentAccessToken */
		String COMONTENT_ACCESS_TOKEN = "componentAccessToken";
		/** 验证公众平台第三方应用代授权公众号或小程序调用凭证authorizerAccessToken */
		String ACCESS_TOKEN = "authorizerAccessToken";
	}

	/**
	 * 定义token失效时间，单位毫秒，一个半小时
	 */
	public interface Expire {
		Long VALUE = 5400000L;
	}
}
