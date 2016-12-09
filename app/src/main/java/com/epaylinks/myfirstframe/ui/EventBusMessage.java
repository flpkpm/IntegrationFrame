package com.epaylinks.myfirstframe.ui;

/**
 * Created by Administrator on 2016/12/5.
 */

public class EventBusMessage {
    private String message;
    private int what;

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
