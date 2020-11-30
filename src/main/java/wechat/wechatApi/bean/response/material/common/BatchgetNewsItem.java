package wechat.wechatApi.bean.response.material.common;

public class BatchgetNewsItem {
	
	private String media_id;
	
	private BatchgetContent content;
	
	private String update_time;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public BatchgetContent getContent() {
		return content;
	}

	public void setContent(BatchgetContent content) {
		this.content = content;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	
}
