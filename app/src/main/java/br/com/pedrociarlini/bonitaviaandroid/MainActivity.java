package br.com.pedrociarlini.bonitaviaandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pedrociarlini.projetodaaula.rest.entity.Dados;

import br.com.pedrociarlini.bonitaviaandroid.entity.Dados;

public class MainActivity extends AppCompatActivity {

    public static Dados dados = new Dados();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exibirPedidos(View v) {
        EditText txtMesa = (EditText) findViewById(R.id.txtNumMesa);
        EditText txtNome = (EditText) findViewById(R.id.txtNome);
        dados.mesaAtual = txtMesa.getText().toString();
        dados.nome = txtNome.getText().toString();

        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Vai mudar hein!").setMessage("Veremos jájá a tela de diálogo.")
                .setNeutralButton("Fechar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent(MainActivity.this, PedidosActivity.class);
                        startActivity(in);
                    }
                });
        dialogo.show();
    }

    public void abrirPet(View view) {
        Intent in = new Intent(MainActivity.this, PetShopBoysActivity.class);
        startActivity(in);
    }

    public void testarBonita(View view) {
        Intent in = new Intent(MainActivity.this, TestarBonitaActivity.class);
        startActivity(in);
    }
}
