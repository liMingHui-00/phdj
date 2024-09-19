package com.lmh.ph.util;

/**
 * 响应格式类
 * 作用：统一服务端的响应数据格式
 */
public class Result<T> {
    /**
     * 响应代码
     */
    private int status;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;
	
    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    /**
     * 成功的响应：不传递数据到页面
     */
    public static Result success() {

        return new Result(SystemCode.OK.getCode(), SystemCode.OK.getMessage(),
                null);
    }
    /**
     * 成功的响应：传递数据到页面
     */
    public static <T> Result success(T data) {
        return new Result(SystemCode.OK.getCode(), SystemCode.OK.getMessage(),
                data);
    }
    /**
     * 失败的响应：不传递数据到页面
     */
    public static Result error() {
        return new Result(SystemCode.ERROR.getCode(),
                SystemCode.ERROR.getMessage(), null);
    }
    /**
     * 失败的响应：传递数据到页面
     */
    public static <T> Result error(T data) {
        return new Result(SystemCode.ERROR.getCode(),
                SystemCode.ERROR.getMessage(), data);
    }
    /**
     * 失败的响应：传递数据到页面，并且传递响应码和响应信息
     */
    public static <T> Result error(int status, String message, T data) {
        return new Result(status, message, data);
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }public void setData(T data) {
        this.data = data;
    }
}
