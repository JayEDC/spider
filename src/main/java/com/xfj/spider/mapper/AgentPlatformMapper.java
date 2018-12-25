package com.xfj.spider.mapper;

import com.xfj.spider.model.AgentPlatform;
import com.xfj.spider.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 平台表信息表 Mapper 接口
 * AgentPlatformMapper
 * @author xnc
 * @since 2018-12-11
 */
@Mapper
public interface AgentPlatformMapper extends MyMapper<AgentPlatform> {

//    Integer getAgentPlatformId(@Param("telephone") String telephone,
//                               @Param("name") String name,
//                               @Param("company") String company,
//                               @Param("pmId") Integer pmId);
Integer getAgentPlatform(Map<String,Object> map);
}
