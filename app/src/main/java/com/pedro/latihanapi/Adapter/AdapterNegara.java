package com.pedro.latihanapi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pedro.latihanapi.Model.CoronaModel;
import com.pedro.latihanapi.Model.ModelNegara;
import com.pedro.latihanapi.R;

import java.util.ArrayList;
import java.util.List;


public class AdapterNegara extends RecyclerView.Adapter<AdapterNegara.ViewHolder> {

    private List<ModelNegara.Negara> Negara = new ArrayList<>();

    public AdapterNegara (List<ModelNegara.Negara> negara ){
        this.Negara = negara;

    }

    @NonNull
    @Override
    public AdapterNegara.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_negara , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterNegara.ViewHolder holder, int position) {
        ModelNegara.Negara negara = Negara.get(position);
        holder.textView.setText(negara.getCountry());
        holder.textViewp.setText(Integer.toString(negara.getTotalConfirmed()));
        holder.textViewS.setText(Integer.toString(negara.getTotalRecovered()));
        holder.textViewM.setText(Integer.toString(negara.getTotalDeaths()));

    }

    @Override
    public int getItemCount() {
        return Negara.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView  , textViewp , textViewS , textViewM;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewNegaraN);
            textView = itemView.findViewById(R.id.textViewnegara);
            textViewp = itemView.findViewById(R.id.positifnegara);
            textViewS = itemView.findViewById(R.id.sembuhnegara);
            textViewM = itemView.findViewById(R.id.meniggalNegara);

        }
    }


    public void setData( List<ModelNegara.Negara> data){
        Negara.clear();
        Negara.addAll(data);
        notifyDataSetChanged();

    }
}
