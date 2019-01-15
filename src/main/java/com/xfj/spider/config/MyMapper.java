package com.xfj.spider.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Lao SiCheng
 * @version 0.1
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
