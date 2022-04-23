package com.example.redisexample.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mirau on 2022/4/20.
 * @version 1.0
 */
@AllArgsConstructor
@Getter
public enum State {

    /**
     * 初始化
     */
    INIT(1, "初始化"),;
    private int code;
    private String name;
}
class BB{
    public static void main(String[] args) {
        int code = State.INIT.getCode();
        int ordinal = Color.RED.ordinal();
    }
}
