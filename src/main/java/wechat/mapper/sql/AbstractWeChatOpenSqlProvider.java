package wechat.mapper.sql;

import org.apache.ibatis.jdbc.SQL;
/**
 * 公众号配置信息sql
 * @author: wulongwei
 * @date:   2019年2月1日 上午9:45:40     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class AbstractWeChatOpenSqlProvider {
	/**
	 * 通过appId查询对应的公众号信息
	 * @Title: select  
	 * @param appId
	 * @return      
	 * @return: String
	 */
	public String select(final String appId) {
		
		String sql = new SQL() {
			{
			SELECT ("*");
	        FROM("jc_wechat_open");
	        WHERE("deleted_flag = false AND app_id='"+appId+"'");
			}
		}.toString();
		return sql;
	}
}
