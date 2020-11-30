package wechat.service.WeChatInfo.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wechat.domain.AbstractWeChatOpen;
import wechat.mapper.AbstractWeChatOpenMapper;
import wechat.service.WeChatInfo.AbstractWeChatOpenService;

@Service
@Transactional
public class AbstractWeChatOpenServiceImpl implements AbstractWeChatOpenService{

	@Override
	public AbstractWeChatOpen getAbstractWeChatOpen(String appId) {
		return chatOpenMapper.getAbstractWeChatOpen(appId);
	}
	
	@Autowired 
	private AbstractWeChatOpenMapper chatOpenMapper;
	
}
