package wechat.mapper.sql;

import org.apache.ibatis.jdbc.SQL;

import wechat.domain.WechatReplyKeyword;

public class WechatKeyWordSqlProvider {

	/**
	  * 动态添加关键词的SQL
	 * @Title: insert  
	 * @param replyContent
	 * @return      
	 * @return: String
	 */
	public String insert(WechatReplyKeyword content){
      return new SQL(){
          {
              INSERT_INTO("jc_wechat_reply_keyword");
              VALUES("app_id", "#{appId}");
              VALUES("reply_content_id", "#{replyContentId}");
              VALUES("deleted_flag", "false");
              VALUES("wordkey_eq", "#{wordkeyEq}");
              VALUES("wordkey_like", "#{wordkeyLike}");    
              
          }
      }.toString();
  }

	
	/**
	 * 根据关键词获取回复内容ID
	 * @Title: select  
	 * @param appId
	 * @param content
	 * @return      
	 * @return: String
	 */
	public String select(final String appId, final String content) {
		
		String sql = new SQL() {
			{
			SELECT ("*");
	        FROM("jc_wechat_reply_keyword");
	        WHERE("deleted_flag = false AND app_id='"+appId + "' AND wordkey_eq='"+content+"' OR wordkey_like LIKE '%%"+content+"%%'");
			}
		}+"limit 0,1";
		return sql;
	}
}