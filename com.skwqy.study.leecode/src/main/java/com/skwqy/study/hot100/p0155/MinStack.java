package com.skwqy.study.hot100.p0155;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author skwqy
 * @Created on 2019 09 2019-09-06 22:44
 */
public class MinStack {
    private final Stack<Integer> data;
    private final Stack<Integer> mins;

    public MinStack() {
        data = new Stack();
        mins = new Stack();
    }

    public void push(int x) {
        data.push(x);
        if (mins.empty() || mins.peek() >= x) {
            mins.push(x);
        } else {
            mins.push(mins.peek());
        }
    }

    public void pop() {
        data.pop();
        mins.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        if (!mins.isEmpty()) {
            return mins.peek();
        }
        throw new RuntimeException("invalid operation.");
    }
}
