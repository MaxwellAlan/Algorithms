/**
 * 用两个栈实现队列功能
 */
package stackAndQueue;

import java.util.Stack;

public class TwoStackQueue {

    public Stack<Integer> stackIn;
    public Stack<Integer> stackOut;

    public TwoStackQueue(){
        this.stackIn=new Stack<Integer>();
        this.stackOut=new Stack<Integer>();
    }

    public void add(int newNum){
        this.stackIn.push(newNum);
    }

    public int poll(){
        if (stackIn.isEmpty() && stackOut.isEmpty()){
            throw new RuntimeException("queue is empty");
        }else if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public int peek(){
        if (stackIn.isEmpty() && stackOut.isEmpty()){
            throw new RuntimeException("queue is empty");
        }else if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }


}
