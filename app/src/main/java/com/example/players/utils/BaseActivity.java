package com.example.players.utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * Created by samsung on 2017/12/20.
 */

public abstract class BaseActivity<T extends IPresenter> extends Activity {
    T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        createpresenter();
    }

    protected abstract void createpresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.datach();
        }
    }
}
