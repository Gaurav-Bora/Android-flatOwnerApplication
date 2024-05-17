package com.example.flatownerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddFlatOwnerActivity extends AppCompatActivity {

    EditText editflatno, editName, editFlatholdertype, editCarpet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flat_owner);

        editflatno = findViewById(R.id.editflatno);
        editName = findViewById(R.id.editName);
        editFlatholdertype = findViewById(R.id.editFlatholdertype);
        editCarpet = findViewById(R.id.editCarpet);
    }

    public void register(View view) {


        String flatno = editflatno.getText().toString();
        String name = editName.getText().toString();
        String flatholdertype = editFlatholdertype.getText().toString();
        String carpet = editCarpet.getText().toString();

        new FlatOwnerDBHelper(this).insertFlatOwner(new FlatOwner(flatno, name, flatholdertype, carpet));
        Toast.makeText(this, "Adding Successful", Toast.LENGTH_SHORT).show();


    }
    public void cancel(View view) {

        finish();
    }
}
