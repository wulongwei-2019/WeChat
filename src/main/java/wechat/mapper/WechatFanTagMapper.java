package wechat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;
import wechat.domain.WechatFanTag;
import wechat.mapper.sql.WechatFanTagSqlProvider;

/**
 * 微信粉丝标签sql操作
 * @author: wulongwei
 * @date:   2019年2月20日 下午6:07:18     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Repository
public interface WechatFanTagMapper {

	
	/**
	 * 批量添加标签对象
	 * @Title: saveWechatFanTagList  
	 * @param fanTags      
	 * @return: void
	 */
	@InsertProvider(method = "insertAll", type = WechatFanTagSqlProvider.class)
	@Options(useGeneratedKeys=true)
	void saveWechatFanTagList(List<WechatFanTag> fanTags);
	
	/**
	 * 删除所属公众号的标签
	 * @Title: deleteTagAll  
	 * @param appId      
	 * @return: void
	 */
	@DeleteProvider(method = "deleteTagAll", type = WechatFanTagSqlProvider.class)
	@Options(useGeneratedKeys=true)
	void deleteTagAll(String appId);
	
	/**
	 * 修改标签
	 * @Title: updateTag  
	 * @param fanTag      
	 * @return: void
	 */
	@UpdateProvider(method = "updateTag", type = WechatFanTagSqlProvider.class)
	@Options(useGeneratedKeys=true)
	void updateTag(WechatFanTag fanTag);
	
}
