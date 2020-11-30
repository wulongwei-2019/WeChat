package wechat.wechatApi.bean.response.token;

import lombok.Data;
import lombok.ToString;

/**
 * 用于调用微信jsapi_ticket返回实体类
 * @author Administrator
 * 2019-07-02
 */
@ToString
@Data
public class AuthorizerJsapiTicketResponse {

	/**返回的状态值*/
	private Integer errcode;
	/**返回的消息*/
	private String errmsg;
	/**返回的ticket信息*/
	private String ticket;
	/**有效时间*/
	private Integer expires_in;
	
	public AuthorizerJsapiTicketResponse(Integer errcode, String errmsg, String ticket, Integer expires_in) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.ticket = ticket;
		this.expires_in = expires_in;
	}
	
	
}
