package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        processdata();
    }

    public void processdata(){
        Call<List<ResponseModel>> Call=ApiControlar
                .getInstance()
                .getapi()
                .getData();

        Call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(retrofit2.Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {

                List<ResponseModel> data = response.body();
            }

            @Override
            public void onFailure(retrofit2.Call<List<ResponseModel>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_SHORT).show();

            }
        });

    }

}
