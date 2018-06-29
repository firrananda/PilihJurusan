package com.example.user.proglajurusan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    RecyclerView lsvTanya;
    RecyclerView.Adapter adapter;
    TanyaModel tanyaModel;
    Button button;
    ArrayList<DataTanyaModel> daftarPertanyaan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tanyaModel = new TanyaModel();
        lsvTanya = findViewById(R.id.lsvTanya);
        button = findViewById(R.id.btnhasiltest);


        Service.service_get.getTanya().enqueue(new Callback<TanyaModel>() {
            @Override
            public void onResponse(Call<TanyaModel> call, Response<TanyaModel> response) {
                if (response.code() == 200){
                    tanyaModel = response.body();
                    lsvTanya.setHasFixedSize(true);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(TestActivity.this);
                    lsvTanya.setLayoutManager(layoutManager);
                    daftarPertanyaan = tanyaModel.getData();
                    adapter = new TanyaAdapter(TestActivity.this, daftarPertanyaan);
                    lsvTanya.setAdapter(adapter);
                    Toast.makeText(TestActivity.this, "berhasil ambil data ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(TestActivity.this, "tidak ada pertanyaan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TanyaModel> call, Throwable t) {
                Toast.makeText(TestActivity.this, "gagal : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, HasilActivity.class);
                startActivity(intent);
            }
        });



    }
}
