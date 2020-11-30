package wechat.mapper;

import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import wechat.domain.WechatFans;
import wechat.mapper.sql.WechatFansSqlProvider;

/**
 * 公众号粉丝信息Mapper
 * @author: wulongwei
 * @date:   2019年2月22日 上午10:50:28     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Repository
public interface WechatFansMapper {
	/**
	 * 批量添加用户信息对象
	 * @Title: saveWechatFanTagList  
	 * @param fanTags      
	 * @return: void
	 */
	@InsertProvider(method = "insertAll", type = WechatFansSqlProvider.class)
	@Options(useGeneratedKeys=true)
	void saveWechatFanList(List<WechatFans> fans);
	
	/**
	 * 删除所属公众号的用户信息
	 * @Title: deleteTagAll  
	 * @param appId      
	 * @return: void
	 */
	@DeleteProvider(method = "deleteFansAll", type = WechatFansSqlProvider.class)
	@Options(useGeneratedKeys=true)
	void deleteTagAll(String appId);
}
