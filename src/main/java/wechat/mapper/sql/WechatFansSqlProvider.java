package wechat.mapper.sql;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import wechat.domain.WechatFans;

/**
 * 公众号粉丝信息sql操作 
 * @author: wulongwei
 * @date:   2019年2月22日 上午10:51:20     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class WechatFansSqlProvider {

	/**
	 * 批量插入用户信息对象
	 * 
	 * @Title: manyInsert
	 * @param wechatMaterial
	 * @return
	 * @return: String
	 */
	public String insertAll(Map<String, List<WechatFans>> map) {
		List<WechatFans> list = map.get("list");
		StringBuilder stringBuilder = new StringBuilder("INSERT INTO jc_wechat_fans ( app_id, subscribe,"
				+ " openid, nickname, sex, city, province, country, language, headimgurl, subscribe_time, "
				+ "unionid, remark, groupid,  subscribe_scene, qr_scene, qr_scene_str, is_black_list, tagid_list,deleted_flag) VALUES ");
		MessageFormat messageFormat = new MessageFormat("("
				+ "#'{'list[{0}].appId}," 
				+ "#'{'list[{0}].subscribe}," 
				+ "#'{'list[{0}].openid}," 
				+ "#'{'list[{0}].nickname}," 
				+ "#'{'list[{0}].sex}," 
				+ "#'{'list[{0}].city}," 
				+ "#'{'list[{0}].province}," 
				+ "#'{'list[{0}].country}," 
				+ "#'{'list[{0}].language}," 
				+ "#'{'list[{0}].headimgurl}," 
				+ "#'{'list[{0}].subscribeTime}," 
				+ "#'{'list[{0}].unionid}," 
				+ "#'{'list[{0}].remark}," 
				+ "#'{'list[{0}].groupid}," 
				+ "#'{'list[{0}].subscribeScene}," 
				+ "#'{'list[{0}].qrScene}," 
				+ "#'{'list[{0}].qrSceneStr}," 
				+ "#'{'list[{0}].isBlackList}," 
				+ "#'{'list[{0}].tagidList}," 
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
	public String deleteFansAll(final String appId) {
		return new SQL(){
			{
			DELETE_FROM("jc_wechat_fans");
			WHERE("app_id='" + appId + "'");
			}
		}.toString();
	}
	
}
 