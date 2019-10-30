package com.example.demo.common.entity;

import net.sf.json.JSONObject;

/**
 * @Description： 响应消息对象
**/
public class MsgModel {

    /**
     * @Description: 响应状态码
    **/
    private String status;

    /**
     * @Description: 响应消息内容
    **/
    private String msg;

    /**
     * @Description: 响应数据
    **/
    private Object data;

    public String getStatus() {
        return status;
    }

    /**
     * 自定义状态值请勿与 ResponseStatusUtil 中定义冲突
     * <p>方法名称: setStatus|描述: 设置响应状态码</p>
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toJsonString() {
        return JSONObject.fromObject(this).toString();
    }

}