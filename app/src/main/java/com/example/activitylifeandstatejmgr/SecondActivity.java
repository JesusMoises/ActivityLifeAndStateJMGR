package com.example.activitylifeandstatejmgr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    ////mensaje mediante clave-valor definida public para poder usarla tambien en la Primera Activity
    public static final String EXTRA_REPLY = "com.example.twoactivites.extra.REPLAY";
    //Creamos variable privada para hacer referencia a la edición
    private EditText mReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // creamos objeto intent y usamos el método getIntent el cual devuelve un intent si es que hay alguno disponible
        Intent intent = getIntent();
        //Obtenemos mediante la primera activity el mensaje de nuestra variable clave-valor el cual es el id del mensaje adicional
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Obtenemos la referencia de nuestro textView
        TextView textView = findViewById(R.id.text_message);
        //colocamos el mensaje que se ha recibido mediante la clave-valor de nuestra priemra Activity y lo colocamos en el TextView
        textView.setText(message);

        //obtenemos la referencia que fue escrito en nuestra segunda activity EditText y lo guardamos en mReplay
        mReplay = findViewById(R.id.editText_second);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void returnReply(View view) {

        //obtenemos la cadena que tiene nuestra variable mReply
        String reply = mReplay.getText().toString();
        //Creamos un objeto intent
        Intent replyIntent = new Intent();
        /*con nuestro objeto intent creado ahora tomamos el valor del ID que es el valor clave, el segundo parámetro es el texto
        real obtenido del reply*/
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End SecondActivity");
        //cerramos la actividad
        finish();
    }
}