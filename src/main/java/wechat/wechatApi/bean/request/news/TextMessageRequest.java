package wechat.wechatApi.bean.request.news;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import wechat.wechatApi.bean.media.BaseMessage;


/**
 * 回复文本消息
 * @author: wulongwei
 * @date:   2019年1月17日 下午2:02:06     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@XStreamAlias("xml")
public class TextMessageRequest extends BaseMessage{

	@XStreamAlias("Content")
	private String content; // 文本消息内容

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
