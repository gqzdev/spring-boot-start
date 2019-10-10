package com.gqz.springboot.exception;

/**
 * @ClassName: NoUserException
 * @author: ganquanzhong
 * @date: 2019/9/18 14:37
 */
public class UserNotExistException extends RuntimeException{


    public UserNotExistException() {
        super("aaa用户不存在！！");
    }
}
