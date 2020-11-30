package wechat.wechatApi.bean.request.user;

import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:为粉丝设置标签
 * @author: wulongwei
 * @date:   2019年2月16日 下午3:53:05     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@ToString
@Data
public class UserTagsAddRequest {
	
	/**用户的openid**/
	private List<String> openid_list;
	/**标签id*/
	private Integer tagid;	
}
