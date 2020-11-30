package wechat.wechatApi.service.send;

import wechat.wechatApi.bean.request.ValidateToken;
import wechat.wechatApi.bean.response.send.MassResponse;

/**
 * 微信群发接口调用service
 * @author: wulongwei
 * @date:   2019年2月12日 下午5:47:56     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface GroupSendingApiService {

	/**
	 * 调用微信群发接口
	 * @Title: addMaterial  
	 * @param object
	 * @param validateToken
	 * @return      
	 * @return: MassResponse
	 */
	MassResponse byOpenIDSend(Object object,ValidateToken validateToken);
	
	/**
	 * 预览接口
	 * @Title: preview  
	 * @param object
	 * @param validateToken
	 * @return      
	 * @return: MassResponse
	 */
	MassResponse preview(Object object,ValidateToken validateToken);
	
	/**
	 * 通关标签群发
	 * @Title: sendall  
	 * @param object
	 * @param validateToken
	 * @return      
	 * @return: MassResponse
	 */
	MassResponse sendall(Object object,ValidateToken validateToken);
}
