package com.tec2.dam.app;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.apache.http.HttpConnection;

import java.net.HttpURLConnection;
import java.net.URL;


public class ContactoActivity extends ActionBarActivity {
    protected TextView etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etiqueta = (TextView)findViewById(R.id.textoacambiar);

        obtenerTextoDeInternet();
    }

    private void obtenerTextoDeInternet() {
        ObtenerTexto objeto = new ObtenerTexto();
        objeto.execute();
    }

    private class ObtenerTexto extends AsyncTask <Object, Void, String> {
        @Override
        protected String doInBackground(Object... objects){
            int responseCode = -1;
            String resultado = "";

            try{
                URL url = new URL ("http://google.com");

                HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
                httpConnection.connect();

                responseCode = httpConnection.getResponseCode();

                resultado = responseCode + "";
            }catch (Exception e){}

            return resultado;
        }

        @Override
        protected void onPostExecute(String s){
            etiqueta.setText(s);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contacto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
