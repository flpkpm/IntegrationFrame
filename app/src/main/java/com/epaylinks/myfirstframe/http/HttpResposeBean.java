package com.epaylinks.myfirstframe.http;

public class HttpResposeBean<T> {
	private String resp_msg="";
	private String resp_code="";
	private T response_detail;

	public String getResp_msg() {
		return resp_msg;
	}
	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
	public T getResponse_detail() {
		return response_detail;
	}
	public void setResponse_detail(T response_detail) {
		this.response_detail = response_detail;
	}

	@Override
	public String toString() {
		return "HttpResposeBean [resp_msg=" + resp_msg + ", resp_code="
				+ resp_code + ", response_detail=" + response_detail + "]";
	}
	
	
	
}
