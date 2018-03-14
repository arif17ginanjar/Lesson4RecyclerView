package com.arif_ginanjar.lesson4recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView activity_main_recyclerview;
    private ArrayList<Character> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity_main_recyclerview = (RecyclerView)findViewById(R.id.activity_main_recyclerview);
        activity_main_recyclerview.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(CharacterData.getListData());

        setActionBarTitle("Mode List");
        showRecyclerList();
    }

    private void showRecyclerList(){
        activity_main_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        ListCharacterAdapter listCharacterAdapter = new ListCharacterAdapter(this);
        listCharacterAdapter.setListCharacter(list);

        activity_main_recyclerview.setAdapter(listCharacterAdapter);

        ItemClickSupport.addTo(activity_main_recyclerview).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedCharacter(list.get(position));
            }
        });
    }

    private void showRecyclerGrid(){
        activity_main_recyclerview.setLayoutManager(new GridLayoutManager(this, 2));

        GridCharacterAdapter gridCharacterAdapter = new GridCharacterAdapter(this);
        gridCharacterAdapter.setListChracter(list);

        activity_main_recyclerview.setAdapter(gridCharacterAdapter);

        ItemClickSupport.addTo(activity_main_recyclerview).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedCharacter(list.get(position));
            }
        });
    }

    private void showRecyclerCardview(){
        activity_main_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        CardviewCharacterAdapter cardviewCharacterAdapter = new CardviewCharacterAdapter(this);
        cardviewCharacterAdapter.setListCharacter(list);

        activity_main_recyclerview.setAdapter(cardviewCharacterAdapter);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showSelectedCharacter(Character character){
        Toast.makeText(this, "Kamu memilih "+character.getName(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String title = null;

        switch (item.getItemId()){
            case R.id.menu_main_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.menu_main_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.menu_main_card:
                title = "Mode Cardview";
                showRecyclerCardview();
                break;
        }

        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }

}
