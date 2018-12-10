package com.xfj.spider.util;


import com.xfj.spider.common.Constant;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/** 网络请求工具类
 * Created by lee on 2017/5/17.
 */
public class HttpUtil {
   static{
       System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");

       System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");

       System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "debug");// "stdout"为标准输出格式，"debug"为调试模式
   }

    public static String getHtml2(String addr){
        InputStream in = null;
        InputStreamReader isr = null;
        HttpURLConnection con  = null;
        BufferedReader bufr = null;
        StringBuffer respContent = new StringBuffer("");
        try {
            URL url = new URL(addr);

        /*    SocketAddress sa = new InetSocketAddress("164.177.15.163", 3129);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, sa);
*/
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-type", "text/html");
            con.setRequestProperty("Accept-Charset", "utf-8");
            con.setRequestProperty("contentType", "utf-8");


            in = con.getInputStream();
            isr = new InputStreamReader(in,"utf-8");
            bufr = new BufferedReader(isr);
            String str;

            while ((str = bufr.readLine()) != null) {
                respContent.append(str);
            }

           /* int responCode = con.getResponseCode();
            if(responCode == 200){
*/

           return respContent.toString();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        finally{
            try {
                if(in!=null)
                    in.close();

                if(isr!=null)
                    isr.close();

                if(bufr !=null)
                    bufr.close();

                if(con!=null)
                    con.disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }


    public static String getData(String url) throws ClassNotFoundException, IOException {
        String entity = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //设置超时处理
        RequestConfig config = RequestConfig.custom().setConnectTimeout(Constant.CONNECT_TIME_OUT).
                setSocketTimeout(Constant.CONNECT_TIME_OUT).build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);

        try {
            //客户端执行httpGet方法，返回响应
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            //得到服务响应状态码
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                entity = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
            }

            httpResponse.close();
            httpClient.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static String getData(String url, String ip, Integer port) throws ClassNotFoundException, IOException {
        String entity = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //设置代理访问和超时处理
        HttpHost proxy = new HttpHost(ip, port);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(Constant.PROXY_CONNECT_TIME_OUT).
                setSocketTimeout(Constant.PROXY_CONNECT_TIME_OUT).build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);

        try {
            //客户端执行httpGet方法，返回响应

            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            //得到服务响应状态码
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                entity = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
            }

            httpResponse.close();
            httpClient.close();
        } catch (ClientProtocolException e) {
            entity = null;
        } catch (IOException e) {
            entity = null;
        }

        return entity;
    }


    /**
     * 发送POST请求（HTTP），K-V形式
     * @param url
     * @param params
     * @author Charlie.chen
     * @return
     */
    public static String doPost(String url, Map<String, String> params) {

        // 创建默认的HttpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            // 定义一个get请求方法
            HttpPost httppost = new HttpPost(url);

            // List<namevaluepair> parameters = new ArrayList<namevaluepair>();
            // parameters.add(new BasicNameValuePair("username", userName));
            // parameters.add(new BasicNameValuePair("password", password));

            // 定义post请求的参数
            // 建立一个NameValuePair数组，用于存储欲传送的参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                httppost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
            }


           // httppost.setHeader("Content-type","application/json,charset=utf-8");
             //httppost.setHeader("Accept", "application/json");


            // 执行post请求，返回response服务器响应对象, 其中包含了状态信息和服务器返回的数据
            CloseableHttpResponse httpResponse = httpclient.execute(httppost);

            // 使用响应对象, 获得状态码, 处理内容
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // 使用响应对象获取响应实体
                HttpEntity entity = httpResponse.getEntity();
                // 将响应实体转为字符串
                String response = EntityUtils.toString(entity, "utf-8");
                return response;

            } else {
                // log.error("访问失败"+statusCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接, 和释放资源
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
