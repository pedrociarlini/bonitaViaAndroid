package br.com.pedrociarlini.bonitaviaandroid.tasks;

import android.os.AsyncTask;

import com.example.pedrociarlini.projetodaaula.rest.BonitaRestInterface;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by pedrociarlini on 1/26/17.
 */

public class BonitaLogar extends AsyncTask<BonitaRestInterface, Void, Response> {
    public Exception exception;

    public BonitaLogar() {
    }

    @Override
    protected Response doInBackground(BonitaRestInterface... bonita) {
        try {
            return bonita[0].loginservice("pedrociarlini", "12345").execute().raw();
        } catch (Exception ex) {
            this.exception = ex;
            return null;
        }
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.exception = null;
    }
}
