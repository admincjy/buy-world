package com.cjy.buy.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class BaseRespData implements Serializable{
     
	
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private long dataCount = 0;
	
	private int  staus = 0;

	private Object obData;
	
	private List aaData = new ArrayList();

	public long getDataCount() {
		return dataCount;
	}

	public void setDataCount(long dataCount) {
		this.dataCount = dataCount;
	}

	public int getStaus() {
		return staus;
	}

	public void setStaus(int staus) {
		this.staus = staus;
	}

	public List getAaData() {
		return aaData;
	}

	public void setAaData(List aaData) {
		this.aaData = aaData;
	}

	public Object getObData() {
		return obData;
	}

	public void setObData(Object obData) {
		this.obData = obData;
	}

	@Override
	public String toString() {
		return "BaseRespData [dataCount=" + dataCount + ", staus=" + staus + ", obData=" + obData + ", aaData=" + aaData
				+ "]";
	}

	
	
	
	
	
}
