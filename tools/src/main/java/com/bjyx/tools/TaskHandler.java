package com.bjyx.tools;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class TaskHandler extends Handler {

    private static TaskHandler instance;
    private OnHandleMessage onHandleMessage;

    public static TaskHandler getInstance() {
        if (instance == null) {
            synchronized (TaskHandler.class) {
                if (instance == null) {
                    instance = new TaskHandler();
                }
            }
        }
        return instance;
    }

    @Override
    public void dispatchMessage(@NonNull Message msg) {
        super.dispatchMessage(msg);
        System.out.println("handler-id " + this.toString());
        if (msg.obj instanceof ThreadResult) {
            ((ThreadResult<?>) msg.obj).getThread().onResult(((ThreadResult<?>) msg.obj));
        } else {
            if (onHandleMessage != null) {
                onHandleMessage.handlerMessage(msg);
            }
        }
    }

    public void setOnHandleMessage(OnHandleMessage onHandleMessage) {
        this.onHandleMessage = onHandleMessage;
    }

    public interface OnHandleMessage {
        void handlerMessage(Message message);
    }
}
