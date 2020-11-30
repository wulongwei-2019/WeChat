package wechat.mapper;
import wechat.domain.WechatMaterial;
import wechat.mapper.sql.WechatMaterialSqlProvider;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
/**
 * 素材管理Mapper
 * @author: wulongwei
 * @date:   2019年1月29日 下午1:44:40     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */

@Repository
public interface WechatMaterialMapper {

	/**
	 * 通过id查询素材
	 * @Title: getWechatMaterial  
	 * @param id
	 * @return      
	 * @return: WechatMaterial
	 */
	@SelectProvider(method = "select", type = WechatMaterialSqlProvider.class)
	@Results(id="wechatMaterial", value={
			@Result(column="id", property="id", id=true),
		    @Result(column="app_id", property="appId"),
		    @Result(column="deleted_flag", property="hasDeleted"),
		    @Result(column="media_type", property="mediaType"),
		    @Result(column="media_id", property="mediaId"),
		    @Result(column="material_json", property="materialJson"),
		    @Result(column="wechat_update_time", property="wechatUpdateTime")
	})
	WechatMaterial getWechatMaterial(Integer id, String appId);

	/**
	 * 通过materialId查询素材
	 * @Title: getWechatMaterial  
	 * @param appId
	 * @param materialId
	 * @return      
	 * @return: WechatMaterial
	 */
	@SelectProvider(type = WechatMaterialSqlProvider.class, method = "selectWechatMaterial")
	@ResultMap(value="wechatMaterial")
	WechatMaterial getMaterialByMaterialId(String appId, String materialId);
	
	/**
	 * 添加素材对象
	 * @return 
	 */
	@InsertProvider(method = "insert", type = WechatMaterialSqlProvider.class)
	@Options(useGeneratedKeys=true)
	Integer saveWechatMaterial(WechatMaterial wechatMaterial);
	
	/**
	 * 批量添加素材对象
	 * @Title: saveWechatMaterialList  
	 * @param material      
	 * @return: void
	 */
	@InsertProvider(method = "insertAll", type = WechatMaterialSqlProvider.class)
	@Options(useGeneratedKeys=true)
	void saveWechatMaterialList(List<WechatMaterial> material);
	
	/**
	 * 根据素材类型删除对应公众号下的素材
	 * @Title: deleteWechatMaterial  
	 * @param appId
	 * @param type      
	 * @return: void
	 */
	@DeleteProvider(method = "deleteAll", type = WechatMaterialSqlProvider.class)
	void deleteWechatMaterial(String appId, String type);
}
