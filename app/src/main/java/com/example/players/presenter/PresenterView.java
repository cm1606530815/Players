package com.example.players.presenter;


import com.example.players.Bean.JiaRuGWC;
import com.example.players.Bean.MyBean;
import com.example.players.model.HomeModerl;
import com.example.players.model.IHome;
import com.example.players.utils.IPresenter;
import com.example.players.view.IbeanVeiw;

import java.lang.ref.SoftReference;

/**
 * Created by samsung on 2017/12/20.
 */

public class PresenterView implements IPresenter<IbeanVeiw> {


    IHome home;
    SoftReference<IbeanVeiw> softReference;

    public PresenterView(IbeanVeiw view) {
        attch(view);
        home = new HomeModerl();
    }

    public void showMoie() {
        home.showHome(new IHome.Movie() {
            @Override
            public void complete(MyBean myBean) {
                softReference.get().showModerl(myBean);
            }
        });
    }

    public void showjr() {
        home.showjr(new IHome.Movie_jr() {
            @Override
            public void complete(JiaRuGWC jiaRuGWC) {
                softReference.get().showButtonjr(jiaRuGWC);
            }
        });
    }

    @Override
    public void attch(IbeanVeiw view) {
        softReference = new SoftReference<IbeanVeiw>(view);
    }

    @Override
    public void datach() {
        softReference.clear();
    }
}
