package com.example.a12_17.base;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements BaseView{
     public P presenter;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
          setContentView(getLayoutId());
            if (presenter == null){
               presenter = add();
               presenter.attachView(this);
            }
            initView();
            initData();
        }
    protected abstract int getLayoutId();
    protected abstract P add();
    protected abstract void initData();
    protected abstract void initView();
}
