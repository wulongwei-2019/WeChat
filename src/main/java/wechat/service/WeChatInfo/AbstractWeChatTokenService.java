package wechat.service.WeChatInfo;

import wechat.domain.AbstractWeChatToken;

/**
 * 微信token信息service
 * @author: wulongwei
 * @date:   2019年2月1日 上午10:12:35     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface AbstractWeChatTokenService {

	/**
	 * 通过appId找到对应的token信息
	 * @Title: getAbstractWeChatToken  
	 * @param appId
	 * @return      
	 * @return: AbstractWeChatToken
	 */
	AbstractWeChatToken getAbstractWeChatToken(String appId);
	/**
	 * 修改accessToKen
	 * @Title: saveWeChatToken  
	 * @param abstractWeChatToken
	 * @return      
	 * @return: Integer
	 */
	public Integer updateWeChatToken(AbstractWeChatToken abstractWeChatToken);
}
