package com.senasoft.prueba5_8_19.servicios;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendMovies extends AsyncTask<String,Void, String> {


    OkHttpClient client = new OkHttpClient();

    public interface AsyncResponse{

        public void progressFinish(String output);

    }

    public AsyncResponse delegate = null;

    public SendMovies(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... strings) {


        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("id", strings[1])
                .addFormDataPart("poster_path", strings[2])
                .addFormDataPart("title", strings[3])
                .addFormDataPart("original_language", strings[4])
                .addFormDataPart("overview", strings[5])
                .addFormDataPart("release_path", strings[6]).build();


        Request request = new Request.Builder().url(strings[0]).post(requestBody).build();

        try {

            Response response = client.newCall(request).execute();

            if (!response.isSuccessful())
                throw  new IOException("Unresped code" + request.toString());

            return response.body().string();

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        delegate.progressFinish(s);
    }
}

