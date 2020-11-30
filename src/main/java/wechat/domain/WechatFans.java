package wechat.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
*
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatFans extends AbstractDomain<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	/** 用户所属公众号的appId */
	private String appId;
	/**
	 * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息，只有openid和UnionID（在该公众号绑定到了微信开放平台账号时才有）
	 */
	private Integer subscribe;
	/** 用户的标识 */
	private String openid;
	/** 用户的昵称 */
	private String nickname;
	/** 用户的性别 */
	private Integer sex;
	/** 用户所在城市 */
	private String city;
	/** 用户所在省份 */
	private String province;
	/** 用户所在国家 */
	private String country;
	/** 用户的语言，简体中文为zh_CN */
	private String language;
	/** 用户头像 */
	private String headimgurl;
	/** 用户关注时间 */
	private long subscribeTime;
	/** unionid */
	private String unionid;
	/** 粉丝的备注 */
	private String remark;
	/** 分组ID */
	private Integer groupid;
	/** 用户关注的渠道来源 */
	private String subscribeScene;
	/** 二维码扫码场景 */
	private String qrScene;
	/** 二维码扫码场景描述 */
	private String qrSceneStr;
	/** 是否是黑名单 **/
	private Boolean isBlackList;
	/**标签列表**/
	private String tagidList;
	public WechatFans() {
	}


}