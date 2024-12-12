package com.example.quanlytinhluong.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.quanlytinhluong.Model.ThongKe;
import com.example.quanlytinhluong.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdapterThongKe extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<ThongKe> data;

    public AdapterThongKe(@NonNull Context context, int resource, ArrayList<ThongKe> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        TextView tvMaNV, tvTenNV, tvNgayChamCong, tvTenPhong, tvThucLanh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        AdapterThongKe.Holder holder = null;
        if (view == null) {
            holder = new AdapterThongKe.Holder();
            view = LayoutInflater.from(context).inflate(resource, null);

            holder.tvMaNV = view.findViewById(R.id.tvMaNV);
            holder.tvTenNV = view.findViewById(R.id.tvTenNV);
            holder.tvNgayChamCong = view.findViewById(R.id.tvNgayChamCong);
            holder.tvTenPhong = view.findViewById(R.id.tvTenPhongBan);
            holder.tvThucLanh = view.findViewById(R.id.tvThucLanh);

            view.setTag(holder);
        } else
            holder = (AdapterThongKe.Holder) view.getTag();
        final ThongKe thongKe = data.get(position);
        holder.tvMaNV.setText(thongKe.getMaNV());
        holder.tvTenNV.setText(thongKe.getTenNV());
        holder.tvTenPhong.setText(thongKe.getTenPhong());
        holder.tvNgayChamCong.setText(thongKe.getNgayChamCong());
        int luong = 0;
        int thucLanh = 0;

        int ngayCong = Integer.parseInt(thongKe.getSoNgayCong());
        int heSoLuong = Integer.parseInt(thongKe.getHeSoLuong());
        String tamUng = thongKe.getTienTamUng();

        luong = (heSoLuong * ngayCong);
        thongKe.setLuongCoBan(luong + "");

        if (tamUng != null) {
            int ung = Integer.parseInt(tamUng);
            thucLanh = luong - ung;
            Log.d("TamUng", thucLanh+"");

            thongKe.setLuongThucLanh(thucLanh + "");
        }else {
            tamUng = "0";
            int ung = Integer.parseInt(tamUng);
            thucLanh = luong - ung;

            Log.d("TamUng", thucLanh+"");
            thongKe.setLuongThucLanh(thucLanh + "");

        }

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

        holder.tvThucLanh.setText(currencyVN.format(Integer.parseInt(thongKe.getLuongThucLanh())));

        return view;
    }
}
