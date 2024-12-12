package com.example.quanlytinhluong.Interface.Task;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.quanlytinhluong.Adapter.AdapterTamUng;
import com.example.quanlytinhluong.Adapter.AdapterTask;
import com.example.quanlytinhluong.Database.DBTask;
import com.example.quanlytinhluong.Interface.Employee.MainActivityNhanVien;
import com.example.quanlytinhluong.Interface.MainActivityHome;
import com.example.quanlytinhluong.Model.TamUng;
import com.example.quanlytinhluong.Model.Tasks;
import com.example.quanlytinhluong.R;

import java.util.ArrayList;

public class MainActivityTask extends AppCompatActivity {
    ListView lvTask;
    ArrayList<Tasks> data_tasks;
    AdapterTask adapterTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_task);
        lvTask = findViewById(R.id.lvTask);

        DBTask dbTask = new DBTask(getApplicationContext());
        data_tasks = dbTask.layDuLieu();
        adapterTask=new AdapterTask(getApplicationContext(),R.layout.custom_task,data_tasks);
        adapterTask.notifyDataSetChanged();
        lvTask.setAdapter(adapterTask);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            Intent intent = new Intent(MainActivityTask.this, MainActivityHome.class);
            startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}