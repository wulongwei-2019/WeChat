package wechat.domain;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/** 
 * @Description:微信公众号token信息
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public  class AbstractWeChatToken extends AbstractDomain<Integer> {

	private Integer id;
	/**公众号appid或开放平台应用appid1*/
	private String appId;
	/**开放平台的component_access_token(服务开发方的access_token) */
	private String componentAccessToken;
	/**微信开放平台服务器推送的component_verify_ticket，用于刷新component_access_token，（为解密之后数据）*/
	private String componentVerifyTicket;
	/**公众号授权开放平台应用产生的token，用于刷新authorizer_access_token，授权信息发生变更，会重置*/
	private String authorizerRefreshToken;
	/**开放平台应用代为调用公众号接口所使用的token ，等同于公众平台的access_token*/
	private String authorizerAccessToken;
	/**component_access_token或authorizer_access_token产生时间*/
	private Date acceccTokenCreateTime;
	private int ceshi;
	public AbstractWeChatToken(){}
	

	
	
	
}
