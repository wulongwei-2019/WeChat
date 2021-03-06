package wechat.wechatApi.util.http;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wechat.wechatApi.bean.media.MediaFile;
import wechat.wechatApi.constant.wechatConstant;


public class AbstractHttpClient {


	protected static final StringResponseHandler STRING_HANDLER = new StringResponseHandler();
	protected static final MediaFileResponseHandler FILE_HANDLER = new MediaFileResponseHandler();
	// 指定超时间隔（1.5小时）
	protected static final Long REFER_TIME = 5400000L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractHttpClient.class);

	/**
	 * 构造GET请求.
	 */
	protected static HttpUriRequest buildGetRequest(String url, Map<String, String> params) {
		return buildRequest(HttpGet.METHOD_NAME, url, params, null, null);
	}

	/**
	 * 构造POST请求.
	 */
	protected static HttpUriRequest buildPostRequest(String url, Map<String, String> params, String data) {
		return buildRequest(HttpPost.METHOD_NAME, url, params, data, null);
	}

	/**
	 * 构造文件上传请求.
	 */
	protected static HttpUriRequest buildUploadRequest(String url, Map<String, String> params, String data, File file) {
		return buildRequest(HttpPost.METHOD_NAME, url, params, data, file);
	}

	/**
	 * 构造HttpUriRequest请求.
	 *
	 * @param method
	 *            请求方法
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求(key,value)数据
	 * @param data
	 *            请求体文本数据
	 * @param file
	 *            请求体二进制文件
	 */
	protected static HttpUriRequest buildRequest(String method, String url, Map<String, String> params, String data,
			File file) {
		RequestBuilder builder = RequestBuilder.create(method).setUri(url);
		if (params != null) {
			for (String key : params.keySet()) {
				builder.addParameter(new BasicNameValuePair(key, params.get(key)));
			}
		}
		if (data != null) {
			builder.setEntity(new StringEntity(data, wechatConstant.Charset.UTF_8));
		}
		if (file != null) {
			MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create().addBinaryBody("media", file);
			builder.setEntity(entityBuilder.build());
		}
		return builder.build();
	}

	private static class StringResponseHandler implements ResponseHandler<String> {
		@Override
		public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			int status = response.getStatusLine().getStatusCode();
			if (status >= 200 && status < 300) {
				HttpEntity entity = response.getEntity();
				String str = EntityUtils.toString(entity, "UTF-8");
				LOGGER.debug(java.text.Normalizer.normalize(String.format("Get response: %s", str),
						java.text.Normalizer.Form.NFKD));
				return str;
			} else {
				throw new ClientProtocolException("Unexpected response status:" + status);
			}
		}
	}

	private static class MediaFileResponseHandler implements ResponseHandler<MediaFile> {
		@Override
		public MediaFile handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			MediaFile mediaFile = new MediaFile();
			int status = response.getStatusLine().getStatusCode();
			if (status >= 200 && status < 300) {
				Header dispositionHeader = response.getFirstHeader("Content-disposition");
				if (dispositionHeader != null) {
					String ds = response.getFirstHeader("Content-disposition").getValue();
					String fullName = ds.substring(ds.indexOf("filename=\"") + 10, ds.length() - 1);
					String relName = fullName.substring(0, fullName.lastIndexOf("."));
					String suffix = fullName.substring(relName.length() + 1);
					mediaFile.setFullName(fullName);
					mediaFile.setFileName(relName);
					mediaFile.setSuffix(suffix);
				}
				mediaFile.setContentLength(response.getEntity().getContentLength());
				//mediaFile.setFileStream(FileUtils.convertInputStreamToByte(response.getEntity().getContent()));

			}
			return mediaFile;
		}
	}


}
