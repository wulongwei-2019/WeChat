package wechat.wechatApi.bean.media;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;
import lombok.ToString;

/**
 * 存放公共属性的类
 * @author: wulongwei
 * @date:   2019年1月17日 下午1:55:35     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class BaseMessage {

	@XStreamAlias("ToUserName")
	private String toUserName; // 开发者微信号
	
	@XStreamAlias("FromUserName")
	private String fromUserName; // 发送方帐号（一个OpenID）
	
	@XStreamAlias("CreateTime")
	private Long createTime; // 消息创建时间 （整型）
	
	@XStreamAlias("MsgType")
	private String msgType; // 消息类型
}
