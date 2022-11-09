package com.example.aplicationfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
                            Toast.makeText(getApplicationContext(),"seleccion: "+ films.get(recyclerView.getChildAdapterPosition(view)).getOriginal_title_romanised(),Toast.LENGTH_SHORT).show();
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
}