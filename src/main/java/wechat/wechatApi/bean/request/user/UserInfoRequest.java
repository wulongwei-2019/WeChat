package wechat.wechatApi.bean.request.user;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:批量获取用户基本信息请求接口
 * @author: wulongwei
 * @date:   2019年2月16日 下午3:50:00     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@ToString
@Data
public class UserInfoRequest {

	/**openid集合**/
	private List<openidList> user_list;
	
	@ToString
	@Data
	public static class openidList{
		/**微信号的openid**/
		private String openid;
	}
	
}
