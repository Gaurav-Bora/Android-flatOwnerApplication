package com.example.flatownerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    FlatOwnerListAdapter flatOwnerListAdapter;
    List<FlatOwner> flatOwnerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flatOwnerList=new ArrayList<>();
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        setSupportActionBar(toolbar);

        flatOwnerListAdapter = new FlatOwnerListAdapter(this,flatOwnerList);
        recyclerView.setAdapter(flatOwnerListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        getAllFlatOwner();
    }
    private void getAllFlatOwner() {
        flatOwnerList.clear();
        FlatOwnerDBHelper dbHelper = new FlatOwnerDBHelper(this);
        dbHelper.getListVechicle(flatOwnerList);
        flatOwnerListAdapter.notifyDataSetChanged();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        startActivity(new Intent(this, AddFlatOwnerActivity.class));

        finish();
        return super.onOptionsItemSelected(item);
    }
}