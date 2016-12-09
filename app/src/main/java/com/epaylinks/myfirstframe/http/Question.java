package com.epaylinks.myfirstframe.http;

public class Question {
	private String queryId="";
	private String queryDescCn="";
	private String queryDescTw="";
	private String queryDescEn="";

	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	public String getQueryDescCn() {
		return queryDescCn;
	}
	public void setQueryDescCn(String queryDescCn) {
		this.queryDescCn = queryDescCn;
	}
	public String getQueryDescTw() {
		return queryDescTw;
	}
	public void setQueryDescTw(String queryDescTw) {
		this.queryDescTw = queryDescTw;
	}
	public String getQueryDescEn() {
		return queryDescEn;
	}
	public void setQueryDescEn(String queryDescEn) {
		this.queryDescEn = queryDescEn;
	}
	@Override
	public String toString() {
		return "Question [queryId=" + queryId + ", queryDescCn=" + queryDescCn
				+ ", queryDescTw=" + queryDescTw + ", queryDescEn="
				+ queryDescEn + "]";
	}
	
	
}
