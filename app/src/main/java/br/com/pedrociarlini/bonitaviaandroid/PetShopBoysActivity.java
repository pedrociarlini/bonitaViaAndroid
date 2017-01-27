package br.com.pedrociarlini.bonitaviaandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by pedrociarlini on 1/26/17.
 */

public class PetShopBoysActivity extends AppCompatActivity {
    private CheckBox cbPetTosa;
    private CheckBox cbPetBanho;
    private CheckBox cbPetConsulta;
    private EditText txtPetNomeCliente;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_pet);
        cbPetBanho = (CheckBox) findViewById(R.id.cbPeBanho);
        cbPetTosa = (CheckBox) findViewById(R.id.cbPeTosa);
        cbPetConsulta = (CheckBox) findViewById(R.id.cbPeConsulta);
        txtPetNomeCliente = (EditText) findViewById(R.id.txtPetNomeCliente);
    }

    public void petPagar(View view) {
        double total = 0;
        if (cbPetBanho.isChecked()) {
            total += 10;
        }
        if (cbPetTosa.isChecked()) {
            total += 20;
        }
        if (cbPetConsulta.isChecked()) {
            total += 50;
        }

        String msg = "Oi " + txtPetNomeCliente.getText() + ", o seu total deu " + total + ".";

        if (cbPetBanho.isChecked() && cbPetTosa.isChecked() && cbPetConsulta.isChecked()) {
            total = total - (0.1 * total);
            msg += "\nMas como somos legais, toma 10% de desconto: " + total;
        }

        AlertDialog.Builder dia = new AlertDialog.Builder(this);
        dia.setTitle("Total").setMessage(msg).setNeutralButton("Entendi", null).show();
    }
}
