package wechat.domain;


import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 粉丝统计信息实体类
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class FansStatistics extends AbstractDomain<Integer> implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** 全局唯一标识符 */
	private Integer id;
	/** 公众号或小程序appId */
	private String appId;
	/** 新关注用户数 */
	private Integer newUser;
	/** 取消关注用户数 */
	private Integer cancelUser;
	/** 净增关注人数 */
	private Integer netGrowthUser;
	/** 累计关注人数 */
	private Integer countUser;
	/**时间*/
	private String statisticsDate; 
   

	
}
