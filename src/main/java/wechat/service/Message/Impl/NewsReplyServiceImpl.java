package wechat.service.Message.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import wechat.domain.WechatReplyContent;
import wechat.service.Message.NewsReplyService;
import wechat.service.Message.WechatReplyContentService;
import wechat.service.Material.WechatMaterialService;
import wechat.wechatApi.bean.request.news.ImageMessageRequest;
import wechat.wechatApi.bean.request.news.MusicMessageRequest;
import wechat.wechatApi.bean.request.news.NewsMessageRequest;
import wechat.wechatApi.bean.request.news.ReqMessage;
import wechat.wechatApi.bean.request.news.TextMessageRequest;
import wechat.wechatApi.bean.request.news.VideoMessageRequest;
import wechat.wechatApi.bean.request.news.Voice;
import wechat.wechatApi.bean.request.news.VoiceMessageRequest;
import wechat.wechatApi.config.WechatConfigureInfo;
import wechat.wechatApi.constant.SystemConstant;
import wechat.wechatApi.util.serialize.SerializeUtil;
@Service
@Transactional
public class NewsReplyServiceImpl implements NewsReplyService{

	/**
	 * 消息回复
	 */
	@Override
	public String getMessageReply(ReqMessage reqMessage, String appId) {
		String messageReply = null;
		WechatReplyContent content = null;
		switch (reqMessage.getMsgType()) {
		//关键词回复
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_TEXT:
			content = contentService.getWechatReplyKeyword(appId, reqMessage.getContent());
			break;
		//事件回复	
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_EVENT:	
			return event(reqMessage.getEvent(), reqMessage);
		}
		/**
		 * 没有匹配到任何类型回复，或者没有匹配到任何关键词，则回复默认回复
		 */
		if(content == null) {
			messageReply = initText(reqMessage.getToUserName(), reqMessage.getFromUserName(), "不知道回复什么，我能说你真帅吗!");
		} else {
			messageReply = message(content.getMsgType(), reqMessage.getToUserName(), reqMessage.getFromUserName(), content);
		}
		return messageReply;
	}
	
	/**
	 * 根据不同的事件类型回复信息
	 * @Title: event  
	 * @param eventType
	 * @param reqMessage
	 * @return      
	 * @return: String
	 */
	public String event(String eventType, ReqMessage reqMessage) {
		String messageReply = null;
		switch (eventType) {
		case SystemConstant.Mssage.EVENT_TYPE_SUBSCRIBE:
			messageReply = initText(reqMessage.getToUserName(), reqMessage.getFromUserName(), "欢迎订阅公众号");
			break;
		case SystemConstant.Mssage.EVENT_TYPE_CLICK:
			messageReply = initText(reqMessage.getToUserName(), reqMessage.getFromUserName(), "你触发了点击事件!");
			break;
        case SystemConstant.Mssage.EVENT_TYPE_VIEW:
        	messageReply = initText(reqMessage.getToUserName(), reqMessage.getFromUserName(), "不知道回复什么，我能说你真帅吗!");
			break;
        case SystemConstant.Mssage.EVENT_TYPE_MESSAGE_SCANCODE:
        	messageReply = initText(reqMessage.getToUserName(), reqMessage.getFromUserName(), "你触发了扫码推送事件！");
	        break;
		}
		return messageReply;
	}
	
	
	/**
	 * 根据不同类型组装不同数据
	 * 
	 * @param type
	 * @param toUserName
	 * @param fromUserName
	 * @param wechatReplyContent
	 * @return
	 */
	public String message(String type, String toUserName, String fromUserName, WechatReplyContent wechatReplyContent) {
		String message = null;
		switch (type) {
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_TEXT:
			message = initText(toUserName, fromUserName, wechatReplyContent.getContent());
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_MUSIC:
			message = initMusicMessage(toUserName, fromUserName, wechatReplyContent);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_IMAGE:
			message = initImage(toUserName, fromUserName, wechatReplyContent);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_VOICE:
			message = initVoice(toUserName, fromUserName, wechatReplyContent);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_VIDEO:
			message = initVideo(toUserName, fromUserName, wechatReplyContent);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_NEWS:
			message = initNew(toUserName, fromUserName, wechatReplyContent);
			break;
		default:
			break;
		}
		return message;
	}
	/**
	 * 文本消息组装
	 */
	@Override
	public String initText(String toUserName, String fromUserName, String content) {
		TextMessageRequest text = new TextMessageRequest();
		text.setFromUserName(toUserName); // 设置从哪发出(发给谁)
		text.setToUserName(fromUserName);
		text.setMsgType(SystemConstant.Mssage.REQ_MESSAGE_TYPE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return SerializeUtil.beanToXml(text);
	}

	/**
	 * 音乐消息的组装
	 */
	@Override
	public String initMusicMessage(String toUserName, String fromUserName, WechatReplyContent content) {
		String message = null;
		MusicMessageRequest.Music music = new MusicMessageRequest.Music();
		music.setThumbMediaId(content.getWechatMaterial().getMediaId());
		music.setTitle(content.getTitle());
		music.setDescription(content.getDescription());
		music.setMusicUrl(content.getMusicUrl());
		music.sethQMusicUrl(content.getHqMusicUrl());
		MusicMessageRequest musicMessage = new MusicMessageRequest();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(content.getMsgType());
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMusic(music);
		message = SerializeUtil.beanToXml(musicMessage);
		return message;
	}

	/**
	 * 图片消息组装
	 */
	@Override
	public String initImage(String toUserName, String fromUserName, WechatReplyContent content) {
		String message = null;
		ImageMessageRequest.Image image = new ImageMessageRequest.Image();
		image.setMediaId(content.getWechatMaterial().getMediaId());
		ImageMessageRequest imageMessage = new ImageMessageRequest();
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(content.getMsgType());
		imageMessage.setImage(image);
		message = SerializeUtil.beanToXml(imageMessage);

		return message;
	}

	/**
	 * 语音消息组装
	 */
	@Override
	public String initVoice(String toUserName, String fromUserName, WechatReplyContent content) {
		String message = null;
		Voice voice = new Voice();
		voice.setMediaId(content.getWechatMaterial().getMediaId());
		VoiceMessageRequest voiceMessage = new VoiceMessageRequest();
		voiceMessage.setCreateTime(new Date().getTime());
		voiceMessage.setFromUserName(toUserName);
		voiceMessage.setToUserName(fromUserName);
		voiceMessage.setMsgType(content.getMsgType());
		voiceMessage.setVoice(voice);
		message = SerializeUtil.beanToXml(voiceMessage);
		return message;
	}

	/**
	 * 视频消息组装
	 */
	@Override
	public String initVideo(String toUserName, String fromUserName, WechatReplyContent content) {
		String message = null;
		VideoMessageRequest.Video video = new VideoMessageRequest.Video();
		video.setDescription(content.getDescription());
		video.setMediaId(content.getWechatMaterial().getMediaId());
		video.setTitle(content.getTitle());
		VideoMessageRequest videoMessage = new VideoMessageRequest();
		videoMessage.setCreateTime(new Date().getTime());
		videoMessage.setFromUserName(toUserName);
		videoMessage.setToUserName(fromUserName);
		videoMessage.setMsgType(content.getMsgType());
		videoMessage.setVideo(video);
		message = SerializeUtil.beanToXml(videoMessage);
		return message;
	}

	/**
	 * 图文消息组装
	 */
	@Override
	public String initNew(String toUserName, String fromUserName, WechatReplyContent content) {
		String message = null;

		NewsMessageRequest newsMessage = new NewsMessageRequest();
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setFromUserName(toUserName);
		newsMessage.setToUserName(fromUserName);
		newsMessage.setMsgType(content.getMsgType());

		List<NewsMessageRequest.News> newsList = new ArrayList<NewsMessageRequest.News>();
		String sJSON = content.getWechatMaterial().getMaterialJson();// 获取到数据库的json串
		JSONArray array = JSONArray.parseArray(sJSON);
		// 遍历图文内的消息
		for (int i = 0; i < array.size(); i++) {
			NewsMessageRequest.News news = new NewsMessageRequest.News();
			JSONObject iObj = array.getJSONObject(i);
			news.setDescription(iObj.get("digest").toString());
			//通过thumb_media_id找到对应素材的url地址
			String json = materialService.getMaterialByMaterialId(WechatConfigureInfo.APP_ID, iObj.get("thumb_media_id").toString()).getMaterialJson();
			news.setPicUrl(JSONObject.parseObject(json).get("url").toString());
			news.setTitle(iObj.get("title").toString());
			news.setUrl(iObj.get("url").toString());
			newsList.add(news);
		}
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		message = SerializeUtil.beanToXml(newsMessage);
		System.out.println(message);
		return message;
	}
	@Autowired
	private WechatReplyContentService contentService;
	@Autowired
	private WechatMaterialService materialService;
}
