package com.example.a12_17.moude;

import com.example.a12_17.contract.MainContract;
import com.example.a12_17.view.INetCallBack;
import com.example.a12_17.view.RetrofitUtils;

public class MainModelIImol implements MainContract.IMainModel {
    private  MainContract.IMainPresenter presenter;
    public MainModelIImol(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getLoginData(String url, INetCallBack<T> callBack) {
            presenter.loginResult("成功");
        RetrofitUtils.getInstance().get(url,callBack);
    }
}
