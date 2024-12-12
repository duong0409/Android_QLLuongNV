package com.example.quanlytinhluong.Interface.TotalSalary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quanlytinhluong.Adapter.AdapterThongKe;
import com.example.quanlytinhluong.Database.DBNhanVien;
import com.example.quanlytinhluong.Model.ThongKe;
import com.example.quanlytinhluong.R;

import java.util.ArrayList;

public class MainActivityTongLuong extends AppCompatActivity {
    ListView lvThongKe;
    ArrayList <ThongKe> thongke = new ArrayList<>();
    AdapterThongKe adapterThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tong_luong);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        lvThongKe = findViewById(R.id.lvThongKe);

        final DBNhanVien dbNhanVien = new DBNhanVien(getApplicationContext());
        thongke = dbNhanVien.layDSThongKe();

        adapterThongKe = new AdapterThongKe(this, R.layout.custom_tongluong, thongke);
        lvThongKe.setAdapter(adapterThongKe);

        lvThongKe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivityTongLuong.this, ChiTietTongLuong.class);
                ThongKe itemThongKe = thongke.get(position);

                String tenItem = itemThongKe.getTenNV();
                String idItem = itemThongKe.getMaNV();
                String pbItem = itemThongKe.getTenPhong();
                String hslItem= itemThongKe.getHeSoLuong();
                String soNgayCongItem=itemThongKe.getSoNgayCong();
                String tamUngItem = itemThongKe.getTienTamUng();
                String ngayChamCongItem = itemThongKe.getNgayChamCong();
                String luongCoBanItem = itemThongKe.getLuongCoBan();
                String luongThucLanhItem = itemThongKe.getLuongThucLanh();

                intent.putExtra("tenItem",tenItem);
                intent.putExtra("idItem",idItem);
                intent.putExtra("pbItem",pbItem);
                intent.putExtra("hslItem",hslItem);
                intent.putExtra("soNgayCongItem",soNgayCongItem);
                intent.putExtra("tamUngItem",tamUngItem);
                intent.putExtra("ngayChamCongItem",ngayChamCongItem);
                intent.putExtra("luongCoBanItem",luongCoBanItem);
                intent.putExtra("luongThucLanhItem",luongThucLanhItem);

                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return true;
    }
}