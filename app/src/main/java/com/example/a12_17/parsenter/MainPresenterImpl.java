package com.example.a12_17.parsenter;

import com.example.a12_17.base.BasePresenter;
import com.example.a12_17.contract.MainContract;
import com.example.a12_17.moude.Bean;
import com.example.a12_17.moude.MainModelIImol;
import com.example.a12_17.view.INetCallBack;

public class MainPresenterImpl extends BasePresenter<MainContract.IMainView>implements MainContract.IMainPresenter {
    private MainContract.IMainModel mainModel;
    public MainPresenterImpl(MainContract.IMainModel mainModel) {
        this.mainModel =new MainModelIImol(this);
    }

    @Override
    public void login(String name, String password) {
      mainModel.getLoginData("", new INetCallBack<Bean>() {
          @Override
          public void onSuess(Bean bean) {
              iView.getData(bean);
          }

          @Override
          public void onFail(String err) {

          }
      });

    }

    @Override
    public void loginResult(String result) {

    }
}
