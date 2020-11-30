package wechat.wechatApi.util.http;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import wechat.wechatApi.bean.media.MediaFile;


public interface HttpDelegate {



	/**
	 * 发送GET请求
	 * @Title: get
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param: @return
	 * @return: String
	 */
	String get(String url, Map<String, String> params);

	/**
	 * 发送POST请求
	 * @Title: post
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param: postData
	 *             formdata中参数
	 * @param: @return
	 * @return: String
	 */
	String post(String url, Map<String, String> params, String postData);

	public String post(String url, String mchId, String certPath, Map<String, String> params, String postData);

	/**
	 * 上传文件，
	 * @Title: upload
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param: file
	 *             文件
	 * @param: @return
	 * @return: String
	 */
	String upload(String url, Map<String, String> params, String data, File file);

	/**
	 * 下载文件（GET请求）
	 * @Title: download
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param: @return
	 * @return: MediaFile
	 */
	MediaFile downloadByGet(String url, Map<String, String> params);

	/**
	 * 下载文件（POST请求）
	 * @Title: downloadByPost
	 * @param: @param
	 *             url
	 * @param: @param
	 *             params
	 * @param: @param
	 *             data
	 * @param: @return
	 * @return: MediaFile
	 */
	MediaFile downloadByPost(String url, Map<String, String> params, String data);

	/**
	 * 发送GET请求
	 * @Title: getJsonBean
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param: clazz
	 *             转换bean的clazz
	 * @param: @return
	 * @return: T
	 */
	<T> T getJsonBean(String url, Map<String, String> params, Class<T> clazz);

	/**
	 * 
	 * @Title: postJsonBean
	 * @Description: 发送POST请求
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param: postData
	 *             formdata中参数
	 * @param: clazz
	 *             转换bean的clazz
	 * @param: @return
	 * @return: T
	 */
	<T> T postJsonBean(String url, Map<String, String> params, String postData, Class<T> clazz);

	/**
	 * 
	 * @Title: uploadJsonBean
	 * @Description: 上传文件自动抛出异常，全局已捕获
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param postData
	 *            formdata中参数
	 * @param: file
	 *             文件
	 * @param: clazz
	 *             转换bean的clazz
	 * @param: @return
	 * @return: T
	 */
	<T> T uploadJsonBean(String url, Map<String, String> params, String postData, File file, Class<T> clazz);

	/**
	 * 
	 * @Title: getXmlBean
	 * @Description: 发送GET请求权，系统会自动抛出异常，全局已捕获
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param: clazz
	 *             转换bean的clazz
	 * @param: @return
	 * @return: T
	 */
	<T> T getXmlBean(String url, Map<String, String> params, Class<T> clazz);

	/**
	 * 
	 * @Title: postXmlBean
	 * @Description: 发送POST请求
	 * @param: url
	 *             请求URL
	 * @param: params
	 *             url params 中参数
	 * @param: postData
	 *             formdata 参数
	 * @param: clazz
	 *             转换bean的clazz
	 * @param: @return
	 * @return: T
	 */
	<T> T postXmlBean(String url, Map<String, String> params, String postData, Class<T> clazz);

	/**
	 * 
	 * @Title: readInputStream
	 * @Description: 将inputstream转成byte数组
	 * @param: @param
	 *             inStream
	 * @param: @return
	 * @param: @throws
	 *             Exception
	 * @return: byte[]
	 */
	byte[] readInputStream(InputStream inStream) throws IOException;

	/**
	 * 
	 * @Title: readURLImage
	 * @Description: 读取网络图片转成byte数组
	 * @param: @param
	 *             imageUrl
	 * @param: @return
	 * @return: byte[]
	 */
	byte[] readURLImage(String imageUrl) throws IOException;


}
