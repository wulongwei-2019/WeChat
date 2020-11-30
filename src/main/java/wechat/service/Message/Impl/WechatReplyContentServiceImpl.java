package wechat.service.Message.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wechat.domain.WechatMaterial;
import wechat.domain.WechatReplyContent;
import wechat.domain.WechatReplyKeyword;
import wechat.mapper.WechatReplyContentMapper;
import wechat.service.Message.WechatKeywordService;
import wechat.service.Message.WechatReplyContentService;
import wechat.service.Material.WechatMaterialService;

@Service
public class WechatReplyContentServiceImpl implements WechatReplyContentService{

	@Override
	public Integer save(WechatReplyContent replyContent) {
		 contentMapper.insertReplyContent(replyContent);
		 return replyContent.getId();
	}
	
	/**
	 * 匹配关键词
	 * @Title: getWechatReplyKeyword  
	 * @param appId
	 * @param content
	 * @return      
	 * @return: WechatReplyKeyword
	 */
	public WechatReplyContent getWechatReplyKeyword(String appId, String content) {
		WechatReplyKeyword wechatKeyword = keywordService.getWechatReplyKeyword(appId, content);
		WechatReplyContent replyContent = contentMapper.getWechatReplyContent(wechatKeyword != null ? wechatKeyword.getReplyContentId() : 0);
		if(replyContent != null && replyContent.getMediaId() != null) {
			/**
			 * 查询出关联的素材对象
			 */
			WechatMaterial material = materialService.getWechatMaterial(replyContent.getMediaId(), appId);
			replyContent.setWechatMaterial(material);
		}
		return replyContent;
	}

	@Autowired
	private WechatReplyContentMapper contentMapper;
	@Autowired
	private WechatMaterialService materialService;
	@Autowired
	private WechatKeywordService keywordService;
}
