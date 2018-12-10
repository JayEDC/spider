package com.xfj.spider.cache.model;

/**
 * @ClassName Ipmodel
 * @Description //TODO
 * @Author xnc
 * @Date 2018/12/43:22 PM
 * @return 1.0
 **/
public class Ipmodel {

    //IP地址
    public String ip;

    //端口号
    public Integer port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "IpModel{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }

}
