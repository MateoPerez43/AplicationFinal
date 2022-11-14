package com.example.aplicationfinal;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import java.net.URL;

public class Activity_2 extends AppCompatActivity {

    TextView title,original_title,original_title_romanised,description,director,producer,release_date,running_time,rt_score;
    String titles,original_titles,original_title_romaniseds,images,movie_banners,descriptions,directors,producers,release_dates,running_times,rt_scores;
    ImageView movie_banner,image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        title= findViewById(R.id.title);
        original_title= findViewById(R.id.titleOriginal);
        original_title_romanised= findViewById(R.id.titleRemanised);
        movie_banner= findViewById(R.id.movie_Banner);
        description= findViewById(R.id.descripcion);
        director= findViewById(R.id.director);
        producer= findViewById(R.id.productor);
        release_date= findViewById(R.id.releaseDate);
        running_time= findViewById(R.id.runningTime);
        rt_score= findViewById(R.id.score);

        Intent datos = this.getIntent();

        titles= datos.getStringExtra("title");
        original_titles= datos.getStringExtra("originalTitle");
        original_title_romaniseds= datos.getStringExtra("originalTitleRomanised");
        movie_banners= datos.getStringExtra("imageBanner");
        descriptions= datos.getStringExtra("description");
        directors= datos.getStringExtra("director");
        producers= datos.getStringExtra("productor");
        release_dates= datos.getStringExtra("releaseDate");
        running_times= datos.getStringExtra("runningTime");
        rt_scores= datos.getStringExtra("score");
        images= datos.getStringExtra("image");

        title.setText(titles);
        original_title.setText(original_titles);
        original_title_romanised.setText(original_title_romaniseds);
        Glide.with(this).load(movie_banners).into(this.movie_banner);
        description.setText(descriptions);
        director.setText(directors);
        producer.setText(producers);
        release_date.setText(release_dates);
        running_time.setText(running_times);
        rt_score.setText(rt_scores);


    }

}