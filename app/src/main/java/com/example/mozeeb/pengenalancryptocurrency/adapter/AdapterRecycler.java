package com.example.mozeeb.pengenalancryptocurrency.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mozeeb.pengenalancryptocurrency.DetailsActivity;
import com.example.mozeeb.pengenalancryptocurrency.R;
import com.example.mozeeb.pengenalancryptocurrency.response.CryptoItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {
    //Buat GLOBAL variabel untuk menampung context
    Context context;
    List<CryptoItem> cryptoItems;
    public AdapterRecycler(Context context, List<CryptoItem> data_barang){
        //inisialisi
        this.context = context;
        this.cryptoItems = data_barang;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int ViewType) {
        //Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.design_list,parent,false);
        //hubungkan dengan myViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        //set widget
        holder.tvJudul.setText(cryptoItems.get(position).getNama());
        //dapatkan url gambar
        final String urlGambarBerita = "" + cryptoItems.get(position).getGambar();
        //set image ke widget deengan picca library
        //karena image dari internet
        Picasso.with(context).load(urlGambarBerita).into(holder.ivGamvar);
        //Event klik ketika item list nya di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memulai Activity Details
                Intent varIntent = new Intent(context, DetailsActivity.class);
                //sisipkan data ke intent
                varIntent.putExtra("judul", cryptoItems.get(position).getNama());
                varIntent.putExtra("isi", cryptoItems.get(position).getIsi());
                varIntent.putExtra("gambar", urlGambarBerita);
                //method startActivity cuma bisa di pakai di Activity/Fragment
                //jadi harus masuk ke context dulu
                context.startActivity(varIntent);
            }
        });
    }
    //menentukan jumlah item yang tampil
    @Override
    public int getItemCount(){
        return cryptoItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //declarasi widget
        ImageView ivGamvar, imgdetail;
        TextView tvJudul, tvdeskripsi;
        public MyViewHolder(View itemView){
            super(itemView);
            //inisialisai widget
            ivGamvar =(ImageView)itemView.findViewById(R.id.gambar);
            imgdetail =(ImageView)itemView.findViewById(R.id.gambar_detail);
            tvJudul = (TextView)itemView.findViewById(R.id.judul);
            tvdeskripsi = (TextView)itemView.findViewById(R.id.isi);
        }
    }
}
