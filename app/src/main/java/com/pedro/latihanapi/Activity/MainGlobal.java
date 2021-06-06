package com.pedro.latihanapi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pedro.latihanapi.Adapter.AdapterNegara;
import com.pedro.latihanapi.Adapter.CoronaAdapter;
import com.pedro.latihanapi.Model.CoronaModel;
import com.pedro.latihanapi.Model.ModelGlobal;
import com.pedro.latihanapi.Model.ModelNegara;
import com.pedro.latihanapi.Network.ApiEndpoint;
import com.pedro.latihanapi.Network.ApiService;
import com.pedro.latihanapi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainGlobal extends AppCompatActivity {

    private ApiEndpoint endpoint = ApiService.getNegara().create(ApiEndpoint.class);
    private final String TAG = "MainGlobal";
    private TextView textView;
    private AdapterNegara adapterNegara;
    private RecyclerView recyclerViewN;
    private ProgressBar progressBar;
    private List<ModelNegara.Negara> Negara = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_global);
        setupView();
        setupRecycleView();
        ShowCorona();
        getSupportActionBar().hide();

    }




    private void setupView(){
        recyclerViewN = findViewById(R.id.recycleviewN);
        progressBar = findViewById(R.id.progres);

    }



    private void setupRecycleView(){
        adapterNegara = new AdapterNegara(Negara);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewN.setLayoutManager(layoutManager);
        recyclerViewN.setAdapter(adapterNegara);


    }
    private void ShowCorona(){
        Call<ModelNegara> coronaModels = endpoint.getDataNegara();
        coronaModels.enqueue(new Callback<ModelNegara>() {
            @Override
            public void onResponse(Call<ModelNegara> call, Response<ModelNegara> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()){
                    ModelNegara coronaModel = response.body();
                    List<ModelNegara.Negara> results = coronaModel.getCountries();
                    Log.d(TAG , results.toString());

                    adapterNegara.setData(results);
                }

            }

            @Override
            public void onFailure(Call<ModelNegara> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG , t.toString());

            }
        });

    }



    public void backGlobal(View view) {
        Intent intent = new Intent(MainGlobal.this , MainActivity.class);
        startActivity(intent);
    }
}



