package wechat.wechatApi.constant;
/**
 * 请求方式，编码格式
 * @author: wulongwei
 * @date:   2019年1月17日 下午1:37:43     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class SystemConstant {

	public static final String DEFAULT_CHARACTER_ENCODING = "UTF-8";
	public static final String GET_METHOD = "GET";
	public static final String POST_METHOD = "POST";
	
	public interface Mssage {
		// 请求消息类型：文本
		public static final String REQ_MESSAGE_TYPE_TEXT = "text";
		// 请求消息类型：图文
		public static final String REQ_MESSAGE_TYPE_NEWS = "news";
		// 请求消息类型：图片
		public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
		// 请求消息类型:音乐
		public static final String REQ_MESSAGE_TYPE_MUSIC = "music";
		// 请求消息类型：链接
		public static final String REQ_MESSAGE_TYPE_LINK = "link";
		// 请求消息类型：地理位置
		public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
		// 请求消息类型：音频
		public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
		// 请求消息类型：视频
		public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
		// 请求消息类型：推送
		public static final String REQ_MESSAGE_TYPE_EVENT = "event";
		// 事件类型：subscribe(订阅)
		public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
		// 事件类型：unsubscribe(取消订阅)
		public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
		// 事件类型：CLICK(自定义菜单点击事件)
		public static final String EVENT_TYPE_CLICK = "CLICK";
		// 事件类型: view(自定义菜单view事件)
		public static final String EVENT_TYPE_VIEW = "VIEW";
		// 事件类型:scan(用户已关注时的事件推送)
		public static final String EVENT_TYPE_SCAN = "SCAN";
		// 事件类型:scancode_push(扫码推送事件)
		public static final String EVENT_TYPE_MESSAGE_SCANCODE = "scancode_push";
		// 事件类型:LOCATION(上报地理位置事件)
		public static final String EVENT_TYPE_LOCATION = "location";
		//卡券(目前在群发接口使用)
		public static final String REQ_MESSAGE_TYPE_WXCARD = "wxcard";
		/**
		 * 下方的审核通过事件类型微信官方文档有问题，以我写的为准
		 */
		/** 审核通过事件类型*/
		public static final String EVENT_TYPE_AUDIT_STATE="weapp_audit_success";
		/** 审核失败事件类型*/
		public static final String EVENT_TYPE_AUDIT_FAIL="weapp_audit_fail";
		
		
		/** 此字段是通信标识，通信失败*/
		public static final String FAIL = "FAIL";
		/** 此字段是通信标识，通信成功*/
	    public static final String SUCCESS  = "SUCCESS";
	    /** 签名类型*/
	    public static final String HMACSHA256 = "HMAC-SHA256";
	    public static final String MD5 = "MD5";
	    public static final String FIELD_SIGN = "sign";
	    public static final String FIELD_SIGN_TYPE = "sign_type";
		
	    /**
	     *	判断微信小程序的返回状态码作为是否成功的依据
	     */
	    public static final String SUCCESS_CODE = "200";
	}
}
