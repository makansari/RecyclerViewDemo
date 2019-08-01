package com.ansari.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Movies_Adapter extends RecyclerView.Adapter<Movies_Adapter.MyViewHolder>{
        List<Movies_Data> movie_list;
    Movies_Data data;

    public Movies_Adapter(List<Movies_Data> movie_list) {
        this.movie_list = movie_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {

         data = movie_list.get(position);
              myViewHolder.titleTextView.setText( data.getTitle());
              myViewHolder.genericTextView.setText(data.getGeneric());
              myViewHolder.dateTextView.setText(data.getDate());

              myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Toast.makeText(v.getContext(), "You clicked " + movie_list.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                  }
              });

             /* myViewHolder.titleTextView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Toast.makeText(v.getContext(), "You selected item " + data.getTitle(position), Toast.LENGTH_SHORT).show();
                  }
              });*/

    }

    @Override
    public int getItemCount() {
        return movie_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView,genericTextView,dateTextView;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.textViewTitle);
            genericTextView = itemView.findViewById(R.id.textViewGeneric);
            dateTextView = itemView.findViewById(R.id.textViewDate);
            linearLayout = itemView.findViewById(R.id.myLinearlayout);


        }
    }
}
