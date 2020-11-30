package wechat.wechatApi.bean.request.material.common;

public class ArticlesDto extends Articles{
	
	private Integer index;
	
	private String thumbMediaUrl;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getThumbMediaUrl() {
		return thumbMediaUrl;
	}

	public void setThumbMediaUrl(String thumbMediaUrl) {
		this.thumbMediaUrl = thumbMediaUrl;
	}
}
