package com.znewell.sports_connection.model;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class LocationModel {

    @SerializedName("lat")
    private final float lat;
    @SerializedName("lon")
    private final float lon;
}
