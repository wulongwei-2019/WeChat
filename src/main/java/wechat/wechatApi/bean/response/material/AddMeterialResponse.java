package wechat.wechatApi.bean.response.material;

import wechat.wechatApi.bean.response.BaseResponse;

/**
 * 新增其它类型永久素材：response
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:42:25     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class AddMeterialResponse extends BaseResponse{
	// 新增的永久素材的media_id
	private String media_id;
	// 新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
	private String url;

	
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
