package com.zbk.mymovielist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // pojo - plain old java object
    // model bhi kaha jata h
    class Movie{
        String name;
        int year;
        double rating;

        public Movie(String name, int year, double rating) {
            this.name = name;
            this.year = year;
            this.rating = rating;
        }
    }

    ArrayList<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        movieList.add(new Movie("Bahubali",2016,9.5));
        movieList.add(new Movie("Bahubali 2",2018,9.8));
        movieList.add(new Movie("Captain America:Civil war",2016,9.4));
        movieList.add(new Movie("Hobbs & Shaw",2019,8));
        movieList.add(new Movie("Fast & Furious",2016,7));
        movieList.add(new Movie("Black panther",2018,9));
        movieList.add(new Movie("Spiderman Far from Home",2018,9));
        movieList.add(new Movie("Shazam",2018,7));
        movieList.add(new Movie("Aquaman",2018,9));
        movieList.add(new Movie("MIB international",2019,6));
        movieList.add(new Movie("A dogs way home",2019,8));
        movieList.add(new Movie("Lego Movie",2015,9.5));
        movieList.add(new Movie("Lego Movie 2",2018,9));

        RecyclerView recyclerMovies = findViewById(R.id.recylerMovies);
        MovieAdapter adapter= new MovieAdapter(this,movieList);
        recyclerMovies.setLayoutManager(new LinearLayoutManager(this));
        recyclerMovies.setAdapter(adapter);



    }

    class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder>{

        Context context;
        ArrayList<Movie> movies ;
        LayoutInflater inflater;

        public MovieAdapter(Context context, ArrayList<Movie> movies) {
            this.context = context;
            this.movies = movies;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public MovieAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.card, parent,false);
            Holder h = new Holder(v);
            return h;
        }

        @Override
        public void onBindViewHolder(@NonNull MovieAdapter.Holder holder, int position) {
            Movie movie = movies.get(position);
            holder.textMovieName.setText(movie.name);
            holder.textMovieYear.setText(String.valueOf(movie.year));
            holder.ratingMovie.setProgress((int) movie.rating);
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        public class Holder extends RecyclerView.ViewHolder {

            TextView textMovieName,textMovieYear;
            RatingBar ratingMovie;

            public Holder(@NonNull View itemView) {
                super(itemView);
                textMovieName = itemView.findViewById(R.id.textMovieName);
                textMovieYear = itemView.findViewById(R.id.textMovieYear);
                ratingMovie = itemView.findViewById(R.id.ratingMovie);
            }
        }
    }

}
