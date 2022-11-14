package com.example.aplicationfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.aplicationfinal.adapter.FilmsAdapter;
import com.example.aplicationfinal.model.Films;
import com.example.aplicationfinal.network.ApiClient;
import com.example.aplicationfinal.network.ApiFilms;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Films> films;
    private RecyclerView recyclerView;
    private FilmsAdapter filmsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerViewFilms);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        showFilms();

    }

    public void showFilms (){
        Call<List<Films>> call= ApiClient.getClient().create(ApiFilms.class).getFilms();
        call.enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                if (response.isSuccessful()){
                    films=response.body();
                    filmsAdapter= new FilmsAdapter(films,getApplicationContext());

                    filmsAdapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            moveToDescription(view);
                        }
                    });
                    recyclerView.setAdapter(filmsAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de Conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void moveToDescription(View view) {
        Intent segunda = new Intent(MainActivity.this, Activity_2.class)
                .putExtra("title",films.get(recyclerView.getChildAdapterPosition(view)).getTitle())
                .putExtra("originalTitle",films.get(recyclerView.getChildAdapterPosition(view)).getOriginal_title())
                .putExtra("originalTitleRomanised",films.get(recyclerView.getChildAdapterPosition(view)).getOriginal_title_romanised())
                .putExtra("imageBanner",films.get(recyclerView.getChildAdapterPosition(view)).getMovie_banner())
                .putExtra("description",films.get(recyclerView.getChildAdapterPosition(view)).getDescription())
                .putExtra("director",films.get(recyclerView.getChildAdapterPosition(view)).getDirector())
                .putExtra("productor",films.get(recyclerView.getChildAdapterPosition(view)).getProducer())
                .putExtra("releaseDate",films.get(recyclerView.getChildAdapterPosition(view)).getRelease_date())
                .putExtra("runningTime",films.get(recyclerView.getChildAdapterPosition(view)).getRunning_time())
                .putExtra("score",films.get(recyclerView.getChildAdapterPosition(view)).getRt_score())
                .putExtra("image",films.get(recyclerView.getChildAdapterPosition(view)).getImage());
        startActivity(segunda);
    }

}