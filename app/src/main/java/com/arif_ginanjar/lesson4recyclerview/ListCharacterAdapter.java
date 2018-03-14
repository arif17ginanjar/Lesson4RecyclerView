package com.arif_ginanjar.lesson4recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arif_Ginanjar on 21/01/2018.
 */

public class ListCharacterAdapter extends RecyclerView.Adapter<ListCharacterAdapter.ChategoryViewHolder>{
    private Context context;
    private ArrayList<Character> listCharacter;

    public ArrayList<Character> getListCharacter(){
        return listCharacter;
    }

    public void setListCharacter(ArrayList<Character> listCharacter){
        this.listCharacter = listCharacter;
    }

    public ListCharacterAdapter(Context context){
        this.context = context;
    }

    @Override
    public ListCharacterAdapter.ChategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_character, parent, false);

        return new ChategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(ListCharacterAdapter.ChategoryViewHolder holder, int position) {
        holder.list_character_name.setText(getListCharacter().get(position).getName());
        holder.list_character_forces.setText(getListCharacter().get(position).getForces());

        Glide.with(context)
                .load(getListCharacter().get(position).getPhoto())
                .override(55,55)
                .crossFade()
                .into(holder.list_character_photos);
    }

    @Override
    public int getItemCount() {
        return getListCharacter().size();
    }

    class ChategoryViewHolder extends RecyclerView.ViewHolder{
        TextView list_character_name;
        TextView list_character_forces;
        ImageView list_character_photos;

        ChategoryViewHolder(View itemView){
            super(itemView);
            list_character_name = (TextView)itemView.findViewById(R.id.list_character_name);
            list_character_forces = (TextView)itemView.findViewById(R.id.list_character_forces);
            list_character_photos = (ImageView)itemView.findViewById(R.id.list_character_photo);
        }

    }

}