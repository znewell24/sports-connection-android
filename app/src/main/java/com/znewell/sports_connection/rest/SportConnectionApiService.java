package com.znewell.sports_connection.rest;

import com.znewell.sports_connection.model.Player;
import com.znewell.sports_connection.model.PlayerResponse;
import com.znewell.sports_connection.model.Sport;
import com.znewell.sports_connection.model.SportResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SportConnectionApiService {

    @GET("/sports")
    Call<SportResponse> getAllSports();

    @GET("/sports/id")
    Call<Sport> getSportById(@Query("id")int id);

    @DELETE("/sports/id/")
    Call<Integer> deleteSportById(@Query("id")int id);

    @POST("/sports/update")
    Call<Sport> updateSport(@Body Sport sport);

    @POST("/sports/insert")
    Call<Sport> insertSport(@Body Sport sport);

    @POST("/players")
    Call<PlayerResponse> getAllPlayersForSport(@Body Sport sport);

    @DELETE("/players/id")
    Call<Integer> removePlayerById(@Query("id")int id);

    @POST("/players/insert/sportId")
    Call<Player> insertPlayerToSport(@Body Player player, @Query("sportId")int sportId);

    @POST("/players/update")
    Call<Player> updatePlayer(@Body Player player);
}
