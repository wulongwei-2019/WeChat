package wechat.wechatApi.bean.request.news;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wechat.wechatApi.bean.media.BaseMessage;



/**
 * 回复图片
 * @author: wulongwei
 * @date:   2019年1月17日 下午2:11:15     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@XStreamAlias("xml") 
public class ImageMessageRequest extends BaseMessage{

	@XStreamAlias("Image")
	private Image image;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public static class Image{
		
	
	/**通过素材管理中的接口上传多媒体文件，得到的id。*/
	@XStreamAlias("MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	}
	

}
