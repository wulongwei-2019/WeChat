package wechat.wechatApi.bean.request.user;

import lombok.Data;
import lombok.ToString;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
 * http请求方式: GET（请使用https协议）
 * @Description:公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。
 * 一次拉取调用最多拉取10000个关注者的OpenID，可以通过多次拉取的方式来满足需求。
 * @author: wulongwei
 * @date:   2019年2月16日 下午3:52:26     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@ToString
@Data
public class UserListRequest {

	/**调用接口凭证**/
	private String access_token;	
	/**第一个拉取的OPENID，不填默认从头开始拉取**/
	private String next_openid;
}
