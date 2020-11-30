package wechat.wechatApi.bean.response.send;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import wechat.wechatApi.bean.response.BaseResponse;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:发送信息返回的对象
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:37:35     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
@ToString
public class MessageResponse extends BaseResponse{

	/**消息ID**/
	private Integer msg_id;
		
}
