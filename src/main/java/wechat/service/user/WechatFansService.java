package wechat.service.user;

import java.util.List;

import wechat.domain.WechatFans;

/**
 * 公众号粉丝信息Service
 * @author: wulongwei
 * @date:   2019年2月22日 上午10:49:46     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface WechatFansService {

	/**
	 * 同步微信粉丝信息
	 * @Title: synchronizationFans  
	 * @param list      
	 * @return: void
	 */
	public void synchronizationFans(List<WechatFans> list, String appId);
}
