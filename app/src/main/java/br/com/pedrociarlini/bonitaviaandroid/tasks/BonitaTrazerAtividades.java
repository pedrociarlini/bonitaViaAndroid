package br.com.pedrociarlini.bonitaviaandroid.tasks;

import android.os.AsyncTask;

import com.example.pedrociarlini.projetodaaula.rest.BonitaRestInterface;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by pedrociarlini on 1/26/17.
 */

public class BonitaTrazerAtividades extends AsyncTask<BonitaRestInterface, Void, Response> {
    public Exception exception;

    public BonitaTrazerAtividades() {
    }

    @Override
    protected Response doInBackground(BonitaRestInterface... bonita) {
        try {
            Response resp = bonita[0].getOpenTasks("").execute().raw();
            return resp;
        } catch (Exception ex) {
            this.exception = ex;
            return null;
        }
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        if (this.exception != null) {
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.exception = null;
    }
}
