package com.cjy.buy.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cjy on 2018/2/28.
 */
public class PageInfoReqVo<T> implements Serializable {
 
	private static final long serialVersionUID = -2701548069774480667L;

	private List<T> data;

    private T queryData;
    

    /** 分页页码 或者pageNumber*/
    private int page;

    /** 每页记录数 或者pageSize*/
    private int size;

    /** 排序字段 */
    private String orderField;

    /** ID,分号分隔,用于批量处理 */
    private String idStrs;

    /** ID列表 */
    private List<String> idList;

    /** 开始时间 */
    private String startTime;

    /** 结束时间 */
    private String endTime;

    /** 关键字查询 */
    private String keyWord;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T getQueryData() {
        return queryData;
    }

    public void setQueryData(T queryData) {
        this.queryData = queryData;
    }

    

    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getIdStrs() {
        return idStrs;
    }

    public void setIdStrs(String idStrs) {
        this.idStrs = idStrs;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

	@Override
	public String toString() {
		return "PageInfo [data=" + data + ", queryData=" + queryData + ", page=" + page + ", size=" + size
				+ ", orderField=" + orderField + ", idStrs=" + idStrs + ", idList=" + idList + ", startTime="
				+ startTime + ", endTime=" + endTime + ", keyWord=" + keyWord + "]";
	}

	

	
    
}
