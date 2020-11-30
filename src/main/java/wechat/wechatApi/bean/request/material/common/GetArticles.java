package wechat.wechatApi.bean.request.material.common;

public class GetArticles extends Articles{
	// 图文页的URL
	private String url;
	
	private String thumbMediaUrl;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GetArticles(String title, String thumb_media_id, String author, String digest, Integer show_cover_pic,
			String content, String content_source_url, String url,String thumbMediaUrl) {
		super(title, thumb_media_id, author, digest, show_cover_pic, content, content_source_url);
		this.url = url;
		this.thumbMediaUrl = thumbMediaUrl;
	}

	public GetArticles() {
		super();
	}

	public String getThumbMediaUrl() {
		return thumbMediaUrl;
	}

	public void setThumbMediaUrl(String thumbMediaUrl) {
		this.thumbMediaUrl = thumbMediaUrl;
	}

	
	
}
