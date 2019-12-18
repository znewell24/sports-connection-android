package com.znewell.sports_connection.model;

import com.google.gson.annotations.SerializedName;

import java.sql.Time;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class Sport {

    @SerializedName("id")
    private final int id;
    @SerializedName("name")
    private final String name;
    @SerializedName("sportName")
    private final String sportName;
    @SerializedName("location")
    private final LocationModel locationModel;
    @SerializedName("time")
    private final Time time;
}
