package wechat.service.user.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import wechat.domain.WechatFans;
import wechat.mapper.WechatFansMapper;
import wechat.service.user.WechatFansService;

/**
 * 公众号粉丝信息Service实现
 * 
 * @author: wulongwei
 * @date: 2019年2月22日 上午10:49:20
 * @Copyright: 江西金磊科技发展有限公司 All rights reserved. Notice
 *             仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Service
@Transactional
@Slf4j
public class WechatFansServiceImpl implements WechatFansService {
	@Override
	public void synchronizationFans(List<WechatFans> list, String appId) {
		// 1.通过appId删除该公众号的粉丝信息
		try {
			fansMapper.deleteTagAll(appId);
			try {
				// 2.将微信端的用户信息保存人数据库
				fansMapper.saveWechatFanList(list);
			} catch (Exception e) {
				log.info("日志记录 \t fansMapper.saveWechatFanList():" + list);
			}
		} catch (Exception e) {
			log.info("日志记录\t fansMapper.deleteTagAll():" + appId);
		}
		log.info("同步微信粉丝信息成功！");
	}

	@Autowired
	private WechatFansMapper fansMapper;
}
