package wechat.service.Message;

import wechat.domain.WechatReplyKeyword;
/**
 * 关键词service
 * @author: wulongwei
 * @date:   2019年1月29日 下午1:59:51     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface WechatKeywordService {

	/**
	 * 添加关键词
	 * @Title: insertWechatKeyword  
	 * @param keyword
	 * @return
	 * @throws Exception      
	 * @return: Integer
	 */
	Integer insertWechatKeyword(WechatReplyKeyword keyword) throws Exception;
	
	/**
	 * 匹配关键词
	 */
	WechatReplyKeyword getWechatReplyKeyword(String appId, String content);
}
