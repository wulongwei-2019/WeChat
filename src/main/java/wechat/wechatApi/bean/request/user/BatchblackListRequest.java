package wechat.wechatApi.bean.request.user;

import java.util.List;


import lombok.Data;
import lombok.ToString;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:公众号可通过该接口来拉黑一批用户的请求接口；
 * @author: wulongwei
 * @date:   2019年2月16日 下午3:45:48     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class BatchblackListRequest {

	/**需要拉入黑名单的用户的openid，一次拉黑最多允许20个**/
	
	private List<String> openid_list;
}
