package br.com.pedrociarlini.bonitaviaandroid;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pedrociarlini on 1/25/17.
 */

public class PedidosActivity extends AppCompatActivity {
    private TextView txtMesaAtual;
    private TextView txtNome;
    private ListView listaPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_pedidos);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        txtMesaAtual = (TextView) findViewById(R.id.txtNomeMesa);
        txtNome = (TextView) findViewById(R.id.txtNome);
        // listaPedidos = (ListView) findViewById(R.id.listPedidos);

        txtMesaAtual.setText("Mesa " + MainActivity.dados.nome);
//        listaPedidos.setAdapter(new ArrayAdapter<String>(this, R.layout.act_pedidos,
//                new ArrayList<String>(MainActivity.dados.pedidos.keySet())));
    }

    public void exibirAlert(View view) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Vai mudar hein!").setMessage("Veremos jájá a tela de diálogo.")
                .setNeutralButton("Fechar", null);
        dialogo.show();
    }
}
