package wechat.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @Description: 微信菜单实体
 * @author: chenming
 * @date:   2018年8月10日 下午2:36:15     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatMenu extends AbstractDomain<Integer> implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 主键值*/ 
    private Integer id ;
    /** 菜单组对象 */
    private WechatMenuGroup menuGroup;
    /** 菜单组ID*/
    private Integer menuGroupId;
    /** 菜单名称 */
    private String menuName ;
    /** 菜单类型 view-网页类型  click-点击类型  miniprogram-小程序类型 */
    private String menuType ;
    /** 菜单选择类型：1. 发送消息，2.跳转网页，3.扫码，4. 扫码(等待消息)，5.立即拍照，6.拍照/相册，7.相册，8.地址位置，9.关联小程序 */
    private  Integer choiceType ;
    /** 菜单点击触发关键词 */
    private String menuKey ;
    /** 关键词回复内容对象*/
    private WechatReplyContent wechatReplyContent;
    /** 菜单跳转url(含小程序跳转url) */
    private String linkUrl ;
    /** 小程序ID */
    private String miniprogramAppid ;
    /** 小程序的页面路径 */
    private String miniprogramPagepath ;
    /** 素材id */
    private String mediaId ;
    /** 微信素材对象*/
    private WechatMaterial material ;
    /** 父级ID */
	protected Integer parentId;
	/** 父级对象 */
	protected WechatMenu parent;
	/** 子集 */
	protected List<WechatMenu> childs = new ArrayList<WechatMenu>(0);

	public WechatMenu (){
		
	}
	
	
}