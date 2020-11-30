package wechat.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import wechat.domain.WechatReplyKeyword;
import wechat.mapper.sql.WechatKeyWordSqlProvider;

@Repository
//@Mapper
public interface WechatKeywordMapper{

	/**
	 * 添加关键词
	 */
	@InsertProvider(method = "insert", type = WechatKeyWordSqlProvider.class)
	@Options(useGeneratedKeys=true)
	int insertKeyWord(WechatReplyKeyword keyword);
	
	/**
	 * 查询关键词获取回复内容ID
	 * @Title: getWechatReplyKeyword  
	 * @param appId
	 * @param content
	 * @return      
	 * @return: WechatReplyKeyword
	 */
	@SelectProvider(method = "select", type = WechatKeyWordSqlProvider.class)
	@Results(id="userMap", value={
			@Result(column="id", property="id", id=true),
		    @Result(column="app_id", property="appId"),
		    @Result(column="deleted_flag", property="hasDeleted"),
		    @Result(column="reply_content_id", property="replyContentId"),
		    @Result(column="wordkey_eq", property="wordkeyEq"),
		    @Result(column="wordkey_like", property="wordkeyLike")
	})
	WechatReplyKeyword getWechatReplyKeyword(String appId, String content);
	
}
