package wechat.domain;

import java.io.Serializable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @Description: 微信素材实体类
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=true) //子类继承使用@Data注解时
public class WechatMaterial extends AbstractDomain<Integer> implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 主键值*/ 
	private Integer id;
	/** 所属公众号appId*/ 
	private String appId;
	/** 素材类型图片（image）、视频（video）、语音 （voice）、图文（news）*/
	private String mediaType;
	/** 微信服务器标识的素材ID*/
	private String mediaId;
	/** 素材json数据包，微信服务器返回*/
	private String materialJson;
	/** 如果查询的素材类型是非news类型，则会将materialJson转换成Json类型且set入该属性 */
    private JSONObject request  =  new JSONObject();
    /** 如果查询的素材类型是news类型，则会将materialJson转换成Json类型且set入该属性 */
    private JSONArray requestArray=new JSONArray();
    /**微信服务器返回的修改时间*/
    private String wechatUpdateTime;
	
}
