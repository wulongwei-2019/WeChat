package wechat.wechatApi.bean.request.send;

import lombok.Data;
import lombok.ToString;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:公众号可通过该接口发送信息
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:41:34     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class MessageRequest {

	/**接收消息用户对应该公众号的openid，该字段也可以改为towxname，以实现对微信号的预览**/
	private String touser;
	/**群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard**/
	private String msgtype;
	/**用于群发的消息的media_id**/
	private String media_id;
	/**发送文本消息时文本的内容**/
	private String content;
	/**用于设定消息的接收者*/
	private Filter filter;
	
}
