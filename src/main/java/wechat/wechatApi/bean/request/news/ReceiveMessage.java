package wechat.wechatApi.bean.request.news;
/**
 * 接收微信用户输入的内容
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wechat.wechatApi.bean.media.BaseMessage;


@XStreamAlias("xml") 
public class ReceiveMessage extends BaseMessage{

	/**接受到的内容*/
	private String Content;

	/**接受的事件类型*/
	private String Event;
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
	
	

}
