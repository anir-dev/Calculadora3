package com.example.ikand.calculadora2;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    //se crean las variables para enlazarlas con los los del diseño
    private Button btnOpcion,btnBorrar;
    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se enlazan los atributos con los del diseño
        texto= (TextView) findViewById(R.id.editText);
        btnBorrar=(Button) findViewById(R.id.btnBorrar);
        //se le asigna una doble funcion al boton de borrar
        //OnClick significa cuando se pulse el boton
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(texto.getText().length()!=0){
                    texto.setText(texto.getText().toString().substring(0,texto.getText().length()-1));
                }
            }
        });
        //OnLongClick significa cuando se mantenga pulsado el boton
        btnBorrar.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                //debe retornar un valor boolean
                texto.setText("");
                return true;
            }
        });

        //para cargar la toolbar en la actividad
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //Los dos siguientes metodos sirven para cargar las opciones del menu en el activity main
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater=getMenuInflater();
        //inflater.inflate(R.menu.menu,menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }
    //Este metodo sirve para obtener los resultados seleccionados por el usuario y asignarles una funcion
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                Toast.makeText(this, "Has seleccionado la opcion salir", Toast.LENGTH_SHORT).show();
             break;
            case R.id.action_settings:
            btnSettingsPulsado();
            break;
        }
        /*int id=item.getItemId();
        if(id==R.id.action_settings){
            Intent a=new Intent(MainActivity.this,Settings.class);
            startActivity(a);
        }*/

        return super.onOptionsItemSelected(item);

    }

    public void btnSettingsPulsado(){
        Toast.makeText(this, "Seleccione la configuracion requerida", Toast.LENGTH_SHORT).show();
        Intent a=new Intent(MainActivity.this,Settings.class);
        startActivity(a);
        //Toast.makeText(this, "aaaaa", Toast.LENGTH_SHORT).show();
    }
}
