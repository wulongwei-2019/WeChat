package wechat.wechatApi.bean.request.news;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wechat.wechatApi.bean.media.BaseMessage;


/**
 * 音乐消息
 * @author: wulongwei
 * @date:   2019年1月17日 下午2:20:37     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@XStreamAlias("xml") 
public class MusicMessageRequest extends BaseMessage{

	@XStreamAlias("Music")
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public static class Music {

		/** 音乐标题 */
		@XStreamAlias("Title")
		private String title;

		/** 音乐描述 */
		@XStreamAlias("Description")
		private String description;

		/** 音乐链接 */
		@XStreamAlias("MusicUrl")
		private String musicUrl;

		/** 高质量音乐链接，WIFI环境优先使用该链接播放音乐 */
		@XStreamAlias("HQMusicUrl")
		private String hQMusicUrl;

		/** 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id */
		@XStreamAlias("ThumbMediaId")
		private String thumbMediaId;

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

		public String getMusicUrl() {
			return musicUrl;
		}

		public void setMusicUrl(String musicUrl) {
			this.musicUrl = musicUrl;
		}

		public String gethQMusicUrl() {
			return hQMusicUrl;
		}

		public void sethQMusicUrl(String hQMusicUrl) {
			this.hQMusicUrl = hQMusicUrl;
		}

		public String getThumbMediaId() {
			return thumbMediaId;
		}

		public void setThumbMediaId(String thumbMediaId) {
			this.thumbMediaId = thumbMediaId;
		}

	}
}
