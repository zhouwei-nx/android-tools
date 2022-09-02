package com.bjyx.tools;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

public abstract class ThreadTask<T> extends Thread {

    private Handler mainHandler;

    public ThreadTask() {
        mainHandler = TaskHandler.getInstance();
    }

    @Override
    public void run() {
        super.run();
        Message message = Message.obtain();
        message.obj = new ThreadResult<T>(ThreadTask.this, doInBackground());
        mainHandler.sendMessage(message);
    }


    @MainThread
    public void onStart() {

    }

    @MainThread
    public void onResult(ThreadResult<T> t) {

    }

    @WorkerThread
    public abstract T doInBackground();

    public void execute() {
        onStart();
        start();
    }
}
