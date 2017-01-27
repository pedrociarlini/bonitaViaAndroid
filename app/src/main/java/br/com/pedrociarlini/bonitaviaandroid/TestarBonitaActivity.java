package br.com.pedrociarlini.bonitaviaandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pedrociarlini.projetodaaula.rest.AddCookiesInterceptor;
import com.example.pedrociarlini.projetodaaula.rest.ReceivedCookiesInterceptor;
import com.example.pedrociarlini.projetodaaula.rest.tasks.BonitaLogar;
import com.example.pedrociarlini.projetodaaula.rest.BonitaRestInterface;
import com.example.pedrociarlini.projetodaaula.rest.tasks.BonitaTrazerAtividades;

import java.net.CookieManager;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.JavaNetCookieJar;
import retrofit2.Retrofit;

/**
 * Created by pedrociarlini on 1/26/17.
 */
public class TestarBonitaActivity extends AppCompatActivity {

    private BonitaRestInterface bonita;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_bonita);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
//        client.addInterceptor(new AddCookiesInterceptor());
//        client.addInterceptor(new ReceivedCookiesInterceptor());
        client.cookieJar(new JavaNetCookieJar(new CookieManager()));
        bonita = new Retrofit.Builder().client(client.build()).baseUrl("http://10.0.2.2:8080/bonita/")
                .build()
                .create(BonitaRestInterface.class);
    }

    public void logar(View view) {
        try {
            BonitaLogar task = new BonitaLogar();
            Response resp = task.execute(bonita).get();
            if (task.exception != null)
                throw task.exception;

            if (resp != null)
                exibirAlerta(resp.toString());
        } catch (Exception ex) {
            exibirAlerta("Erro: " + ex.getMessage());
        }
    }

    public void trazerAtividades(View view) {
        try {
            BonitaTrazerAtividades task = new BonitaTrazerAtividades();
            Response resp = task.execute(bonita).get();
            if (task.exception != null) {
                throw task.exception;
            }
            exibirAlerta(resp + " | ");
        } catch (Exception ex) {
            exibirAlerta("Erro: " + ex.getClass().toString() + " - " + ex.getMessage());
        }
    }

    private void exibirAlerta(String msg) {
        new AlertDialog.Builder(this).setTitle("OPA").setMessage(msg)
                .setNeutralButton("OK, valeu", null).show();
    }
}
