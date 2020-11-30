package wechat.wechatApi.bean.response.material;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import wechat.wechatApi.bean.response.BaseResponse;

/**
 * 新增永久图文素材：response
 * @author: wulongwei
 * @date:   2019年1月31日 下午4:42:11     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class AddNewsResponse extends BaseResponse{
	// 新增的图文消息素材的media_id
	private String media_id;
	
}
