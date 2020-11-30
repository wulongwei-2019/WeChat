package wechat.mapper.sql;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import wechat.domain.WechatMaterial;

public class WechatMaterialSqlProvider {

	/**
	 * 根据ID查询素材对象
	 * 
	 * @Title: select
	 * @param appId
	 * @param content
	 * @return
	 * @return: String
	 */
	public String select(String appId, final Integer id) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM("jc_wechat_material");
				WHERE("deleted_flag = false AND id=" + id);
				// WHERE("deleted_flag = false AND app_id='" + appId + "' AND id=" + id);
			}
		}.toString();
		return sql;
	}

	/**
	 * 通过素材ID和appId查询素材
	 * @Title: selectWechatMaterial  
	 * @param appId
	 * @param materialId
	 * @return      
	 * @return: String
	 */
	public String selectWechatMaterial(String appId, final String materialId) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM("jc_wechat_material");
				WHERE("deleted_flag = false AND media_id ='" + materialId + "'");
			}
		}.toString();
		return sql;
	}

	/**
	 * 添加素材对象
	 * 
	 * @Title: insert
	 * @param replyContent
	 * @return
	 * @return: String
	 */
	public String insert(WechatMaterial wechatMaterial) {
		return new SQL() {
			{
				INSERT_INTO("jc_wechat_material");
				VALUES("app_id", "#{appId}");
				VALUES("media_type", "#{mediaType}");
				VALUES("media_id", "#{mediaId}");
				VALUES("material_json", "#{materialJson}");
				VALUES("wechat_update_time", "#{wechatUpdateTime}");
				VALUES("deleted_flag", "false");
			}
		}.toString();
	}

	/**
	 * 批量插入素材对象
	 * 
	 * @Title: manyInsert
	 * @param wechatMaterial
	 * @return
	 * @return: String
	 */
	public String insertAll(Map<String, List<WechatMaterial>> map) {
		List<WechatMaterial> list = map.get("list");
		StringBuilder stringBuilder = new StringBuilder("INSERT INTO jc_wechat_material (app_id, media_type,"
				+ " media_id, material_json, wechat_update_time, deleted_flag) VALUES ");
		MessageFormat messageFormat = new MessageFormat("(" + "#'{'list[{0}].appId},"
				+ "#'{'list[{0}].mediaType}," + "#'{'list[{0}].mediaId}," + "#'{'list[{0}].materialJson},"
				+ "#'{'list[{0}].wechatUpdateTime}," + "#'{'list[{0}].hasDeleted}" + ")");

		for (int i = 0; i < list.size(); i++) {
			stringBuilder.append(messageFormat.format(new Object[] { i+"" }));
			if (i < list.size() - 1)
				stringBuilder.append(",");
		}
		return stringBuilder.toString();
	}

	/**
	 * 根据素材类型删除对应公众号下的素材
	 * @Title: deleteAll  
	 * @param appId
	 * @param type
	 * @return      
	 * @return: String
	 */
	public String deleteAll(final String appId, final String type) {
		String sql = new SQL() {
			{
				DELETE_FROM("jc_wechat_material");
				WHERE("app_id='" + appId + "'AND media_type='" + type+"'");
			}
		}.toString();
		return sql;
	}
}
