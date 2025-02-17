package tqs.start;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsStack 
{
    private ArrayList<Object> stack = new ArrayList<>();
    public void push(Object obj){
        stack.addFirst(obj);
    }
    public Object pop(){
        if (stack.isEmpty()){
            throw new NoSuchElementException();
        } else {
        Object obj = stack.removeFirst();
        return obj;
        }
    }
    public Object peek(){
        if (stack.isEmpty()){
            throw new NoSuchElementException();
        } else {
            Object obj = stack.get(0);
            return obj;
        }
    }
    public int size(){
        return stack.size();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public Object popTopN(int n){
        Object top = null;
        for (int i = 0; i < n; i++){
            top = stack.removeFirst();
        }
        return top;
    }
}
