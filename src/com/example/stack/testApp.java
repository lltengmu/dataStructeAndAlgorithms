package com.example.stack;

public class testApp {
    public static void main(String[] args){
        /*
        * 回文数据：
        * 回文： aba racecar 一个单词从前往后还是从后往前读都是一样的
        * 需求：以数组模拟栈来判断一个字符串是否是一个回文数据
        */
        System.out.println(dateCation("aba"));
    }
    public static boolean dateCation(String value){
        /*
        * 初始化栈对象
        */
        ArrayStack arrayStack = new ArrayStack(10);
        //获取字符串长度
        int length = value.length();
        for(int i = 0;i < length;i++){
            arrayStack.push(value.charAt(i));
        }

        String newValue = "";
        int length1 = arrayStack.length();
        for(int i = 0; i < length1;i++){
            if(!arrayStack.isEmpty()){
                char pop = (char) arrayStack.pop();
                newValue = newValue + pop;
            }
        }
        if(value.equals(newValue)){
            return true;
        }
        return false;
    }
}
