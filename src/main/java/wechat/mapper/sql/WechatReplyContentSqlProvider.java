package wechat.mapper.sql;

import org.apache.ibatis.jdbc.SQL;

import wechat.domain.WechatReplyContent;

public class WechatReplyContentSqlProvider {

	/**
	  * 动态添加回复内容的SQL
	 * @Title: insert  
	 * @param replyContent
	 * @return      
	 * @return: String
	 */
	public String insert(final WechatReplyContent replyContent){
       return new SQL(){
           {
               INSERT_INTO("jc_wechat_reply_content");
               VALUES("app_id", "#{appId}");
               VALUES("msg_type", "#{msgType}");
               VALUES("rule_name", "#{ruleName}");
               VALUES("sort_num", "#{sortNum}");
               VALUES("deleted_flag", "false");

               if(replyContent.getContent() != null){
                   VALUES("content", "#{content}");
               }
               if(replyContent.getMediaId() != null){
                   VALUES("material_id", "#{mediaId}");
               }
               if(replyContent.getTitle() != null){
               	VALUES("title", "#{title}");
               }
               if(replyContent.getDescription() != null) {
               	VALUES("description", "#{description}");
               }
               if(replyContent.getMusicUrl() != null) {
               	VALUES("music_url", "#{musicUrl}");
               }
               if(replyContent.getHqMusicUrl() != null) {
               	VALUES("hq_music_url", "#{hqMusicUrl}");
               }
           }
       }.toString();
   }
	
	
	/**
	 * 根据关键词匹配回复信息
	 * @Title: select  
	 * @param appId
	 * @param content
	 * @return      
	 * @return: String
	 */
	public String select(Integer contentId) {
		
		/**
		 * 通过回复内容对象ID查询到关联的回复内容对象信息
		 */
		String contentSQL = new SQL() {
			{
				SELECT ("*");
		        FROM("jc_wechat_reply_content");
		        WHERE ("id=("+ contentId +")");
			}
		}.toString();
		System.out.println(contentSQL);
		return contentSQL;
	}
}
