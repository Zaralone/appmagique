package com.example.administrateur.mystackappmagique.api;
import com.example.administrateur.mystackappmagique.api.pojo.Questions;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StackServiceInterface {

    @GET("/questions?order=desc&sort=activity&site=stackoverflow")
    Call<Questions> getQuestions();

}
