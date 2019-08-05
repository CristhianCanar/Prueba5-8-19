package com.senasoft.prueba5_8_19.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.senasoft.prueba5_8_19.R;
import com.senasoft.prueba5_8_19.servicios.SendMovies;

import org.json.JSONArray;
import org.json.JSONException;

public class RegsitroActivity extends AppCompatActivity {

    private EditText editId, editUrl, editTitulo, editLenguaje, editDesc, editFechaEstreno;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsitro);

        referent();

    }

    private void referent() {

        editId = findViewById(R.id.editID);
        editUrl = findViewById(R.id.editURL);
        editTitulo = findViewById(R.id.editTitulo);
        editLenguaje = findViewById(R.id.editLenguaje);
        editDesc = findViewById(R.id.editDesc);
        editFechaEstreno = findViewById(R.id.editFechaEstreno);

        btnGuardar = findViewById(R.id.btnRegistrar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

    }

    private void save() {

        String id = editId.getText().toString();
        String urlImage = editUrl.getText().toString();
        String title = editTitulo.getText().toString();
        String idioma = editLenguaje.getText().toString();
        String desc = editDesc.getText().toString();
        String fecha = editFechaEstreno.getText().toString();

        String URI_API = "https://api.themoviedb.org/3/discover/movie?" + "certification_country=US&certification.lte=G&sort_by=popularity.desc&api_key=23e55efed5cef4e8977a6d17c4cbcbee";

        SendMovies sendMovies = (SendMovies) new SendMovies(new SendMovies.AsyncResponse() {
            @Override
            public void progressFinish(String output) {
                Log.e("Logg", output.toString());

                try {

                    JSONArray res = new JSONArray(output);

                    

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }).execute(URI_API, id, urlImage, title, idioma, desc, fecha);

        clear();
        Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
    }

    public void clear(){
        editId.setText("");
        editUrl.setText("");
        editTitulo.setText("");
        editLenguaje.setText("");
        editDesc.setText("");
        editFechaEstreno.setText("");
    }
}
