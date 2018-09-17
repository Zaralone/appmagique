package com.example.administrateur.mystackappmagique;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrateur.mystackappmagique.api.pojo.Item;
import com.example.administrateur.mystackappmagique.database.AppDatabase;
import com.example.administrateur.mystackappmagique.database.Favoris;
import com.squareup.picasso.Picasso;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.ViewHolder> {

    private List<Item> questions;

    public QuestionsAdapter(List<Item> questions){
        this.questions = questions;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProfil;
        TextView txtQuestion, txtDate;
        ImageButton imageButton;
        ViewHolder(View itemView) {
            super(itemView);
            imgProfil = itemView.findViewById(R.id.img_profil);
            txtQuestion = itemView.findViewById(R.id.txt_question);
            txtDate = itemView.findViewById(R.id.txt_date);
            imageButton = itemView.findViewById(R.id.favorikiki);

        }
    }

    @NonNull
    @Override
    public QuestionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionsAdapter.ViewHolder holder, int position) {
        final Item item = questions.get(position);
        holder.txtQuestion.setText(item.getTitle());
        holder.txtDate.setText("" + new SimpleDateFormat("dd-MM-yyyy").format(new Date(item.getCreationDate())) );
        Picasso.get().load(item.getOwner().getProfileImage()).into(holder.imgProfil);

        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getINSTANCE(holder.itemView.getContext());
                db.favorisDao().insertFavoris(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
