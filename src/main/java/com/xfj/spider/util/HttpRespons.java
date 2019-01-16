package com.xfj.spider.util;

import java.util.Vector;

/**
 * @类名称: HttpRespons
 * @类描述: TODO(响应对象 )
 * @创建人: xiaoxie   
 * @创建时间: 2014-9-10 下午04:38:09
 * @修改人: xiaoxie   
 * @修改时间: 2014-9-10 下午04:38:09
 * @修改备注: 
 * @version 1.0
 
 */
public class HttpRespons {  
   
    String urlString;  
   
    int defaultPort;  
   
    String file;  
   
    String host;  
   
    String path;  
   
    int port;  
   
    String protocol;  
   
    String query;  
   
    String ref;  
   
    String userInfo;  
   
    String contentEncoding;  
   
    String content;  
   
    String contentType;  
   
    int code;  
   
    String message;  
   
    String method;  
   
    int connectTimeout;  
   
    int readTimeout;  
   
    Vector<String> contentCollection;  
   
    public String getContent() {  
        return content;  
    }  
   
    public String getContentType() {  
        return contentType;  
    }  
   
    public int getCode() {  
        return code;  
    }  
   
    public String getMessage() {  
        return message;  
    }  
   
    public Vector<String> getContentCollection() {  
        return contentCollection;  
    }  
   
    public String getContentEncoding() {  
        return contentEncoding;  
    }  
   
    public String getMethod() {  
        return method;  
    }  
   
    public int getConnectTimeout() {  
        return connectTimeout;  
    }  
   
    public int getReadTimeout() {  
        return readTimeout;  
    }  
   
    public String getUrlString() {  
        return urlString;  
    }  
   
    public int getDefaultPort() {  
        return defaultPort;  
    }  
   
    public String getFile() {  
        return file;  
    }  
   
    public String getHost() {  
        return host;  
    }  
   
    public String getPath() {  
        return path;  
    }  
   
    public int getPort() {  
        return port;  
    }  
   
    public String getProtocol() {  
        return protocol;  
    }  
   
    public String getQuery() {  
        return query;  
    }  
   
    public String getRef() {  
        return ref;  
    }  
   
    public String getUserInfo() {  
        return userInfo;  
    }  
   
}  