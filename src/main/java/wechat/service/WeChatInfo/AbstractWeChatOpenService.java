package wechat.service.WeChatInfo;

import wechat.domain.AbstractWeChatOpen;

/**
 * 微信配置信息
 * @author: wulongwei
 * @date:   2019年2月1日 上午10:13:10     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface AbstractWeChatOpenService {

	/**
	 * 通过appId查找对应的公众号配置信息
	 * @Title: getAbstractWeChatOpen  
	 * @param appId
	 * @return      
	 * @return: AbstractWeChatOpen
	 */
	AbstractWeChatOpen getAbstractWeChatOpen(String appId);

}
