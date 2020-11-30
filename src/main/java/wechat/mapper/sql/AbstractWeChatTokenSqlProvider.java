package wechat.mapper.sql;

import org.apache.ibatis.jdbc.SQL;

import wechat.domain.AbstractWeChatToken;

/**
 * 微信公众号token信息
 * @author: wulongwei
 * @date:   2019年2月1日 上午9:06:47     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class AbstractWeChatTokenSqlProvider {

	/**
	 * 通过appId查询对应的token信息
	 * @Title: select  
	 * @param appId
	 * @return      
	 * @return: String
	 */
	public String select( final String appId) {
		
		String sql = new SQL() {
			{
			SELECT ("*");
	        FROM("jc_wechat_token");
	        WHERE("deleted_flag = false AND app_id='"+appId+"'");
			}
		}.toString();
        System.out.println(sql);
		return sql;
	}
	
	/**
	 * 修改accessToKen
	 * @Title: update  
	 * @param replyContent
	 * @return      
	 * @return: String
	 */
	public String update(final AbstractWeChatToken weChatToken){
      String sql = new SQL(){
          {
              UPDATE("jc_wechat_token");

              if(weChatToken.getComponentAccessToken() != null){
                  SET("component_access_token= #{componentAccessToken}");
                  SET("authorizer_access_token= #{componentAccessToken}");
              }
              if(weChatToken.getAcceccTokenCreateTime() != null){
                  SET("accecc_token_create_time= #{acceccTokenCreateTime}");
              }
             WHERE("id=#{id}");
          }
      }.toString();
      return sql;
  }
}
