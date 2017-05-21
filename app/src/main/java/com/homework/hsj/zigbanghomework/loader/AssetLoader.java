package com.homework.hsj.zigbanghomework.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.homework.hsj.zigbanghomework.model.JsonResponse;
import com.homework.hsj.zigbanghomework.model.MarkerItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static android.R.id.list;

/**
 * Created by boomd on 2017-05-16.
 */

public class AssetLoader extends AsyncTaskLoader {

    public AssetLoader(Context context) {
        super(context);
    }

    @Override
    public Object loadInBackground() {

        String json = null;

        try {

            InputStream is = getContext().getAssets().open("mobile.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        try {

            JSONObject jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson Gson = gsonBuilder.create();
        JsonResponse response =  Gson.fromJson(json, JsonResponse.class);

        Log.i("HSJ",""+json);
        List<MarkerItem> list = response.getFiltered();
        for(MarkerItem item : list) {
            Log.i("HSJ",""+item);
        }


        return json;
    }
}
