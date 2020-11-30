package wechat.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
import wechat.domain.AbstractWeChatOpen;
import wechat.mapper.sql.AbstractWeChatOpenSqlProvider;
/**
 * 微信公众号配置信息Mapper
 * @author: wulongwei
 * @date:   2019年2月1日 上午9:40:07     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Repository
public interface AbstractWeChatOpenMapper {

	/**
	 * 通过appId找到对应的微信公众号信息
	 */
	@SelectProvider(method = "select", type = AbstractWeChatOpenSqlProvider.class)
	@Results(id="wechatToken", value={
			@Result(column="id", property="id", id=true),
		    @Result(column="app_id", property="appId"),
		    @Result(column="name", property="name"),
		    @Result(column="app_secret", property="appSecret"),
		    @Result(column="message_decrypt_key", property="messageDecryptKey"),
		    @Result(column="message_validate_token", property="messageValidateToken"),
		    @Result(column="logo_id", property="logo")
	})
	AbstractWeChatOpen getAbstractWeChatOpen(String appId);
}
