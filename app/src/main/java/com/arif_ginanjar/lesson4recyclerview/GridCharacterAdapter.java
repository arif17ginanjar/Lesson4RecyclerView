package com.arif_ginanjar.lesson4recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Arif_Ginanjar on 21/01/2018.
 */

public class GridCharacterAdapter extends RecyclerView.Adapter<GridCharacterAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<Character> listChracter;

    public ArrayList<Character> getListChracter(){
        return listChracter;
    }

    public void setListChracter(ArrayList<Character> listChracter){
        this.listChracter = listChracter;
    }

    public GridCharacterAdapter(Context context){
        this.context = context;
    }

    @Override
    public GridCharacterAdapter.GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_character, parent, false);

        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridCharacterAdapter.GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListChracter().get(position).getPhoto())
                .override(350,550)
                .into(holder.grid_character_photo);
    }

    @Override
    public int getItemCount() {
        return getListChracter().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView grid_character_photo;

        public GridViewHolder(View itemView) {
            super(itemView);
            grid_character_photo = (ImageView)itemView.findViewById(R.id.grid_character_photo);
        }

    }
}
