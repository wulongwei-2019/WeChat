package wechat.service.WeChatInfo.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wechat.domain.AbstractWeChatToken;
import wechat.mapper.AbstractWeChatTokenMapper;
import wechat.service.WeChatInfo.AbstractWeChatTokenService;

@Service
@Transactional
public class AbstractWeChatTokenServiceImpl implements AbstractWeChatTokenService{

	@Override
	public AbstractWeChatToken getAbstractWeChatToken(String appId) {
		return chatTokenMapper.getAbstractWeChatToken(appId);
	}

	@Override
	public Integer updateWeChatToken(AbstractWeChatToken abstractWeChatToken) {
		return chatTokenMapper.updateWeChatToKen(abstractWeChatToken);
	}
	
	@Autowired
	private AbstractWeChatTokenMapper chatTokenMapper;

	
}
