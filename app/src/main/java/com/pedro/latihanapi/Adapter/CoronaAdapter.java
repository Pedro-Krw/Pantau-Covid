package com.pedro.latihanapi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pedro.latihanapi.Model.CoronaModel;
import com.pedro.latihanapi.R;

import java.util.ArrayList;
import java.util.List;

public class CoronaAdapter extends RecyclerView.Adapter<CoronaAdapter.ViewHolder> {
    private List<CoronaModel.Result> result = new ArrayList<>();

    public CoronaAdapter (List<CoronaModel.Result> result ){
        this.result = result;

    }


    public CoronaAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new  ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptermain , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CoronaModel.Result resutl = result.get(position);
        holder.textView.setText(resutl.getKey());
        holder.total.setText(Integer.toString(resutl.getJumlah_kasus()));
        holder.sembuh.setText(Integer.toString(resutl.getJumlah_sembuh()));
        holder.meniggal.setText(Integer.toString(resutl.getJumlah_meninggal()));
        holder.rawat.setText(Integer.toString(resutl.getJumlah_dirawat()));
        holder.biasa2.setText("😥 Jumlah Meninggal : ");
        holder.biasa.setText("😔 Jumlah Kasus : ");
        holder.biasa1.setText("🥰 Jumlah Sembuh : ");
        holder.biasa3.setText("😷 Jumlah Dirawat : ");
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView , total ,sembuh , meniggal , rawat,  biasa , biasa1 , biasa2 , biasa3;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

           imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            total = itemView.findViewById(R.id.total);
            total = itemView.findViewById(R.id.total);
            sembuh = itemView.findViewById(R.id.sembuh);
            meniggal = itemView.findViewById(R.id.cry);
            rawat = itemView.findViewById(R.id.rawat);
            biasa = itemView.findViewById(R.id.biasa);
            biasa1 = itemView.findViewById(R.id.biasa1);
            biasa2 = itemView.findViewById(R.id.biasa2);
            biasa3 = itemView.findViewById(R.id.biasa3);





        }
    }

    public void setData( List<CoronaModel.Result> data){
        result.clear();
        result.addAll(data);
        notifyDataSetChanged();

    }

}
