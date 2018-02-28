/**
 * 实现getMin()操作的时间复杂度O（1）
 */

package stackAndQueue;

import java.util.Stack;

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }

    public void push(int newNum){
        this.stackData.push(newNum);
        if(this.stackMin.isEmpty()){
            stackMin.push(newNum);
        }else if (newNum<=this.getmin()){
            this.stackMin.push(newNum);
        }
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int value=this.stackData.pop();
        if (value==this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return this.stackMin.peek();
    }

}
