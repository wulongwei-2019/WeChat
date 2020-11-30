package wechat.wechatApi.constant;

/**
 * 素材类型
 * 
 * @author: wulongwei
 * @date: 2019年1月30日 下午3:50:09
 * @Copyright: 江西金磊科技发展有限公司 All rights reserved. Notice
 *             仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class MaterialConstant {
	
	 public static final String SUCCESS_CODE = "200";
	 
	public interface MaterialType {

		// 素材类型：图文
		public static final String REQ_MATERIAL_TYPE_NEWS = "news";

		// 素材类型：图片 2M 支持bmp/png/jpeg/jpg/gif格式
		public static final String REQ_MATERIAL_TYPE_IMAGE = "image";

		// 素材类型：音频 2M 播放长度不超过60s，mp3/wma/wav/amr格式
		public static final String REQ_MATERIAL_TYPE_VOICE = "voice";

		// 素材类型：视频 10MB，支持MP4格式
		public static final String REQ_MATERIAL_TYPE_VIDEO = "video";

		// 素材类型:缩略图 64KB，支持JPG格式
		public static final String REQ_MATERIAL_TYPE_THUMB = "thumb";
	}

	/**
	 * 图片类型后缀
	 */
	public interface ImageSuffix{
		public static final String File_SUFFIX_BMP = "bmp";
		public static final String File_SUFFIX_PNG = "png";
		public static final String File_SUFFIX_JPEG = "jpeg";
		public static final String File_SUFFIX_JPG = "jpg";
		public static final String File_SUFFIX_GIG = "gif";
	}
	
	/**
	 * 音频类型后缀
	 */
	public interface VoiceSuffix{
		public static final String File_SUFFIX_MP3 = "mp3";
		public static final String File_SUFFIX_WMA = "wma";
		public static final String File_SUFFIX_WAV = "wav";
		public static final String File_SUFFIX_AMR = "amr";
	}
	
	/**
	 * 缩略图类型
	 */
	public interface ThumbSuffix{
		public static final String File_SUFFIX_JPG = "jpg";
	}
	
	
}
