package com.znewell.sports_connection.model;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SportResponse {

    private List<Sport> sports;
}
