package wechat.service.Message.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wechat.domain.WechatReplyKeyword;
import wechat.mapper.WechatKeywordMapper;
import wechat.service.Message.WechatKeywordService;
@Service
public class WechatKeywordServiceImpl implements WechatKeywordService{
	/**
	 * 添加关键词
	 * @Title: insertWechatKeyword  
	 * @param keyword
	 * @return
	 * @throws Exception      
	 * @return: Integer
	 */
	public Integer insertWechatKeyword(WechatReplyKeyword keyword) throws Exception {
		return keywordMapper.insertKeyWord(keyword);
	}
	
	/**
	 * 匹配关键词
	 * @Title: getWechatReplyKeyword  
	 * @param appId
	 * @param content
	 * @return      
	 * @return: WechatReplyKeyword
	 */
	public WechatReplyKeyword getWechatReplyKeyword(String appId, String content) {
		return keywordMapper.getWechatReplyKeyword(appId, content);
	}
	@Autowired
	private WechatKeywordMapper keywordMapper;
}
