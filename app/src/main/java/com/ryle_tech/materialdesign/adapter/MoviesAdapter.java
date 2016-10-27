package com.ryle_tech.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryle_tech.materialdesign.data.Movie;
import com.ryle_tech.materialdesign.data.Movies;
import com.ryle_tech.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder>{

    ArrayList<Movies> moviesData = new ArrayList<>();
    Context context;
//    private static final int LAYOUT = 0;

    public MoviesAdapter(Context baseContext, ArrayList<Movies> moviesData) {
        this.moviesData = moviesData;
        this.context = baseContext;
    }

    public MoviesAdapter(List<Movie> movies, int list_item_movie, Context applicationContext) {


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_designer, parent, false);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Movies movie = moviesData.get(position);

        System.out.println("Adapter movie= "+movie.toString());

        holder.movieName.setText(movie.getMovieName());
        holder.movieDescription.setText(movie.getMovieDescription());
//        holder.likeButton.setOnLikeListener(new OnLikeListener() {
//            @Override
//            public void liked(LikeButton likeButton) {
//                holder.likeButton.setLiked(true);
//                Toast.makeText(context, "Liked", Toast.LENGTH_SHORT).show();
////                holder.textViewLike.setTextColor(context.getResources().getColor(R.color.likeTextColorOn));
//            }
//
//            @Override
//            public void unLiked(LikeButton likeButton) {
//                holder.likeButton.setLiked(false);
////                holder.textViewLike.setTextColor(context.getResources().getColor(R.color.textColor));
//            }
//        });
//        holder.lLComment.setOnClickListener(this);
//        holder.lLShare.setOnClickListener(this);
//        holder.commentsNumber.setText("(" + moviesData.get(position).getCommentsNumber() + ")");

    }

    @Override
    public int getItemCount() {
        return moviesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieName, movieDescription,commentsNumber;
        //        LikeButton likeButton;
//        LinearLayout lLShare;
//        LinearLayout lLComment;
        public ViewHolder(View view) {
            super(view);
            movieName = (TextView) view.findViewById(R.id.designerName);
            movieDescription = (TextView) view.findViewById(R.id.description);

//likeButton = (LikeButton) view.findViewById(R.id.likeButton);
//            lLComment = (LinearLayout) view.findViewById(R.id.lLComment);
//            lLShare = (LinearLayout) view.findViewById(R.id.lLShare);
//            commentsNumber = (TextView) view.findViewById(R.id.commentsNumber);

//            mTextView = view;
//            mTextView=view.findViewById(R.id.)
        }
    }

//    @Override
//    public void onClick(View v) {
//switch (v.getId()){
//    case R.id.lLShare:
//        Toast.makeText(context, "Share Clicked", Toast.LENGTH_SHORT).show();
//        break;
//    case R.id.lLComment:
//        Toast.makeText(context, "Comment Clicked", Toast.LENGTH_SHORT).show();
//        break;
//
//
//}

    }


