package wechat.wechatApi.bean.request.send;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * @link}https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:图片消息发送对象；
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:40:28     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */

@Data
@ToString
public class ImageMessageRequest {

	/**发送对象**/
	private List<String> touser;
	/**用于设定消息的接收者*/
	private Filter filter;
	/**图片对象**/
	private Image image;
	/**消息类型**/
	private String msgtype;
	
	@Data
	@ToString
	public static class Image {		
		private String media_id;		
	}
}
