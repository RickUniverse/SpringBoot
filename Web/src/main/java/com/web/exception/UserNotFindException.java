package com.web.exception;

/**
 * @author lijichen
 * @date 2021/1/4 - 20:19
 */
public class UserNotFindException extends RuntimeException{
    public UserNotFindException() {
        super("用户未找到！");
    }
}
