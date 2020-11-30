package wechat.wechatApi.bean.request.material;

import lombok.Data;
import lombok.ToString;

/**
 * 调用素材管理的通用实体
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:25:02     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class BaseMaterialRequest {
	/** 媒体文件类型*/ 
	private String type;

	public BaseMaterialRequest(String type) {
		super();
		this.type = type;
	}

	public BaseMaterialRequest() {
		super();
	}

}
