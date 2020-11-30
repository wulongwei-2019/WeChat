package wechat.wechatApi.bean.request.news;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wechat.wechatApi.bean.media.BaseMessage;


/**
 * 图文消息
 * @author: wulongwei
 * @date:   2019年1月17日 下午2:20:23     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@XStreamAlias("xml")
public class NewsMessageRequest extends BaseMessage {
	/** 图文消息个数，限制为8条以内 */
	@XStreamAlias("ArticleCount")
	private Integer articleCount;

	/** 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应 */
	@XStreamAlias("Articles")
	private List<News> articles;

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	public List<News> getArticles() {
		return articles;
	}

	public void setArticles(List<News> articles) {
		this.articles = articles;
	}

	@XStreamAlias("item")
	public static class News {
		/** 图文消息标题 */
		@XStreamAlias("Title")
		private String title;

		/** 图文消息描述 */
		@XStreamAlias("Description")
		private String description;

		/** 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200 */
		@XStreamAlias("PicUrl")
		private String picUrl;

		/** 点击图文消息跳转链接 */
		@XStreamAlias("Url")
		private String url;

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

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}

}
