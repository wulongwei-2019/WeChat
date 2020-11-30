package wechat.wechatApi.bean.request.news;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wechat.wechatApi.bean.media.BaseMessage;


/**
 * 视频消息
 * @author: wulongwei
 * @date:   2019年1月17日 下午2:17:52     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@XStreamAlias("xml")
public class VideoMessageRequest extends BaseMessage {

	@XStreamAlias("Video")
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public static class Video {
		/** 通过素材管理中的接口上传多媒体文件，得到的id */
		@XStreamAlias("MediaId")
		private String mediaId;

		/** 视频消息的标题 */
		@XStreamAlias("Title")
		private String title;

		/** 视频消息的描述 */
		@XStreamAlias("Description")
		private String description;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}
}
