package wechat.wechatApi.bean.request.send;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用于设定消息的接收者
 * @author: wulongwei
 * @date:   2019年2月16日 下午2:07:22     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Getter
@Setter
@ToString
public class Filter {

	/**用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，
	 * 选择false可根据tag_id发送给指定群组的用户**/
	private Boolean is_to_all;
	/**群发到的标签的tag_id，参见用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id**/
	private Integer tag_id;
}
