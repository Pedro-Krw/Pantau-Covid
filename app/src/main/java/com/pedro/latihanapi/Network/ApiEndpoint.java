package com.pedro.latihanapi.Network;

import com.pedro.latihanapi.Model.CoronaModel;
import com.pedro.latihanapi.Model.ModelGlobal;
import com.pedro.latihanapi.Model.ModelNegara;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoint {

    @GET("public/api/prov.json")
    Call<CoronaModel> getData(
            @Query("indonesia/") String indonesia,
            @Query("provinsi") String provinsi

    );

    @GET("positif/")
    Call<ModelGlobal> getDataGlobal();
//
    @GET("sembuh/")
    Call<ModelGlobal> getDataGlobalS();

    @GET("meninggal/")
    Call<ModelGlobal> getDataGlobalM();



    @GET("summary")
    Call<ModelNegara> getDataNegara();
}
