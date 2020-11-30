package wechat.wechatApi.util.serialize;

import java.io.InputStream;

import wechat.wechatApi.util.serialize.Impl.FastJsonSerialize;

/**
 * 序列化
 * @author: wulongwei
 * @date:   2019年1月17日 下午3:53:38     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class SerializeUtil {

    private final static SerializeDelegate SERIALIZE_DELEGATE = new FastJsonSerialize();

    /**
     * JSON字符串转Bean.
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        return SERIALIZE_DELEGATE.jsonToBean(json, clazz);
    }

    /**
     * Bean转JSON字符串.
     */
    public static String beanToJson(Object object) {
        return SERIALIZE_DELEGATE.beanToJson(object);
    }

    /**
     * 将xml转换为对象.
     */
    public static <T> T xmlToBean(String xml, Class<T> clazz) {
        return SERIALIZE_DELEGATE.xmlToBean(xml, clazz);
    }

    /**
     * 将对象转换为xml.
     */
    public static String beanToXml(Object object) {
        return SERIALIZE_DELEGATE.beanToXml(object);
    }

    /**
     * 将xml流转换为对象.
     * @return 
     */
    public static <T> T xmlInputStreamToBean(InputStream xml ,Class<T> clazz) {
        return SERIALIZE_DELEGATE.xmlInputStreamToBean(xml, clazz);
    }
}
