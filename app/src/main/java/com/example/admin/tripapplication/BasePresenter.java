package com.example.admin.tripapplication;

/**
 * Created by Admin on 9/12/2017.
 */

public interface BasePresenter <V extends BaseView> {

    void attachView(V view);
    void detachView();

}
