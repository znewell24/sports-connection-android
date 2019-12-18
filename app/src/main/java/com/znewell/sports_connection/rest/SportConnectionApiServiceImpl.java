package com.znewell.sports_connection.rest;

import android.util.Log;

import com.znewell.sports_connection.model.Player;
import com.znewell.sports_connection.model.PlayerResponse;
import com.znewell.sports_connection.model.Sport;
import com.znewell.sports_connection.model.SportResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportConnectionApiServiceImpl {

    private static final String TAG = SportConnectionApiServiceImpl.class.getSimpleName();
    private static final String BASE_URL = "https://young-dawn-39663.herokuapp.com";

    private static Retrofit retrofit = null;
    private SportConnectionApiService sportConnectionApiService;

    private List<Sport> sports;
    private List<Player> players;
    private Sport mSport;
    private Player mPlayer;

    public SportConnectionApiServiceImpl() {
        createRetrofit();

        sports = new ArrayList<>();
        players = new ArrayList<>();
        mSport = null;
        mPlayer = null;
    }

    /**
     * Create the Retrofit object with REST API
     */
    private void createRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        sportConnectionApiService = retrofit.create(SportConnectionApiService.class);
    }

    public List<Sport> getAllSports() {

        createRetrofit();
        Call<SportResponse> call =
                sportConnectionApiService.getAllSports();

        call.enqueue(new Callback<SportResponse>() {
            @Override
            public void onResponse(Call<SportResponse> call, Response<SportResponse> response) {
                sports = response.body().getSports();
            }

            @Override
            public void onFailure(Call<SportResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        return sports;
    }

    public Sport getSportById (int id) {

        createRetrofit();
        Call<Sport> call =
                sportConnectionApiService.getSportById(id);

        call.enqueue(new Callback<Sport>() {
            @Override
            public void onResponse(Call<Sport> call, Response<Sport> response) {
                mSport = response.body();
            }

            @Override
            public void onFailure(Call<Sport> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        return mSport;
    }

    public void deleteSportById(int id) {

        createRetrofit();
        Call<Integer> call =
                sportConnectionApiService.deleteSportById(id);

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.i(TAG, "deleted id " + response.body().toString());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    public Sport updateSport(Sport sport) {

        createRetrofit();
        Call<Sport> call =
                sportConnectionApiService.updateSport(sport);

        call.enqueue(new Callback<Sport>() {
            @Override
            public void onResponse(Call<Sport> call, Response<Sport> response) {
                mSport = response.body();
            }

            @Override
            public void onFailure(Call<Sport> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
        return mSport;
    }

    public Sport insertSport(Sport sport) {

        createRetrofit();
        Call<Sport> call =
                sportConnectionApiService.insertSport(sport);

        call.enqueue(new Callback<Sport>() {
            @Override
            public void onResponse(Call<Sport> call, Response<Sport> response) {
                mSport = response.body();
            }

            @Override
            public void onFailure(Call<Sport> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
        return mSport;
    }

    public List<Player> getAllPlayersForSport(Sport sport) {

        createRetrofit();
        Call<PlayerResponse> call =
                sportConnectionApiService.getAllPlayersForSport(sport);

        call.enqueue(new Callback<PlayerResponse>() {
            @Override
            public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                players = response.body().getPlayers();
            }

            @Override
            public void onFailure(Call<PlayerResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        return players;
    }

    public void removePlayerById(int id) {

        createRetrofit();
        Call<Integer> call =
                sportConnectionApiService.removePlayerById(id);

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.i(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    public Player insertPlayerToSport(Player player, int sportId) {

        createRetrofit();
        Call<Player> call =
                sportConnectionApiService.insertPlayerToSport(player, sportId);

        call.enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                mPlayer = response.body();
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                Log.e(TAG, t.toString());

            }
        });

        return mPlayer;
    }

    public Player updatePlayer(Player player) {

        createRetrofit();
        Call<Player> call =
                sportConnectionApiService.updatePlayer(player);

        call.enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                mPlayer = response.body();
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        return mPlayer;
    }
}
