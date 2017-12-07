package common.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

public class HttpUtil {
	public static int get(String url) {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		int statusCode = 404;
		try {
			statusCode = client.executeMethod(method);
		} catch (Exception e) {
			statusCode = 400;
		}
		method.releaseConnection();
		return statusCode;
	}

	public static String get(String url, String charset) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		client.executeMethod(method);
		String response = new String(method.getResponseBodyAsString().getBytes(charset));
		method.releaseConnection();
		return response;
	}

	public static String post(String url, Map<String, String> params, String charset) throws Exception {
		return post(url,params,charset,charset);
	}
	public static String post(String url, Map<String, String> params, String requestCharset, String responseCharset) throws Exception {
		HttpClient client = new HttpClient();
		PostMethod method = null;
		String response = null;
		try {
			method = new PostMethod(url);
			method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + requestCharset);
			if (params != null) {
				Set<String> keySet = params.keySet();

				for (String key : keySet) {
					String value = params.get(key);
					if (value != null){
						method.addParameter(key, value);
					}
				}
			}
			int statusCode = client.executeMethod(method);
			if(statusCode == HttpStatus.SC_OK){
				InputStream inputStream = method.getResponseBodyAsStream();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,requestCharset));
				StringBuilder stringBuilder = new StringBuilder();
				String lineString = "";
				while((lineString = bufferedReader.readLine()) != null){
					stringBuilder.append(lineString);
				}
				response = stringBuilder.toString();
			}else{
				throw new Exception("http请求["+url+"]返回响应码["+statusCode+"],响应异常");
			}
			//response = new String(method.getResponseBodyAsString().getBytes(responseCharset));
			//200判断
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			method.releaseConnection();
		}
		return response;
	}
}
