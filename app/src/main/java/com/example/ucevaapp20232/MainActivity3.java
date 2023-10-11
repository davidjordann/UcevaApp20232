package com.example.ucevaapp20232;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView tv3;
    Integer contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle received = getIntent().getExtras();
        tv3 = findViewById(R.id.tv3);
        tv3.setText(received.getString("username") + " " +received.getString("passwd") );
        //Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
    }

    public void saludar(View d){
        // Toast.makeText(this,"Que hubo mor 2!!!!",Toast.LENGTH_LONG).show();
        Intent ir = new Intent(this,MainActivity2.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(ir);
    }

    public void contar(View d){
        contador++;
        tv3.setText("Contador: "+ contador);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contadorEjemplo",contador);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contadorEjemplo");
    }
}