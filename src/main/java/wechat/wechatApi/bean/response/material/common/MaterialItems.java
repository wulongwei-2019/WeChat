package wechat.wechatApi.bean.response.material.common;

public class MaterialItems {
	
	private String media_id;
	
	private String name;
	
	private String update_time;
	
	private String url;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MaterialItems(String media_id, String name, String update_time, String url) {
		super();
		this.media_id = media_id;
		this.name = name;
		this.update_time = update_time;
		this.url = url;
	}

	public MaterialItems() {
		super();
	}
	
	
}
