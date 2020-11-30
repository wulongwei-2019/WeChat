package wechat;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import wechat.wechatApi.constant.wechatConstant;

/**
 * 定义验证微信接口所需的token是否存在或过期问题。
 * @author: wulongwei
 * @date:   2019年1月30日 下午5:40:36     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidWeChatToken {

	/**
	 * 定义验证类型，
	 * ACCESS_TOKEN 为验证公众号或小程序授权码是否过期或存在
	 * COMONTENT_ACCESS_TOKEN 验证开放平台第三方应用的component_access_token是否过期或存在
	 */
	String value() default wechatConstant.ValidTokenType.ACCESS_TOKEN;
}
