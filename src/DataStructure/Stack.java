package DataStructure;

import java.util.ArrayList;

public class Stack {

    int top;
    ArrayList<Integer> stack;

    public Stack(){
        top = 0;
        stack = new ArrayList();
    }

    public void push(int data){
       stack.add(data);
       top++;
    }

    public int pop(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }
        return stack.remove(--top);
    }

    public int peek(){
        if(top == 0){
            System.out.println("Stack is empty");
            return 0;
        }
        return stack.get(top-1);
    }

    public int getSize(){
        return stack.size();
    }

    public boolean isEmpty(){
        if(top == 0){
            return true;
        }else return false;
    }
}
