package wechat.service.Message;

import wechat.domain.WechatReplyContent;
import wechat.wechatApi.bean.request.news.ReqMessage;

public interface NewsReplyService {

	/**
	 * 消息回复
	 * @Title: getMessageReply  
	 * @param reqMessage
	 * @param appId
	 * @return      
	 * @return: String
	 */
	String getMessageReply(ReqMessage reqMessage, String appId);
	
	/**
	 * 组装文字回复消息
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	String initText(String toUserName, String fromUserName, String content);

	/**
	 * 组装音乐回复消息
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	String initMusicMessage(String toUserName, String fromUserName, WechatReplyContent content);

	/**
	 * 组装图片回复消息
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	String initImage(String toUserName, String fromUserName, WechatReplyContent content);

	/**
	 * 组装语音回复消息
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	String initVoice(String toUserName, String fromUserName, WechatReplyContent content);

	/**
	 * 组装视频回复消息
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	String initVideo(String toUserName, String fromUserName, WechatReplyContent content);

	/**
	 * 组装图文回复消息
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	String initNew(String toUserName, String fromUserName, WechatReplyContent content);
}
