package com.xfj.spider.util;


import com.xfj.spider.excption.HttpClientApiException;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lixuefeng
 * @date 2017年11月17日 09:48:47
 * modify 2018-10-17
 */
public class HttpClientUtil {

    private static final String apiErrorMessage = "API 接口连接建立异常";

    private static final String apiNot200Message = "API 接口Post请求返回非200状态码";
    /**
     * 设置超时时间
     */
    private static final RequestConfig requestConfig=RequestConfig.custom()
            .setConnectTimeout(5000).setConnectionRequestTimeout(1000)
            .setSocketTimeout(5000).build();

    //private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private static HttpUriRequest doPostMethod(String url, Map<String, String> param) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        // 创建参数列表
        if (param != null) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : param.keySet()) {
                paramList.add(new BasicNameValuePair(key, param.get(key)));
            }
            // 模拟表单
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
            httpPost.setEntity(entity);
        }
        return httpPost;
    }
    private static HttpUriRequest doGetMethod(String url, Map<String, String> param) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(url);
        if (param != null) {
            for (String key : param.keySet()) {
                builder.addParameter(key, param.get(key));
            }
        }
        URI uri = builder.build();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setConfig(requestConfig);
        return httpGet;
    }
    private static HttpUriRequest doPostMethod(String url, Map<String, String> param, MultipartFile[] images) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();

            if (images != null) {
                //读取上传multipartFile文件
                for (int i = 0; i < images.length; i++) {
                    mEntityBuilder.addBinaryBody("file" + i + 1, images[i].getBytes());
                }
            }
            if (null != param) {
                ContentType contentType = ContentType.create("text/plain", Charset.forName("UTF-8"));
                for (String key : param.keySet()) {
                    String value = param.get(key);
                    value = value == null ? "" : value;
                    mEntityBuilder.addTextBody(key, value, contentType);
                }
            }
            httpPost.setEntity(mEntityBuilder.build());
            return httpPost;
    }
    private static JSONObject doMethod(String doMethod,String url, Map<String, String> param, MultipartFile[] images){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString;
        try {
            HttpUriRequest httpUriRequest = null;
            if ("post".equals(doMethod)){
                if(images == null){
                    httpUriRequest= doPostMethod(url, param);
                } else {
                    httpUriRequest = doPostMethod(url,param,images);
                }
            } else if("get".equals(doMethod)) {
                httpUriRequest= doGetMethod(url, param);
            }

            // 执行http请求
            // 输出接口地址
            //logger.error("url path" + url);

            response = httpClient.execute(httpUriRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                resultString = EntityUtils.toString(response.getEntity(), "utf-8");
                // 消耗掉response
                EntityUtils.consume(resEntity);
            }else {
                throw new HttpClientApiException(apiNot200Message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if( e instanceof HttpClientApiException){
                throw new HttpClientApiException(apiNot200Message);
            }
            throw new HttpClientApiException(apiErrorMessage);
        } finally {

            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);

        }

        if (resultString != null) {
            return JSONObject.fromObject(resultString);
        } else {
            return null;
        }
    }
    public static JSONObject doGet(String url, Map<String, String> param) {
        // 创建Httpclient对象
       return doMethod("get", url, param,null);
    }

    public static JSONObject doGet(String url) {
        return doGet(url, null);
    }

    public static JSONObject doPost(String url, Map<String, String> param) {
        // 创建Httpclient对象
       return doMethod("post", url, param, null);
    }

    public static JSONObject doPost(String url) {
        return doPost(url, null);
    }

    public static String doPostWithImage(String url, Map<String, String> param, MultipartFile[] images) {

        return doMethod("post",url,param,images).toString();
    }

    /**
     * 请求的参数类型为json
     *
     * @param url  链接
     * @param json Json数据
     * @return 返回结果
     * {username:"",pass:""}
     */
    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            throw new HttpClientApiException(apiErrorMessage);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return resultString;
    }
}