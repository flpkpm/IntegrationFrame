package com.epaylinks.myfirstframe.http;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/7.
 */

public interface  RequestService {
    @POST("/security/questionList.do")
    Observable<HttpResposeBean<QuestionLists>> getQuestionList();
    

}
