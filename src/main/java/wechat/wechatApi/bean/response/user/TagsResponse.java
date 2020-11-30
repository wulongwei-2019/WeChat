package wechat.wechatApi.bean.response.user;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import wechat.wechatApi.bean.response.BaseResponse;


/**
 * {@link}https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN
 * @Description:获取公众号已创建的标签
 * @author: wulongwei
 * @date:   2019年2月16日 下午4:07:11     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */

@Data
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
@ToString
public class TagsResponse extends  BaseResponse{

	/**tag对象**/
	private List<Tag> tags;

	@Data
	@ToString
	public class Tag {
		
		/**标签id，由微信分配**/
		private Integer id;
		/**标签名（30个字符以内）**/
		private String name;
		/**该标签下的粉丝数**/
		private Integer count;		
	}

}
