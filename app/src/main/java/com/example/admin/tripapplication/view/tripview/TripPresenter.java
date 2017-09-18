package com.example.admin.tripapplication.view.tripview;

import android.content.Context;

public class TripPresenter implements TripContract.Presenter {
    TripContract.View view;
    private static final String TAG = "TripActivityPresenter";
    private Context context;

    @Override
    public void attachView(TripContract.View view) {
        this.view = view;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

}