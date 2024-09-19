package com.lmh.ph.util;
/*
* 系统编码：不是Http协议的响应码，是我们自定义的用来针对某些情况给与的响应码
* 作用：当后台向前端响应的时候，除了响应数据以外，还要响应一些编码，前端通过这些编码可以判断操
作是成功，还是失败，以及失败的原因等。
* 比如用户名和密码不是代码错误，只是没有匹配到对应的数据，但是在业务角度来看就是错误，我们可以
响应指定的编码来告知前端问题所在。
*
*/
public enum SystemCode {
    OK(200, "成功"),
    USERNAME_EXISTS(401, "用户名已存在"),
    USERNAME_ERROR(402, "用户名或密码错误"),
    NO_USER(403, "用户不存在"),
    NOT_LOGIN(404, "用户未登录"),
    NO_PERMISSION(405, "权限不足，禁止访问"),
    ERROR(500, "失败");
    int code;
    String message;
    SystemCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}