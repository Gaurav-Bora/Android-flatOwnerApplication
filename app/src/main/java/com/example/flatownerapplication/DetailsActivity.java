package com.example.flatownerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView textFlatno,texName,textFlatholdertype,textCarpet;
    FlatOwner flatOwner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textFlatno = findViewById(R.id.textFlatno);
        texName = findViewById(R.id.texName);
        textFlatholdertype = findViewById(R.id.textFlatholdertype);
        textCarpet = findViewById(R.id.textCarpet);

        flatOwner = (FlatOwner) getIntent().getSerializableExtra("flat");

        getVechicleDetails();
    }
    private void getVechicleDetails() {

        textFlatno.setText("Flat-No :"+flatOwner.getFlatno());
        texName.setText("Name :"+flatOwner.getName());
        textFlatholdertype.setText("Flat-Holder-Type :"+flatOwner.getFlatholdertype());
        textCarpet.setText("Carpet :"+flatOwner.getCarpet());
    }
    public void back(View view){
        finish();
    }
}