package wechat.wechatApi.bean.media;

import java.io.ByteArrayOutputStream;

import lombok.Data;
import lombok.ToString;
/**
 * 媒体文件类
 * @author: wulongwei
 * @date:   2019年2月1日 下午2:20:41     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
@ToString
public class MediaFile {


    private String fileName;
    private String fullName;
    private String suffix;
    private long contentLength;
    private String contentType;
    /**InputStream 首次读取至末尾，后续再次读取，stream已关闭无法操作，
     * 	此处将InputStream先转换成ByteArrayOutputStream，后续需要使用再次转换成InputeStream*/
    private ByteArrayOutputStream fileStream;
    
    private String error;

   

}
