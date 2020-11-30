package wechat.wechatApi.bean.request.material;

import lombok.Data;
import lombok.ToString;

/**
 * 新增永久视频素材：request
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:25:29     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class AddVideoMaterialRequest {
	/** 视频素材的标题*/
	private String title;
	/** 视频素材的描述*/
	private String introduction;

	public AddVideoMaterialRequest(String title, String introduction) {
		super();
		this.title = title;
		this.introduction = introduction;
	}

	public AddVideoMaterialRequest() {
		super();
	}
	
}
