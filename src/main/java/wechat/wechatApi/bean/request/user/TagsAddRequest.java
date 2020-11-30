package wechat.wechatApi.bean.request.user;

import lombok.Data;
import lombok.ToString;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:创建一个标签（一个公众号，最多可以创建100个标签。）
 * @author: ljw
 * @date:   2018年7月30日 上午10:05:29     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@ToString
@Data
public class TagsAddRequest {
	
	/**tag对象**/
	private Tag tag;

	@ToString
	@Data
	public static class Tag {		
		/**标签名（30个字符以内）**/
		private String name;		
	}
	
}
