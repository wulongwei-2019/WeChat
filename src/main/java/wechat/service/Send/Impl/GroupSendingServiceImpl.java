package wechat.service.Send.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wechat.domain.dtomain.SendingDto;
import wechat.service.Send.GroupSendingService;
import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.request.send.Filter;
import wechat.wechatApi.bean.request.send.ImageMessageRequest;
import wechat.wechatApi.bean.request.send.MpnewsMessageRequest;
import wechat.wechatApi.bean.request.send.MpvideoMessageRequest;
import wechat.wechatApi.bean.request.send.TextMessageRequest;
import wechat.wechatApi.bean.request.send.VoiceMessageRequest;
import wechat.wechatApi.bean.request.send.WxcardMessageRequest;
import wechat.wechatApi.bean.response.send.MassResponse;
import wechat.wechatApi.constant.SystemConstant;

/**
 * 群发service实现
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:23:02     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
import wechat.wechatApi.service.send.GroupSendingApiService;
@Service
@Transactional
public class GroupSendingServiceImpl implements GroupSendingService{

	@Override
	public MassResponse byOpenIDSend(SendingDto sendingDto, String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		Object object = this.getType(sendingDto, SendingDto.REQ_TYPE_OPENID);
		return sendingApiService.byOpenIDSend(object, token);
	}

	@Override
	public MassResponse preview(SendingDto sendingDto, String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		Object object = this.getType(sendingDto, SendingDto.REQ_TYPE_OPENID);
		return sendingApiService.byOpenIDSend(object, token);
	}
	
	@Override
	public MassResponse sendall(SendingDto sendingDto, String appId) {
		ValidateToken token = new ValidateToken();
		token.setAppId(appId);
		Object object = this.getType(sendingDto, SendingDto.REQ_TYPE_FILTER);
		return sendingApiService.sendall(object, token);
	}
	
	/**
	 * 根据不同的类型，组装不同对象(因未认证，只能调用群发文本接口)
	 * type为1时表示通过openId群发，type为2时表示通过标签群发
	 * @Title: getType  
	 * @return      
	 * @return: Object
	 */
	public Object getType(SendingDto sendingDto, Integer type) {
		Object object = new Object();
		switch (sendingDto.getMsgtype()) {
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_TEXT:
			object = AssembleTextMessage(sendingDto, type);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_IMAGE:
			object = AssembleImageMessage(sendingDto, type);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_NEWS:
			object = AssembleNewsMessage(sendingDto, type);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_VOICE:
			object = AssembleVoiceMessage(sendingDto, type);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_VIDEO:
			object = AssembleVideoMessage(sendingDto, type);
			break;
		case SystemConstant.Mssage.REQ_MESSAGE_TYPE_WXCARD:
			object = AssembleWxcardMessage(sendingDto, type);
			break;
		}
		return object;
	}
	
	/**
	 * 组装文本群发消息对象
	 */
	public TextMessageRequest AssembleTextMessage(SendingDto sendingDto, Integer type) {
		TextMessageRequest messageRequest = new TextMessageRequest();
		TextMessageRequest.Text text = new TextMessageRequest.Text();
		text.setContent(sendingDto.getText());
		messageRequest.setText(text);
		messageRequest.setMsgtype(SystemConstant.Mssage.REQ_MESSAGE_TYPE_TEXT);
		if(SendingDto.REQ_TYPE_OPENID.equals(type)) {
			messageRequest.setTouser(sendingDto.getTouser());
		}else {
			Filter filter = new Filter();
			filter.setIs_to_all(sendingDto.getIs_to_all());
			filter.setTag_id(sendingDto.getTag_id());
			messageRequest.setFilter(filter);
		}
		return messageRequest;
	}
	
	/**
	 * 组装图片群发消息对象
	 */
	public ImageMessageRequest AssembleImageMessage(SendingDto sendingDto, Integer type) {
		ImageMessageRequest messageRequest = new ImageMessageRequest();
		ImageMessageRequest.Image image = new ImageMessageRequest.Image();
		image.setMedia_id(sendingDto.getMedia_id());
		messageRequest.setImage(image);
		messageRequest.setMsgtype(SystemConstant.Mssage.REQ_MESSAGE_TYPE_IMAGE);
		if(SendingDto.REQ_TYPE_OPENID.equals(type)) {
			messageRequest.setTouser(sendingDto.getTouser());
		}else {
			Filter filter = new Filter();
			filter.setIs_to_all(sendingDto.getIs_to_all());
			filter.setTag_id(sendingDto.getTag_id());
			messageRequest.setFilter(filter);
		}
		return messageRequest;
	}
	
	/**
	 * 组装图文群发消息对象
	 */
	public MpnewsMessageRequest AssembleNewsMessage(SendingDto sendingDto, Integer type) {
		MpnewsMessageRequest messageRequest = new MpnewsMessageRequest();
		MpnewsMessageRequest.Mpnews mpnews = new MpnewsMessageRequest.Mpnews();
		mpnews.setMedia_id(sendingDto.getMedia_id());
		messageRequest.setMpnews(mpnews);
		messageRequest.setMsgtype(SystemConstant.Mssage.REQ_MESSAGE_TYPE_NEWS);
		if(SendingDto.REQ_TYPE_OPENID.equals(type)) {
			messageRequest.setTouser(sendingDto.getTouser());
		}else {
			Filter filter = new Filter();
			filter.setIs_to_all(sendingDto.getIs_to_all());
			filter.setTag_id(sendingDto.getTag_id());
			messageRequest.setFilter(filter);
		}
		
		if(sendingDto.getSend_ignore_reprint() != null) {
			messageRequest.setSend_ignore_reprint(sendingDto.getSend_ignore_reprint());
		}
		return messageRequest;
	}
	
	/**
	 * 组装语音群发消息对象
	 */
	public VoiceMessageRequest AssembleVoiceMessage(SendingDto sendingDto, Integer type) {
		VoiceMessageRequest.Voice voice = new VoiceMessageRequest.Voice();
		voice.setMedia_id(sendingDto.getMedia_id());
		VoiceMessageRequest messageRequest = new VoiceMessageRequest();
		messageRequest.setVoice(voice);
		messageRequest.setMsgtype(SystemConstant.Mssage.REQ_MESSAGE_TYPE_VOICE);
		if(SendingDto.REQ_TYPE_OPENID.equals(type)) {
			messageRequest.setTouser(sendingDto.getTouser());
		}else {
			Filter filter = new Filter();
			filter.setIs_to_all(sendingDto.getIs_to_all());
			filter.setTag_id(sendingDto.getTag_id());
			messageRequest.setFilter(filter);
		}
		return messageRequest;
	}
	
	/**
	 * 组装视频群发消息对象 （视频接口，微信文档参数有误，因没有权限还未测试，不知道哪个参数才是正确的）
	 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1481187827_i0l21
	 */
	public MpvideoMessageRequest AssembleVideoMessage(SendingDto sendingDto, Integer type) {
		MpvideoMessageRequest.Mpvideo mpvideo = new MpvideoMessageRequest.Mpvideo();
		mpvideo.setMedia_id(sendingDto.getMedia_id());
		MpvideoMessageRequest messageRequest = new MpvideoMessageRequest();
		messageRequest.setMpvideo(mpvideo);
		messageRequest.setMsgtype(SystemConstant.Mssage.REQ_MESSAGE_TYPE_VIDEO);
		if(SendingDto.REQ_TYPE_OPENID.equals(type)) {
			messageRequest.setTouser(sendingDto.getTouser());
		}else {
			Filter filter = new Filter();
			filter.setIs_to_all(sendingDto.getIs_to_all());
			filter.setTag_id(sendingDto.getTag_id());
			messageRequest.setFilter(filter);
		}
		return messageRequest;
	}
	
	/**
	 * 组装微信卡券群发消息对象
	 */
	public WxcardMessageRequest AssembleWxcardMessage(SendingDto sendingDto, Integer type) {
		WxcardMessageRequest.Wxcard wxcard = new WxcardMessageRequest.Wxcard();
		wxcard.setCard_id(sendingDto.getCard_id());
		WxcardMessageRequest messageRequest = new WxcardMessageRequest();
		messageRequest.setWxcard(wxcard);
		messageRequest.setMsgtype(SystemConstant.Mssage.REQ_MESSAGE_TYPE_WXCARD);
		if(SendingDto.REQ_TYPE_OPENID.equals(type)) {
			messageRequest.setTouser(sendingDto.getTouser());
		}else {
			Filter filter = new Filter();
			filter.setIs_to_all(sendingDto.getIs_to_all());
			filter.setTag_id(sendingDto.getTag_id());
			messageRequest.setFilter(filter);
		}
		return messageRequest;
	}
	
	@Autowired
	private GroupSendingApiService sendingApiService;

}
