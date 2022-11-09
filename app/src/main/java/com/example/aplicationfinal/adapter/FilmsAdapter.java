package com.example.aplicationfinal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aplicationfinal.R;
import com.example.aplicationfinal.model.Films;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> implements View.OnClickListener {

    private List<Films> films;
    private Context context;
    private View.OnClickListener listener;

    //OnClickListener
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public FilmsAdapter(List<Films> films, Context context) {
        this.films = films;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_films,parent,false);
        //OnClickListener
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(films.get(position).getTitle());
        holder.year.setText(films.get(position).getRelease_date());
        Glide.with(context).load(films.get(position).getImage()).into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView  title;
        private TextView  year;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen=itemView.findViewById(R.id.Imagen);
            title=itemView.findViewById(R.id.titulo);
            year=itemView.findViewById(R.id.releaseDate);
        }
    }
}
