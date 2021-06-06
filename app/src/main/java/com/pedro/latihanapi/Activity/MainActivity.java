package com.pedro.latihanapi.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.pedro.latihanapi.Model.ModelGlobal;
import com.pedro.latihanapi.Network.ApiEndpoint;
import com.pedro.latihanapi.Network.ApiService;
import com.pedro.latihanapi.R;
import com.spark.imageslider.ImageSlider;
import com.spark.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    private ApiEndpoint apiService = ApiService.getGlobal().create(ApiEndpoint.class);
    private Integer data;
    private TextView textViewP, textViewS, textViewM;
    private ProgressBar progressBar;
    private final String TAG = "MainActivity";
    private ImageSlider imageSlider;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setupPieChart();
        pieChartData();
        getPositif();
        getSembuh();
        getMeniggal();
        getSupportActionBar().hide();

    }


    @Override
    protected void onStart() {
        super.onStart();


        imageSlider = findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1587663487487-7ee033d4a0b9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1067&q=80" , "Stay healthy") );
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1585984968562-1443b72fb0dc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80" , "Stay safe") );
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1585503420466-8fec090733bb?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=889&q=80" , "Stay at home") );
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1595126930630-57c02597c734?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80" , "stay healthy wash your hands") );

        imageSlider.setImageList(slideModels);
    }




    private void setupView() {
        pieChart = findViewById(R.id.PieChartTampilan);
        textViewP = findViewById(R.id.textG);
        textViewM = findViewById(R.id.textM);
        textViewS = findViewById(R.id.textS);
        progressBar = findViewById(R.id.progres);
    }



    private void getPositif(){
        Call<ModelGlobal> call = apiService.getDataGlobal();
        call.enqueue(new Callback<ModelGlobal>() {
            @Override
            public void onResponse(Call<ModelGlobal> call, Response<ModelGlobal> response) {
                if (response.isSuccessful()){
                    ModelGlobal model = response.body();
                    textViewP.setText(model.getValue());
                    Log.d(TAG , response.toString());

                }
            }

            @Override
            public void onFailure(Call<ModelGlobal> call, Throwable t) {

            }
        });


    }




    private void getSembuh(){
        Call<ModelGlobal> callS = apiService.getDataGlobalS();
        callS.enqueue(new Callback<ModelGlobal>() {
            @Override
            public void onResponse(Call<ModelGlobal> call, Response<ModelGlobal> response) {
                textViewS.setText(response.body().getValue());
            }

            @Override
            public void onFailure(Call<ModelGlobal> call, Throwable t) {

            }
        });

    }




    private void getMeniggal(){
        Call<ModelGlobal> callM = apiService.getDataGlobalM();
        callM.enqueue(new Callback<ModelGlobal>() {
            @Override
            public void onResponse(Call<ModelGlobal> call, Response<ModelGlobal> response) {
                textViewM.setText(response.body().getValue());
            }

            @Override
            public void onFailure(Call<ModelGlobal> call, Throwable t) {

            }
        });

    }


// Bagian data Chart

    private void setupPieChart(){
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(10);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("DATA GLOBAL");
        pieChart.setCenterTextSize(10);
        pieChart.getDescription().setEnabled(false);

        Legend I = pieChart.getLegend();
        I.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        I.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        I.setOrientation(Legend.LegendOrientation.VERTICAL);
        I.setDrawInside(false);
        I.setEnabled(true);

    }



    private void pieChartData(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.60f , "Positif"));
        entries.add(new PieEntry(0.30f , "Sembuh"));
        entries.add(new PieEntry(0.10f , "Meninggal"));


        ArrayList<Integer> colors = new ArrayList<>();
        for (Integer color: ColorTemplate.MATERIAL_COLORS){
          colors.add(color);
        }

        for (Integer color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries , "DATA GLOBAL");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();
        pieChart.animateY(1400 , Easing.EaseInOutQuad);


    }









// Bagian Dari Even Click Pada XML
// Silahkan Tambahkan event Click Lainya Di Sini
    public void global(View view) {
        Intent intent = new Intent(MainActivity.this , MainGlobal.class);
        startActivity(intent);
    }

    public void info(View view) {
        Intent intent = new Intent(MainActivity.this , InfoActivity.class);
        startActivity(intent);
    }

    public void prov(View view) {
        Intent intent = new Intent(MainActivity.this , MainProvinsi.class);
        startActivity(intent);
    }
}