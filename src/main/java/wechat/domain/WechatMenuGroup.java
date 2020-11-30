package wechat.domain;

import java.awt.geom.Area;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



/**
 * 
 * @Description: 微信菜单组实体
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatMenuGroup extends AbstractDomain<Integer>  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键值*/ 
    private Integer id ;
    
    private Integer menuId;
    /** appId */
    private  String appId ;
    /** 菜单组类型1-默认菜单  2-个性化菜单 */
    private  Integer menuGroupType ;
    /** 菜单组状态（默认菜单组类型中，只允许一组生效菜单）  1- 生效  2-未生效 */
    private  Integer status ;
    /** 菜单组名称 */
    private  String menuGroupName ;
    /** 显示对象国家，默认为中国 */
    private  String countryName ;
    /** 区域对象用于级联操作*/
    private Area area;
    /** 显示对象地理区域编码 */
    private  String areaCode ;
    /** 显示对象性别  1-男  2-女( 字典类型sex_type) */
    private  String sexDictCode ;
    /** 显示对象粉丝标签ID */
    private  String tagId ;
    /** 显示对象客户端版本 1-IOS, 2-Android,3-Others( 字典类型client_type) */
    private  String clientDictCode ;
    /** 显示对象语言  ( 字典类型language_type) */
    private  String languageDictCode ;
    /** 微信菜单集合*/
    private List<WechatMenu> menuList;
    /** 微信粉丝标签对象*/
    private WechatFanTag wTag;
    
	public WechatMenuGroup (){
		
	}
	
	
}