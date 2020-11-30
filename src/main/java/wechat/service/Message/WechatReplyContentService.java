package wechat.service.Message;
/**
 * 回复内容service层
 * @author: wulongwei
 * @date:   2019年1月25日 下午4:44:08     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */

import wechat.domain.WechatReplyContent;

public interface WechatReplyContentService {

	/**
	 * 添加回复内容
	 * @Title: save  
	 * @param replyContent
	 * @return      
	 * @return: WechatReplyContent
	 */
	Integer save(WechatReplyContent replyContent);
	
	/**
	 * 通过appId 和关键词匹配回复内容对象信息
	 * @Title: getWechatReplyKeyword  
	 * @param appId
	 * @param content
	 * @return      
	 * @return: WechatReplyContent
	 */
    WechatReplyContent getWechatReplyKeyword(String appId, String content);
}
