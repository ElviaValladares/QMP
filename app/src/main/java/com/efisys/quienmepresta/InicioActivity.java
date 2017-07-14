package com.efisys.quienmepresta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView registrarme;
    private EditText email;
    private EditText password;
    private Button ingresar;
    private String correo = "fchia@gmail.com";
    private String pass =  "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceso_activity);

        email = (EditText) findViewById(R.id.edTxtEmail);
        password = (EditText) findViewById(R.id.edTxtContrasenia);
        ingresar = (Button) findViewById(R.id.btnIngresar);
        ingresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIngresar:
                //Log.i("onclick", String.valueOf(email.equals(correo)));
                if (email.getText().toString().equals(correo) & password.getText().toString().equals(pass)){
                    Bundle contenedor = new Bundle();
                    Intent i = new Intent(this, MainActivity.class);
                    i.putExtras(contenedor);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    finish();
                    startActivity(i);
                } else {
                    Log.i("comparacion",String.valueOf(email.equals(correo)));
                    Log.i("No se pudo",String.valueOf(email.getText()));
                    Log.i("No se pudo",String.valueOf(password.getText()));
                }

                //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                //finish();
                break;
        }
    }
}