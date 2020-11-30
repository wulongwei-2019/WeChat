package wechat.mapper.sql;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import wechat.domain.WechatFanTag;

public class WechatFanTagSqlProvider {

	/**
	 * 批量插入素材对象
	 * 
	 * @Title: manyInsert
	 * @param wechatMaterial
	 * @return
	 * @return: String
	 */
	public String insertAll(Map<String, List<WechatFanTag>> map) {
		List<WechatFanTag> list = map.get("list");
		StringBuilder stringBuilder = new StringBuilder("INSERT INTO jc_wechat_fan_tag (id, app_id, tag_name,"
				+ " user_count, deleted_flag) VALUES ");
		MessageFormat messageFormat = new MessageFormat("("
				+ "#'{'list[{0}].id},"
				+ "#'{'list[{0}].appId}," 
				+ "#'{'list[{0}].tagName},"
				+ "#'{'list[{0}].userCount},"
				+ "#'{'list[{0}].hasDeleted}" 
				+ ")");

		for (int i = 0; i < list.size(); i++) {
			stringBuilder.append(messageFormat.format(new Object[] { i+"" }));
			if (i < list.size() - 1)
				stringBuilder.append(",");
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 删除所属公众号的Tag
	 * @Title: deleteTagAll  
	 * @param appId
	 * @return      
	 * @return: String
	 */
	public String deleteTagAll(final String appId) {
		return new SQL(){
			{
			DELETE_FROM("jc_wechat_fan_tag");
			WHERE("app_id='" + appId + "'");
			}
		}.toString();
	}
	
	public String updateTag(final WechatFanTag fanTag) {
		return new SQL() {
			{
				UPDATE("jc_wechat_fan_tag").
				SET("tag_name='" +fanTag.getTagName()+ "'").
				WHERE("app_id='" + fanTag.getAppId() + "' AND id = "+fanTag.getId());
			}
		}.toString();
		
	}
}
