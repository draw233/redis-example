package com.example.redisexample.config;

/**
 * @author mirau on 2022/4/20.
 * @version 1.0
 */
public enum Color {
    /**
     * 红
     */
    RED {
        @Override
        public String colorName() {
            return "Red";
        }
    },
    /**
     * 绿色
     */
    GREEN {
        @Override
        public String colorName() {
            return "green";
        }
    },
    /**
     * 蓝色
     */
    BLUE {
        @Override
        public String colorName() {
            return "blue";
        }
    },
    ;

    public abstract String colorName();
}

abstract class A {
    public static void main(String[] args) {
        Color blue = Color.valueOf("BLUE");
        System.out.println(blue.colorName());
        String s = Color.BLUE.colorName();
    }
}