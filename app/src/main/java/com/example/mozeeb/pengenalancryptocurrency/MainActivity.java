package com.example.mozeeb.pengenalancryptocurrency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mozeeb.pengenalancryptocurrency.adapter.AdapterRecycler;
import com.example.mozeeb.pengenalancryptocurrency.api.ApiService;
import com.example.mozeeb.pengenalancryptocurrency.api.UtilsApi;
import com.example.mozeeb.pengenalancryptocurrency.response.CryptoItem;
import com.example.mozeeb.pengenalancryptocurrency.response.ResponseCoin;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inisialisasi Widget
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        // RecyclerView harus pakai Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Eksekusi method
        tampilBarang();
    }
    private void tampilBarang() {
        ApiService api = UtilsApi.getAPIService();
        // Siapkan request
        Call<ResponseCoin> beritaCall = api.getAllData();
        // Kirim request
        beritaCall.enqueue(new Callback<ResponseCoin>() {
            @Override
            public void onResponse(Call<ResponseCoin> call, Response<ResponseCoin> response) {
                // Pasikan response Sukses
                if (response.isSuccessful()) {
                    Log.d("response api", response.body().toString());
                    // tampung data response body ke variable
                    List<CryptoItem> data_berita = response.body().getCrypto();
                    boolean status = response.body().isStatus();
                    // Kalau response status nya = true
                    if (status) {
                        // Buat Adapter untuk recycler view
                        AdapterRecycler adapter = new AdapterRecycler(MainActivity.this, data_berita);
                        recyclerView.setAdapter(adapter);
                    } else {
                         // kalau tidak true
                        Toast.makeText(MainActivity.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseCoin> call, Throwable t) {
// print ke log jika Error
                t.printStackTrace();
            }
        });
    }
}
