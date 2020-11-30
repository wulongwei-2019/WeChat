package wechat.wechatApi.bean.request.material;

import lombok.Data;
import lombok.ToString;

/**
 * 删除永久素材：request
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:24:16     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class DelMaterialRequest {
	/** 要获取的素材的media_id*/
	private String media_id;
	/** id*/ 
	private Integer id;	

	public DelMaterialRequest(String media_id, Integer id) {
		super();
		this.media_id = media_id;
		this.id = id;
	}

	public DelMaterialRequest() {
		super();
	}

}
