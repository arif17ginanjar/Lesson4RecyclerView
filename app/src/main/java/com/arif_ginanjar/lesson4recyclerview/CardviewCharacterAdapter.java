package com.arif_ginanjar.lesson4recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Arif_Ginanjar on 21/01/2018.
 */

public class CardviewCharacterAdapter extends RecyclerView.Adapter<CardviewCharacterAdapter.CardviewViewHolder> {

    private Context context;
    private ArrayList<Character> listCharacter;

    public CardviewCharacterAdapter(Context context){
        this.context = context;
    }

    public ArrayList<Character> getListCharacter(){
        return listCharacter;
    }

    public void setListCharacter(ArrayList<Character> listCharacter){
        this.listCharacter = listCharacter;
    }

    @Override
    public CardviewCharacterAdapter.CardviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_character, parent, false);

        return new CardviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardviewCharacterAdapter.CardviewViewHolder holder, int position) {

        Character data = getListCharacter().get(position);

        Glide.with(context)
                .load(data.getPhoto())
                .override(350, 350)
                .into(holder.cardview_chracter_photo);

        holder.cardview_character_name.setText(data.getName());
        holder.cardview_character_forces.setText(data.getForces());

        holder.cardview_character_favorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback(){

            @Override
            public void onItemClicked(View view, int position){
                Toast.makeText(context, "Favorite "+getListCharacter().get(position).getName(), Toast.LENGTH_SHORT).show();
            }

        }));

        holder.cardview_character_share.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback(){

            @Override
            public void onItemClicked(View view, int position){
                Toast.makeText(context, "Share "+getListCharacter().get(position).getName(), Toast.LENGTH_SHORT).show();
            }

        }));

    }

    @Override
    public int getItemCount() {
        return getListCharacter().size();
    }

    class CardviewViewHolder extends RecyclerView.ViewHolder{
        TextView cardview_character_name, cardview_character_forces;
        ImageView cardview_chracter_photo;
        Button cardview_character_favorite, cardview_character_share;

        public CardviewViewHolder(View itemView) {
            super(itemView);

            cardview_character_name = (TextView)itemView.findViewById(R.id.cardview_character_name);
            cardview_character_forces = (TextView)itemView.findViewById(R.id.cardview_character_forces);
            cardview_chracter_photo = (ImageView)itemView.findViewById(R.id.cardview_character_photo);
            cardview_character_favorite = (Button)itemView.findViewById(R.id.cardview_character_favorite);
            cardview_character_share = (Button)itemView.findViewById(R.id.cardview_character_share);
        }
    }
}