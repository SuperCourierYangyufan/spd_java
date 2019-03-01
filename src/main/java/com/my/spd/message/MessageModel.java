package com.my.spd.message;

/**
 * Created by YangYuFan on 2019/2/2.
 */
public class MessageModel {
    private String code;
    private String message;
    private Object data;

    public static MessageModel success(Object data){
        MessageModel modle = new MessageModel();
        modle.setCode("0");
        modle.setMessage("success");
        modle.setData(data);
        return modle;
    }

    public static MessageModel success(Object data,String message){
        MessageModel modle = new MessageModel();
        modle.setCode("0");
        modle.setMessage(message);
        modle.setData(data);
        return modle;
    }

    public static MessageModel fail(String message){
        MessageModel modle = new MessageModel();
        modle.setCode("1");
        modle.setMessage(message);
        return modle;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
