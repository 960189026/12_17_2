package com.example.a12_17.base;

public class BasePresenter<V extends BaseView> {
    public V iView;
    private V v;

    public  void attachView(V v){
        this.v = v;
    }
}
