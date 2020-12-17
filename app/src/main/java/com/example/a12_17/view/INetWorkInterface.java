package com.example.a12_17.view;

import java.util.HashMap;

public interface INetWorkInterface {
 // 不回调情况下 这么写;
 public <T> void get(String url,INetCallBack<T>callBack);
 public <T> void post(String url,INetCallBack<T>callBack);
 public <T> void post(String url, HashMap<String,String>map,INetCallBack<T>callBack);

}
