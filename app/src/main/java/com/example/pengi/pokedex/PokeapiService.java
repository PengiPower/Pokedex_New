package com.example.pengi.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeapiService {

    @GET("pokemon")
    Call<Pokedex> getPokemon(@Query("limit") int limit, @Query("offset") int offset);

}
