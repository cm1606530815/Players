package com.example.players.presenter;



import com.example.players.Bean.CartBean;
import com.example.players.model.HomeModerl;
import com.example.players.model.IHome;
import com.example.players.utils.IPresenter;
import com.example.players.view.IbeanView_jr;

import java.lang.ref.SoftReference;

/**
 * Created by samsung on 2017/12/20.
 */

public class PresenterView_jr implements IPresenter<IbeanView_jr> {

    IHome home;
    SoftReference<IbeanView_jr> softReference;

    public PresenterView_jr(IbeanView_jr veiw) {
        attch(veiw);
        home = new HomeModerl();
    }

    public void showjr2() {
        home.showjr2(new IHome.Movie_jr2() {
            @Override
            public void complete(CartBean cartBean) {
                softReference.get().showButtonjr(cartBean);
            }
        });
    }

    @Override
    public void attch(IbeanView_jr view) {
        softReference = new SoftReference<IbeanView_jr>(view);
    }

    @Override
    public void datach() {
        softReference.clear();
    }
}
