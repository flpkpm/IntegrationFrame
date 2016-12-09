package com.epaylinks.myfirstframe.http;

import java.util.ArrayList;

public class QuestionLists {
	private ArrayList<Question> queryList;

	public ArrayList<Question> getQueryList() {
		return queryList;
	}

	public void setQueryList(ArrayList<Question> queryList) {
		this.queryList = queryList;
	}

	@Override
	public String toString() {
		return "QuestionLists [queryList=" + queryList + "]";
	}
	
	
}
