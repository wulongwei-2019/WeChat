package wechat.wechatApi.util.serialize;

import java.io.InputStream;

/**
 * 微信交互数据序列化代理实现接口.不同的序列化需要实现该接口.
 * @author: wulongwei
 * @date:   2019年1月17日 下午3:57:26     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface SerializeDelegate {

	/**
     * JSON字符串转Bean.
     */
    <T> T jsonToBean(String json, Class<T> clazz);

    /**
     * Bean转JSON字符串.
     */
    String beanToJson(Object object);

    /**
     * 将xml转换为对象.
     */
    <T> T xmlToBean(String xml, Class<T> c);
    
    /**
     * 将xml转换为对象.
     */
    <T> T xmlInputStreamToBean(InputStream xml, Class<T> c);

    /**
     * 将对象转换为xml.
     */
    String beanToXml(Object obj);
}
