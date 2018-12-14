package com.xfj.spider.mapper;

import com.xfj.spider.model.EsfToolsSpiderProxyIp;
import com.xfj.spider.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  Mapper 接口
 * EsfToolsSpiderProxyIpMapper
 * @author xnc
 * @since 2018-12-04
 */
@Mapper
public interface EsfToolsSpiderProxyIpMapper extends MyMapper<EsfToolsSpiderProxyIp> {
    List<EsfToolsSpiderProxyIp> getFastProxyIpAll();

    int delNotFastProxyIp();
}
