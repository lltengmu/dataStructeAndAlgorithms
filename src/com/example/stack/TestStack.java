package com.example.stack;

public class TestStack {
    public static void main(String[] args){
        String str = "5+4+3+2*4-3";
        /*
        * 1.遍历当前字符串，获取每一个字符
        * 2.判断当前字符是运算符还是数字
        * 3.把数字存放在数字栈中，把运算符放在运算符栈中
        * 4.运算符栈：如果是空栈，则直接入栈，如果运算符栈中已存在运算符，就需要对比运算符优先级，
        *   4.1 新进来的运算符（优先级）如果如果小于等于原栈中运算符（优先级），那么需要把原运算符弹出
        *   数字栈中数字进行弹栈，进行运算，运算后的结果重新放入数字栈。新运算符入栈
        *   4.2 如果新进来的运算符（优先级）大于原符号栈中的运算符，那么新的符号直接入栈
        */
        //创建数字栈
        ArrayStack numStack = new ArrayStack(10);
        //创建符号栈
        ArrayStack symbolStack = new ArrayStack(10);
        int temp1 = 0;
        int temp2 = 0;
        int symbolChar = 0;
        int result = 0;

        String value = "";
        //获取字符串长度
        int strLength = str.length();
        //循环字符串
        for(int i = 0;i < strLength;i++){
            //获取每个字符
            char c = str.charAt(i);
            //判断字符是不是运算符
            if(symbolStack.isOper(c)){
                //如果符号栈不为空
                if(!symbolStack.isEmpty()){
                    //比较运算符的优先级
                    if(symbolStack.priority(c)<= symbolStack.priority(symbolStack.peek())){
                        /*
                        * 1.去符号栈获取栈顶的符号
                        * 2.去数字栈中获取两个数字
                        */
                        temp1 = numStack.pop();
                        temp2 = numStack.pop();
                        symbolChar = symbolStack.pop();
                        result = numStack.calculate(temp1,temp2,symbolChar);

                        //把运算结果再次放入数字栈中
                        numStack.push(result);
                        //把当前符号压入符号栈中
                        symbolStack.push(c);
                    }else {
                        symbolStack.push(c);
                    }
                }else {
                    //如果是空的符号栈,将运算符直接入栈
                    symbolStack.push(c);
                }
            }else {
                value+=c;
                if(i == strLength - 1){
                    numStack.push(Integer.parseInt(value));
                }else {
                    char data = str.substring(i + 1,i + 2).charAt(0);
                    if(symbolStack.isOper(data)){
                        numStack.push(Integer.parseInt(value));
                        value = "";
                    }
                }
            }
        }
        while (true){
            if(symbolStack.isEmpty()){
                break;
            }
            temp1 = numStack.pop();
            temp2 = numStack.pop();
            symbolChar = symbolStack.pop();
            result = numStack.calculate(temp1,temp2,symbolChar);
            numStack.push(result);
        }
        int res = numStack.pop();
        System.out.println("结果是:"+ res);
    }
}
