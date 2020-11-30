package wechat.wechatApi.bean.request.material;

import lombok.Data;
import lombok.ToString;

/**
 * 获取永久素材
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:23:14     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class GetMaterialRequest {
	
	public GetMaterialRequest() {
		super();
	}

	/** 要获取的素材的media_id*/
	private String media_id;

	public GetMaterialRequest(String media_id) {
		super();
		this.media_id = media_id;
	}
	
}
