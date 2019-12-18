package com.znewell.sports_connection.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerResponse {

    private List<Player> players;
}
