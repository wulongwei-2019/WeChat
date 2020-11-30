package wechat.wechatApi.bean.response.user;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import wechat.wechatApi.bean.response.BaseResponse;


/**
 * {@link}https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN
 * @Description:批量获取用户基本信息返回参数
 * @author: wulongwei
 * @date:   2019年2月16日 下午4:07:44     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
@ToString
public class UserInfoListResponse extends BaseResponse{

	/**用户列表**/
	private List<UserInfoResponse> user_info_list;
	
}
