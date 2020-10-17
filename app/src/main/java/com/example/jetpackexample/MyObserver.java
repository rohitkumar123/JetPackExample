package com.example.jetpackexample;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import static androidx.lifecycle.Lifecycle.State.STARTED;

public class MyObserver implements LifecycleObserver {
    private static final String TAG = "MyObserver";
    private boolean enabled = false;
    Lifecycle myLifecycle;
    public MyObserver(Lifecycle lifecycle) {
        this.myLifecycle = lifecycle;
        this.myLifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreateEvent() {
        Log.i(TAG, "Observer ON_CREATE");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStartEvent() {
        Log.i(TAG, "Observer ON_START");
        if (enabled) {
            // connect
            Log.i(TAG, "Observer ON_START: connect");
        }
    }
    public void enable() {
        enabled = true;
        if (this.myLifecycle.getCurrentState().isAtLeast(STARTED)) {
            Log.i(TAG, "Observer enable: connect if not connected");
            onStartEvent();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResumeEvent() {
        Log.i(TAG, "Observer ON_RESUME");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPauseEvent() {
        Log.i(TAG, "Observer ON_PAUSE");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStopEvent() {
        Log.i(TAG, "Observer ON_STOP");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroyEvent() {
        Log.i(TAG, "Observer ON_DESTROY");
        this.myLifecycle.removeObserver(this);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY )
    void onAnyEvent(LifecycleOwner owner, Lifecycle.Event event) {
        String currentState = owner.getLifecycle().getCurrentState().name();
        String eventName = event.name();
        Log.i(TAG, "Observer onAny "+ currentState + " "+ eventName);
    }
}
