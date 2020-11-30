package wechat.service.Send;

import wechat.domain.dtomain.SendingDto;
import wechat.wechatApi.bean.response.send.MassResponse;

/**
 * 群发service
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:22:07     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */

public interface GroupSendingService {

	/**
	 * 通过openId群发消息(因未认证，只能调用群发文本接口)
	 * @Title: byOpenIDSend  
	 * @param materialId
	 * @param appId
	 * @return      
	 * @return: MassResponse
	 */
	public MassResponse byOpenIDSend(SendingDto dto, String appId);
	
	/**
	 * 预览接口(开发者可通过该接口发送消息给指定用户，在手机端查看消息的样式和排版)
	 * @Title: preview  
	 * @param dto
	 * @param appId
	 * @return      
	 * @return: MassResponse
	 */
	public MassResponse preview(SendingDto dto, String appId);
	
	/**
	 * 根据标签群发
	 */
	public MassResponse sendall(SendingDto dto, String appId);
}
