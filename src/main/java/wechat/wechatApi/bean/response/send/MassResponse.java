package wechat.wechatApi.bean.response.send;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import wechat.wechatApi.bean.response.BaseResponse;

/**
 * {@link}https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN
 * http请求方式: POST（请使用https协议）
 * @Description:群发信息返回的对象
 * 请注意：在返回成功时，意味着群发任务提交成功，并不意味着此时群发已经结束，所以，仍有可能在后续的发送过程中出现异常情况导致用户未收到消息，
 * 如消息有时会进行审核、服务器不稳定等。此外，群发任务一般需要较长的时间才能全部发送完毕，请耐心等待。
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:35:02     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
@ToString
public class MassResponse extends BaseResponse {

	/**消息ID**/
	private Long msg_id;
	/**消息的数据ID，，该字段只有在群发图文消息时，才会出现。
	 * 可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
	 * 是图文分析数据接口中的msgid字段中的前半部分，
	 * 详见图文分析数据接口中的msgid字段的介绍。
	 * **/
	private Long msg_data_id;
}
