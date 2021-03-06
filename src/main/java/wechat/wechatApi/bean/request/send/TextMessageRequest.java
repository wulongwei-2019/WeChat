package wechat.wechatApi.bean.request.send;

import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * 文本消息发送对象；
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:42:22     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */

@ToString
@Data
public class TextMessageRequest {

	/**发送对象**/
	private List<String> touser;
	/**用于设定消息的接收者*/
	private Filter filter;
	/**文本对象**/
	private Text text;
	/**消息类型**/
	private String msgtype;
	
	@ToString
	@Data
	public static class Text {		
		/**文本内容**/
		private String content;		
	}
}
