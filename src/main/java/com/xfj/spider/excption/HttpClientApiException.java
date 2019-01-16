package com.xfj.spider.excption;

/**
 * HttpClientApiException
 * Created 2018/10/17
 * API接口抛出的异常
 *
 * @author Lao SiCheng
 * @version 0.1
 **/
public class HttpClientApiException extends RuntimeException {

    public HttpClientApiException() {
        super();
    }

    public HttpClientApiException(String message) {
        super(message);

    }

}
