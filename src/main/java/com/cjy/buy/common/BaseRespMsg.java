/**
 * 
 */
package com.cjy.buy.common;

import java.io.Serializable;


/**
 * @author cjy
 *
 */
public class BaseRespMsg implements Serializable{
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 响应码 */
	private int status = 0;

	/** 响应信息 */
	private String msg = "success";
	
	
	
	
	public boolean isSuccess() {
		return 0 == this.status;
	}

	public BaseRespMsg() {
		
	}
	
	public BaseRespMsg(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	public static BaseRespMsg error() {
		return new BaseRespMsg(99, "未知错误！");
	}

	public static BaseRespMsg error(String msg) {
		return new BaseRespMsg(99, msg);
	}

   

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BaseRespMsg [status=" + status + ", msg=" + msg + "]";
	}

	
	
	
	
}
