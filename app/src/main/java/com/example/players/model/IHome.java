package com.example.players.model;

import com.example.players.Bean.CartBean;
import com.example.players.Bean.JiaRuGWC;
import com.example.players.Bean.MyBean;

/**
 * Created by samsung on 2017/12/20.
 */

public interface IHome {

    void showHome(Movie movie);

    interface Movie {
        void complete(MyBean myBean);
    }

    void showjr(Movie_jr movie_jr);

    interface Movie_jr {
        void complete(JiaRuGWC jiaRuGWC);
    }
    void showjr2(Movie_jr2 movie_jr2);

    interface Movie_jr2 {
        void complete(CartBean cartBean);
    }

}
