package com.pedro.latihanapi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.pedro.latihanapi.Adapter.CoronaAdapter;
import com.pedro.latihanapi.Model.CoronaModel;
import com.pedro.latihanapi.Network.ApiEndpoint;
import com.pedro.latihanapi.Network.ApiService;
import com.pedro.latihanapi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainProvinsi extends AppCompatActivity {


    private RecyclerView recyclerViewsatu;
    private CoronaAdapter coronaAdapter;
    private ApiEndpoint apiService = ApiService.getUrl().create(ApiEndpoint.class);
    private ProgressBar progressBar;
    private final String TAG = "MainActivity";
    private PieChart pieChartProv;

    private List<CoronaModel.Result> result = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_provinsi);
        setupView();
        setupPieChart();
        pieChartData();
        ShowCorona();
        setupRecycleView();
        getSupportActionBar().hide();
    }

    private void setupView(){

        pieChartProv = findViewById(R.id.nasional);
        recyclerViewsatu = findViewById(R.id.recycleviewsatu);
        progressBar = findViewById(R.id.progresBArr);

    }



    private void setupRecycleView(){
        coronaAdapter = new CoronaAdapter(result);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewsatu.setLayoutManager(layoutManager);
        recyclerViewsatu.setAdapter(coronaAdapter);


    }
    private void ShowCorona(){
        Call<CoronaModel> coronaModels = apiService.getData("indonesia" , "provinsi");
        coronaModels.enqueue(new Callback<CoronaModel>() {
            @Override
            public void onResponse(Call<CoronaModel> call, Response<CoronaModel> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()){
                    CoronaModel coronaModel = response.body();
                    List<CoronaModel.Result> results = coronaModel.getList_data();
                    Log.d(TAG , results.toString());

                    coronaAdapter.setData(results);
                }

            }

            @Override
            public void onFailure(Call<CoronaModel> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG , t.toString());

            }
        });

    }





// Bagian data Chart

    private void setupPieChart(){
        pieChartProv.setDrawHoleEnabled(true);
        pieChartProv.setUsePercentValues(true);
        pieChartProv.setEntryLabelTextSize(10);
        pieChartProv.setEntryLabelColor(Color.BLACK);
        pieChartProv.setCenterText("DATA PROVINSI");
        pieChartProv.setCenterTextSize(10);
        pieChartProv.getDescription().setEnabled(false);

        Legend I = pieChartProv.getLegend();
        I.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        I.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        I.setOrientation(Legend.LegendOrientation.VERTICAL);
        I.setDrawInside(false);
        I.setEnabled(true);

    }



    private void pieChartData(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.5f , "DKI Jakarta"));
        entries.add(new PieEntry(0.30f , "Jawa Tengah"));
        entries.add(new PieEntry(0.30f , "Jawa Barat"));
        entries.add(new PieEntry(0.20f , "Jawa Timur"));
        entries.add(new PieEntry(0.10f , "Sulawesi Selatan"));
        entries.add(new PieEntry(0.10f , "Sumatra Utara"));
        entries.add(new PieEntry(0.15f , "Riau"));
        entries.add(new PieEntry(0.15f , "Banten"));
        entries.add(new PieEntry(0.15f , "Kalimantan Timur"));


        ArrayList<Integer> colors = new ArrayList<>();
        for (Integer color: ColorTemplate.MATERIAL_COLORS){
            colors.add(color);
        }

        for (Integer color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries , "DATA PROVINSI");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChartProv));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChartProv.setData(data);
        pieChartProv.invalidate();
        pieChartProv.animateY(1400 , Easing.EaseOutCirc);


    }














//    BAgian BAwah




    public void arrow(View view) {
        Intent intent = new Intent(MainProvinsi.this , MainActivity.class);
        startActivity(intent);
    }
}