package com.example.zpqxi.my_qq;

/**
 * Created by zpqxi on 2018/7/16.
 */

public class Msg {
    static public  final int TYPE_RECEIVED = 0;
    static public final  int TYPE_SENT =1;
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
