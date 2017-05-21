package com.homework.hsj.zigbanghomework.presenter;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.homework.hsj.zigbanghomework.activity.MapsActivity;
import com.homework.hsj.zigbanghomework.interfaces.Ui;

/**
 * Created by boomd on 2017-05-16.
 */

public class MapsPresenter extends Presenter<MapsActivity> implements LoaderManager.LoaderCallbacks {

    @Override
    public void onUiUnready(MapsActivity ui) {
        super.onUiUnready(ui);
    }

    @Override
    public void onUiReady(MapsActivity ui) {
        super.onUiReady(ui);
    }






    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }

    @Override
    public void onLoaderReset(Loader loader) {

    }


    public interface MapsUi extends Ui {
        //뷰 컨트롤 함수들.
    }
}
