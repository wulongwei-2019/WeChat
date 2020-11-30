package wechat.wechatApi.bean.response.material;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import wechat.wechatApi.bean.response.BaseResponse;
import wechat.wechatApi.bean.response.material.common.BatchgetNewsItem;


/**
 * 获取永久图文素材列表：response
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:41:52     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class BatchgetNewsResponse extends BaseResponse{
	private Integer total_count;
	
	private Integer item_count;
	
	private List<BatchgetNewsItem> item;
}
