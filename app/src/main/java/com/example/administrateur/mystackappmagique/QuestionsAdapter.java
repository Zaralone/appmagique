package com.example.administrateur.mystackappmagique;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrateur.mystackappmagique.api.pojo.Item;
import com.squareup.picasso.Picasso;


import java.util.List;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> {

    private List<Item> questions;

    public QuestionsAdapter(List<Item> questions){
        this.questions = questions;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProfil;
        TextView txtQuestion, txtDate;
        ViewHolder(View itemView) {
            super(itemView);
            imgProfil = itemView.findViewById(R.id.img_profil);
            txtQuestion = itemView.findViewById(R.id.txt_question);
            txtDate = itemView.findViewById(R.id.txt_date);
        }
    }

    @NonNull
    @Override
    public QuestionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsAdapter.ViewHolder holder, int position) {
        Item item = questions.get(position);
        holder.txtQuestion.setText(item.getTitle());
        holder.txtDate.setText("" + item.getCreationDate());
        Picasso.get().load(item.getOwner().getProfileImage()).into(holder.imgProfil);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
