package com.example.stack;

public class ArrayStack {
    /*
    *定义栈的大小
    */
    private int maxStack;
    /*
    *数组用来模拟栈
    */
    private int[] stack;
    //定义栈顶所在的位置，默认情况下是-1
    private int top = -1;
    public ArrayStack(int maxStack){
        this.maxStack = maxStack;
        this.stack = new int[maxStack];
    }
    /*
    * 需要考虑的几个问题
    * 1.压栈
    * 2.弹栈
    * 3.判断是否是空栈
    * 4.当前栈是否是处于满栈的状态
    */

    //先定义一个函数判断是否满栈
    public boolean isFull(){
        return this.top == this.maxStack - 1;
    }
    //定义一个函数用于判断当前栈是否是空栈
    public boolean isEmpty(){
        return this.top == -1;
    }
    //压栈
    public void push(int value){
        //压栈前先判断当前栈是否栈满
        if(this.isFull()){
            throw new RuntimeException("此栈已满");
        }
        top++;
        stack[top] = value;
    }
    //弹栈
    public int pop(){
        //将元素弹出栈是需要先判断栈是否为空
        if(this.isEmpty()){
            throw new RuntimeException("空栈，为找到数据");
        }
        int value = stack[top];
        top--;
        return value;
    }
    /*
    * 查看栈中所有元素
    */
    public void list (){
        //判断是否是空栈
        if(isEmpty()){
            throw  new RuntimeException("空栈，为找到数据");
        }
        for(int i = 0;i<stack.length;i++){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
    //栈长度
    public int length(){
        return this.top + 1;
    }

    /*
    * 判断是否是一个运算符 + - * /
    */
    public boolean isOper(char chr){
        return chr == '+' || chr == '-' || chr == '*' || chr == '/';
    }
    /*
    * 判断运算符优先级
    */
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1;
        }
    }
    /*
    * 查看栈顶数据
    */
    public int peek(){
        return this.stack[this.top];
    }
    //获取栈的容量大小
    public int stackLength(){
        return this.stack.length;
    }
    /*
    * 计算两个数字运算后的结果
    * */
    public int calculate(int num1,int num2,int oper){
        //计算结果哦
        int resoult = 0;
        switch (oper){
            case '+':
               resoult = num1 + num2;
               break;
            case '-':
                resoult = num2 - num1;
                break;
            case '*':
                resoult = num1 * num2;
                break;
            case '/':
                resoult = num2 / num1;
                break;
            default:
                break;
        }
        return resoult;
    }
}
