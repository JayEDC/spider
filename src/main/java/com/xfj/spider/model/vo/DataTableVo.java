package com.xfj.spider.model.vo;

/**
 * @ClassName DataTableVo
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/145:37 PM
 * @return 1.0
 **/
public class DataTableVo {

    /**
     * dataTable 开始页面
     */
    private int start;
    /**
     * dataTable 每页长度
     */
    private int length;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
