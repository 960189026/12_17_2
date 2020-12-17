package com.example.a12_17.view;

public interface INetCallBack<T> {
    public void onSuess(T t);
    public void  onFail(String err);
}
