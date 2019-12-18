package com.znewell.sports_connection.model;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PlayerResponse {

    private List<Player> players;
}
