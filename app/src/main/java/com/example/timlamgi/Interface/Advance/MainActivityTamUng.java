package com.example.quanlytinhluong.Interface.Advance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.quanlytinhluong.Adapter.AdapterTamUng;
import com.example.quanlytinhluong.Database.DBTamUng;
import com.example.quanlytinhluong.Interface.MainActivityHome;
import com.example.quanlytinhluong.Model.TamUng;
import com.example.quanlytinhluong.R;

import java.util.ArrayList;

public class MainActivityTamUng extends AppCompatActivity {

    ListView lvTamUng;
    ArrayList<TamUng> data_TU;
    AdapterTamUng adapter_TU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tam_ung);
        lvTamUng = findViewById(R.id.lvTamUng);

        DBTamUng dbTamUng=new DBTamUng(getApplicationContext());
        data_TU = dbTamUng.layDuLieu();
        adapter_TU=new AdapterTamUng(getApplicationContext(),R.layout.custom_tamung,data_TU);
        adapter_TU.notifyDataSetChanged();
        lvTamUng.setAdapter(adapter_TU);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.btnHome){
            Intent intent = new Intent(MainActivityTamUng.this, MainActivityHome.class);
            startActivity(intent);
        }
        return true;
    }
}