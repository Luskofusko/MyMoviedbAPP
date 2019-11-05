package com.example.moviedbmyapp.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.moviedbmyapp.MainActivity;
import com.example.moviedbmyapp.R;
import com.example.moviedbmyapp.model.Movie;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {



    private Context mContext;
    private List<Movie> movieList;
    private PopupWindow mPopupWindow;
    Dialog mDialog;

    public MoviesAdapter(Context mContext, List<Movie> movieList){
        this.mContext = mContext;
        this.movieList = movieList;
    }



    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_row_item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MoviesAdapter.MyViewHolder viewHolder, int i){
        viewHolder.title.setText(movieList.get(i).getOriginalTitle());

        viewHolder.release_date.setText(movieList.get(i).getReleaseDate());

        /*viewHolder.title_detail.setText(movieList.get(i).getOriginalTitle());
        String vote2 = Double.toString(movieList.get(i).getVoteAverage());
        viewHolder.userrating_detail.setText(vote2);
        viewHolder.synopsis_detail.setText(movieList.get(i).getOverview());
        viewHolder.release_date_detail_.setText(movieList.get(i).getReleaseDate());
        */
        /*genre
        List <Movie.GenresBean> genres = movieList.get(i).getGenres();
        Movie m = movieList.get(i);
        //ArrayList<Integer> GenresIDs = m.getGenres().get(i).getId();

        String genreStr = "";
        if( genres != null )
            for (Movie.GenresBean atual : genres) {
                genreStr += atual.getName() + ", ";
            }
        /*genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;*/
        //genre.setText(genreStr);
        //viewHolder.genreST.setText(genreStr);

        //List <Movie.GenresBean> genre = new ArrayList<>();
        //viewHolder.category.setText(genre.get(i).getName());*/
        String vote = Double.toString(movieList.get(i).getVoteAverage());
        viewHolder.userrating.setText(vote);

        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(i).getPosterPath();

        Glide.with(mContext)
                .load(poster)
                .placeholder(R.drawable.loading)
                .into(viewHolder.thumbnail);
        //Glide.with(mContext).load(poster).placeholder(R.drawable.loading).into(viewHolder.thumbail_detail);

    }

    @Override

    public int getItemCount(){
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, userrating, release_date, synopsis_detail, title_detail, userrating_detail, release_date_detail_;
        public ImageView thumbnail, thumbail_detail;

        public MyViewHolder(final View view){
            super(view);
            mDialog = new Dialog(view.getContext());

            Point p;
            int[] location = new int[2];
            title = view.findViewById(R.id.movie_name);
            release_date = view.findViewById(R.id.releasedate);
            userrating = view.findViewById(R.id.rating);
            thumbnail = view.findViewById(R.id.thumbnail);


            synopsis_detail = view.findViewById(R.id.description_detail);
            release_date_detail_= view.findViewById(R.id.release_date_detail);
            userrating_detail = view.findViewById(R.id.rating_detail);
            thumbail_detail = view.findViewById(R.id.thumbnail_detail);

            userrating.getLocationOnScreen(location);


            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    mDialog.setContentView(R.layout.movie_detail);
                    title_detail = mDialog.findViewById(R.id.movie_name_detail);
                    synopsis_detail = mDialog.findViewById(R.id.description_detail);
                    release_date_detail_= mDialog.findViewById(R.id.release_date_detail);
                    userrating_detail = mDialog.findViewById(R.id.rating_detail);
                    thumbail_detail = mDialog.findViewById(R.id.thumbnail_detail);

                    if (pos != RecyclerView.NO_POSITION){
                        Movie clickedDataItem = movieList.get(pos);
                        //title_detail.setText(movieList.get(pos).getOriginalTitle());

                        movieList.get(pos).getReleaseDate();
                        movieList.get(pos).getOverview();



                        //LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                        // Inflate the custom layout/view
                        //View customView = inflater.inflate(R.layout.movie_detail,null);


                        // Get a reference for the custom view close button
                        //Button closeButton =  customView.findViewById(R.id.btn_close_popup);

                        // Set a click listener for the popup window close button


                        //mPopupWindow.showAtLocation(mLinearLayout, Gravity.NO_GRAVITY,300,300);

                        //Intent intent = new Intent(mContext, MovieActivityDetail.class);
                        //intent.putExtra("movies", clickedDataItem );
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //mContext.startActivity(intent);
                        Toast.makeText(v.getContext(),pos + "You clicked " + clickedDataItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();
                        Log.d("SHOW", movieList.get(pos).getOriginalTitle() );
                        title_detail.setText(movieList.get(pos).getOriginalTitle());
                        release_date_detail_.setText(movieList.get(pos).getReleaseDate());
                        synopsis_detail.setText(movieList.get(pos).getOverview());
                        String vote2 = Double.toString(movieList.get(pos).getVoteAverage());
                        userrating_detail.setText(vote2);
                        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(pos).getPosterPath();

                        Glide.with(mContext)
                                .load(poster)
                                .placeholder(R.drawable.loading)
                                .into(thumbail_detail);

                        thumbail_detail.setScaleType(ImageView.ScaleType.FIT_END);




                        //viewHolder.title_detail.setText(movieList.get(i).getOriginalTitle());
                        mDialog.show();
                    }
                }
            });
        }

    }



}