package com.example.marco.audirs7;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Marco on 13.4.2016..
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AudiViewHolder> {

    CustomItemClickListener listener;

    public static class AudiViewHolder extends  RecyclerView.ViewHolder    {


        TextView carName;
        TextView carPrice;
        TextView carConsumption;
        ImageView carPhoto;


        AudiViewHolder(View itemView) {
            super(itemView);
            carName = (TextView)itemView.findViewById(R.id.car_name);
            carPrice = (TextView)itemView.findViewById(R.id.car_price);
            carConsumption = (TextView)itemView.findViewById(R.id.car_consumption);
            carPhoto = (ImageView)itemView.findViewById(R.id.car_photo);
        }
    }

    List<Audi> audi;

    RecyclerAdapter(List<Audi> audi, CustomItemClickListener listener){
        this.audi = audi;
        this.listener = listener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public AudiViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        final AudiViewHolder avh = new AudiViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, avh.getLayoutPosition());
            }
        });
        return avh;
    }

    @Override
    public void onBindViewHolder(AudiViewHolder audiViewHolder, int i) {
        audiViewHolder.carName.setText(audi.get(i).naziv);
        audiViewHolder.carPrice.setText(audi.get(i).cijena);
        audiViewHolder.carConsumption.setText(audi.get(i).potrosnja);
        audiViewHolder.carPhoto.setImageResource(audi.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return audi.size();
    }
}


