package wechat.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;
import wechat.domain.AbstractWeChatToken;
import wechat.mapper.sql.AbstractWeChatTokenSqlProvider;
/**
 * 微信公众号token信息Mapper
 * @author: wulongwei
 * @date:   2019年2月1日 上午9:01:02     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Repository
public interface AbstractWeChatTokenMapper {

	/**
	 * 通过appId找到对应的token
	 */
	@SelectProvider(method = "select", type = AbstractWeChatTokenSqlProvider.class)
	@Results(id="wechatToken", value={
			@Result(column="id", property="id", id=true),
		    @Result(column="app_id", property="appId"),
		    @Result(column="component_access_token", property="componentAccessToken"),
		    @Result(column="component_verify_ticket", property="componentVerifyTicket"),
		    @Result(column="authorizer_refresh_token", property="authorizerRefreshToken"),
		    @Result(column="authorizer_access_token", property="authorizerAccessToken"),
		    @Result(column="accecc_token_create_time", property="acceccTokenCreateTime")
	})
	AbstractWeChatToken getAbstractWeChatToken(String appId);
	
	/**
	 * 修改accessToKen
	 */
	@UpdateProvider(method = "update", type = AbstractWeChatTokenSqlProvider.class)
	@Options(useGeneratedKeys=true)
	int updateWeChatToKen(AbstractWeChatToken chatToken);
}
