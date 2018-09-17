package com.example.administrateur.mystackappmagique.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrateur.mystackappmagique.QuestionsAdapter;
import com.example.administrateur.mystackappmagique.R;
import com.example.administrateur.mystackappmagique.api.StackClient;
import com.example.administrateur.mystackappmagique.api.StackServiceInterface;
import com.example.administrateur.mystackappmagique.api.pojo.Questions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DernieresQuestionsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dernieres_questions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        StackServiceInterface service =
                StackClient.getClient().create(StackServiceInterface.class);

        service.getQuestions().enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                if (response.isSuccessful()){
                    QuestionsAdapter adapter = new QuestionsAdapter(response.body().getItems());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {

            }
        });
    }
}
