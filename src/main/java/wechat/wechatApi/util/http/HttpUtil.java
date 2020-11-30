package wechat.wechatApi.util.http;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import wechat.wechatApi.bean.media.MediaFile;
import wechat.wechatApi.util.http.Impl.HttpClientDelegate;
import wechat.wechatApi.util.serialize.SerializeUtil;


public class HttpUtil {


    // 如果使用了自定义的实现类需要调整该处
    private static final HttpDelegate DELEGATE = new HttpClientDelegate();

    private HttpUtil() {
    }

    public static String get(String url, Map<String, String> params) {
        return DELEGATE.get(url, params);
    }

    public static String post(String url,String mchId,String certPath, Map<String, String> params, String postData) {
        return DELEGATE.post(url, mchId,certPath,params, postData);
    }
    
    public static String post(String url, Map<String, String> params, String postData) {
        return DELEGATE.post(url, params, postData);
    }

    public static String upload(String url, Map<String, String> params,String postData, File file) {
        return DELEGATE.upload(url, params, postData,file);
    }

    public static MediaFile downloadByGet(String url, Map<String, String> params) {
        return DELEGATE.downloadByGet(url, params);
    }
    
    public static MediaFile downloadByPost(String url, Map<String, String> params,String data) {
        return DELEGATE.downloadByPost(url, params,data);
    }
    
    public static byte[] readURLImage(String imageUrl) throws IOException{
    	return DELEGATE.readURLImage(imageUrl);
    }
    

    public static <T> T getJsonBean(String url, Map<String, String> params, Class<T> clazz) {
        return SerializeUtil.jsonToBean(get(url, params), clazz);
    }

    public static <T> T postJsonBean(String url, Map<String, String> params, String postData, Class<T> clazz) {
        return SerializeUtil.jsonToBean(post(url, params, postData), clazz);
    }
    
    public static <T> T postJsonBean(String url, String mchId,String certPath,Map<String, String> params, String postData, Class<T> clazz) {
        return SerializeUtil.jsonToBean(post(url, mchId,certPath,params, postData), clazz);
    }
    
    public static <T> T postXmlBean(String url, String mchId,String certPath,Map<String, String> params, String postData, Class<T> clazz) {
        return SerializeUtil.xmlToBean(post(url, mchId,certPath,params, postData), clazz);
    }
    
    public static <T> T uploadJsonBean(String url, Map<String, String> params,String postDate, File file, Class<T> clazz) {
        return SerializeUtil.jsonToBean(upload(url, params,postDate, file), clazz);
    }

    public static <T> T getXmlBean(String url, Map<String, String> params, Class<T> clazz) {
        return SerializeUtil.xmlToBean(get(url, params), clazz);
    }

    public static <T> T postXmlBean(String url, Map<String, String> params, String postData, Class<T> clazz) {
        return SerializeUtil.xmlToBean(post(url, params, postData), clazz);
    }
    
    public static void main(String[] args) {
	}

}
