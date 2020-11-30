package wechat.domain;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;





/**
 * 
 * @Description:微信公众号信息
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class AbstractWeChatInfo extends AbstractDomain<Integer>  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**授权方类型  1-公众号   2-小程序*/
	private Short type;
	/**公众号拥有者类型 1-平台  2-商家*/ 
	private Short owerType;
	/**头像*/
	private String headImg;
	/**商家ID*/
	private Integer storeId;
	/**商家ID*/
	private Integer store;
	/** 公众号名称 */
	private String wechatName;
	/** 公众号的主体名称*/
	private String principalName; 
	/** 公众号类型  1-普通订阅号（含历史老账号升级后的订阅号）  2-服务号 */
	private Short wechatType;
	/** 认证状态 1-未认证 2-已认证 */
	private Short verifyStatus;
	/** 原始ID */
	private String globalId;
	/**app_id*/
	private String appId;
	/**接入方式  1-授权接入*/
	private Short grantType;
	/**二维码图片地址*/
	private String qrcodeUrl;
	/**权限集，多个使用逗号分隔
	 *1.消息管理权限 2.用户管理权限 3.帐号服务权限 
	 *4.网页服务权限 5.微信小店权限 6.微信多客服权限 
	 *7.群发与通知权限 8.微信卡券权限 9.微信扫一扫权限 
	 *10.微信连WIFI权限 11.素材管理权限 
	 *12.微信摇周边权限 13.微信门店权限
	 *14.微信支付权限 15.自定义菜单权限 
	 *17.帐号管理权限 18.开发管理权限 19.客服消息管理权限 
	 * */
	private String funcInfo;
	/**微信号*/
	private String alias;
	/**小程序使用服务域名列表 ，*/
	private String network;
	/**小程序服务类目*/
	private String categories;
	/**小程序是否开启第三方登陆，公众号请忽略该字段*/
	private Boolean isOpenThirdLogin;
	
	public AbstractWeChatInfo() {
	}
	


}