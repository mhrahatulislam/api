package com.example.myapplication;

import androidx.annotation.NonNull;
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
        recyclerView = findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        processData();
    }

    public void processData() {
        Call<List<ResponseModel>> call = ApiControlar.getInstance().getapi().getData();
        call.enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<List<ResponseModel>> call, @NonNull Response<List<ResponseModel>> response) {

                List<ResponseModel> data = response.body();
                AdapterClass adapterClass = new AdapterClass(data);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(adapterClass);
            }

            @Override
            public void onFailure(@NonNull retrofit2.Call<List<ResponseModel>> call, @NonNull Throwable t) {

                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
