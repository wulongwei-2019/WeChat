package wechat.wechatApi.bean.request.send;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:图文消息发送对象；
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:41:49     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */

@ToString
@Data
public class MpnewsMessageRequest {

	/**发送对象**/
	private List<String> touser;
	/**用于设定消息的接收者*/
	private Filter filter;
	/**图文对象**/
	private Mpnews mpnews;
	/**消息类型**/
	private String msgtype;
	/**图文消息被判定为转载时，是否继续群发。 1为继续群发（转载），0为停止群发。 该参数默认为0。*/
	private Integer send_ignore_reprint;
	
	@ToString
	@Data
	public static class Mpnews {		
		private String media_id;		
	}

}
