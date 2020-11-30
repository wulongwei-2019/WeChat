package wechat.wechatApi.bean.request.material;

import lombok.Data;
import lombok.ToString;

/**
 * 获取素材列表
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:24:32     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class BatchgetMaterialRequest {
	/** 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）*/
	private String type;
	/** 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回*/
	private Integer offset;
	/** 返回素材的数量，取值在1到20之间*/ 	
	private Integer count;
	
	public BatchgetMaterialRequest(String type, Integer offset, Integer count) {
		super();
		this.type = type;
		this.offset = offset;
		this.count = count;
	}
	public BatchgetMaterialRequest() {
		super();
	}
	
}
