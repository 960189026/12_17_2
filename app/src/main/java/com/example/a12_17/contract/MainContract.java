package com.example.a12_17.contract;

import com.example.a12_17.base.BaseView;
import com.example.a12_17.moude.Bean;
import com.example.a12_17.view.INetCallBack;

public class MainContract {
    public interface IMainModel{
      <T> void getLoginData(String url, INetCallBack<T>callBack);
    }
    public interface IMainPresenter{
        void login(String name,String password);
        void loginResult(String result);
    }
    public interface  IMainView extends BaseView{
        String getUserName();
        String getPassword();
        void getData(Bean string);
    }
}
