package com.example.players.model;



import com.example.players.Bean.CartBean;
import com.example.players.Bean.JiaRuGWC;
import com.example.players.Bean.MyBean;
import com.example.players.utils.ApiService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by samsung on 2017/12/20.
 */

public class HomeModerl implements IHome {
    @Override
    public void showHome(final Movie movie) {
        ApiService.API_SERVICE.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        movie.complete(myBean);
                    }
                });
    }

    @Override
    public void showjr(final Movie_jr movie_jr) {
        ApiService.API_SERVICE_jr.getDatajr()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JiaRuGWC>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(JiaRuGWC jiaRuGWC) {
                        movie_jr.complete(jiaRuGWC);
                    }
                });
    }

    @Override
    public void showjr2(final Movie_jr2 movie_jr2) {
        ApiService.API_SERVICE_jr2.getDatajr2()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        movie_jr2.complete(cartBean);
                    }
                });
    }
}
