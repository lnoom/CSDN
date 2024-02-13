package com.yu.pojo;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-02-03 14:58
 */
public class Hello {
    private String name;
    public Hello() {
        System.out.println("user无参构造方法");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void showName(){
        System.out.println("Hello,"+ name );
    }
}