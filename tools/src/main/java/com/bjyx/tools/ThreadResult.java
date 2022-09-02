package com.bjyx.tools;

public class ThreadResult<T>{
    private ThreadTask thread;
    private T data;

    public ThreadResult(ThreadTask thread, T data) {
        this.thread = thread;
        this.data = data;
    }

    public ThreadTask getThread() {
        return thread;
    }

    public T getData() {
        return data;
    }
}
