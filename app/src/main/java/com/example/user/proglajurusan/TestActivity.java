package com.example.user.proglajurusan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    ListView lsvTanya;
    TanyaModel tanyaModel;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tanyaModel = new TanyaModel();
        lsvTanya = findViewById(R.id.lsvTanya);
        button = findViewById(R.id.btnhasiltest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Service.service_get.getTanya().enqueue(new Callback<TanyaModel>() {
                    @Override
                    public void onResponse(Call<TanyaModel> call, Response<TanyaModel> response) {
                        if (response.code() == 200){
                            tanyaModel = response.body();
                            ArrayList<DataTanyaModel> daftarPertanyaan = tanyaModel.getData();

                            TanyaAdapter adapter = new TanyaAdapter(TestActivity.this, daftarPertanyaan);
                            lsvTanya.setAdapter(adapter);
                            Toast.makeText(TestActivity.this, "berhasil ambil data", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(TestActivity.this, "tidak ada pertanyaan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<TanyaModel> call, Throwable t) {
                        Toast.makeText(TestActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
