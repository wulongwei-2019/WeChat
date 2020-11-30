package wechat.wechatApi.bean.request.news;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wechat.wechatApi.bean.media.BaseMessage;


/**
 * 语音消息
 * @author: wulongwei
 * @date:   2019年1月17日 下午2:17:35     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@XStreamAlias("xml") 
public class VoiceMessageRequest extends BaseMessage{
	@XStreamAlias("Voice") 
	private Voice Voice;
	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}
	
	
	

}
