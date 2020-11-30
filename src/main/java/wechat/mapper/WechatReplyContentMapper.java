package wechat.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import wechat.domain.WechatReplyContent;
import wechat.mapper.sql.WechatReplyContentSqlProvider;
/**
 * 回复内容Mapper层
 * @author: wulongwei
 * @date:   2019年1月25日 下午4:42:40     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Repository
public interface WechatReplyContentMapper {

	/**
	 * 动态添加回复内容
	 */
	@InsertProvider(method = "insert", type = WechatReplyContentSqlProvider.class)
	@Options(useGeneratedKeys=true)
	Integer insertReplyContent(WechatReplyContent replyContent);
	
	/**
	 * 查询关键词获取回复内容对象信息
	 * @Title: getWechatReplyKeyword  
	 * @param appId
	 * @param content
	 * @return      
	 * @return: WechatReplyKeyword
	 */
	@SelectProvider(method = "select", type = WechatReplyContentSqlProvider.class)
	@Results(id="wechatReplyContent", value={
			@Result(column="id", property="id", id=true),
		    @Result(column="app_id", property="appId"),
		    @Result(column="deleted_flag", property="hasDeleted"),
		    @Result(column="msg_type", property="msgType"),
		    @Result(column="rule_name", property="ruleName"),
		    @Result(column="sort_num", property="sortNum"),
		    @Result(column="material_id", property="mediaId"),
		    @Result(column="title", property="title"),
		    @Result(column="description", property="description"),
		    @Result(column="music_url", property="musicUrl"),
		    @Result(column="hq_music_url", property="hqMusicUrl")
	})
	WechatReplyContent getWechatReplyContent(Integer contentId);
}
