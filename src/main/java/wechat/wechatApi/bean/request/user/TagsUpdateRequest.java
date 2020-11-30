package wechat.wechatApi.bean.request.user;

import lombok.Data;
import lombok.ToString;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:修改一个标签
 * @author: wulongwei
 * @date:   2019年2月16日 下午3:49:41     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class TagsUpdateRequest {

	/**tag对象**/
	private Tag tag;

	@Data
	@ToString
	public class Tag {
		/**标签名（30个字符以内）**/
		private String name;
		/**标签Id**/
		private Integer id;		
	}
}
