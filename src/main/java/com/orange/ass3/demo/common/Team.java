package com.orange.ass3.demo.common;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    private String TeamName;
    private Player striker;
    private Player defender;
    private Player keeper;
    private List<Player> thePlayers = new ArrayList<>();

    public Team(String teamName, Player striker, Player defender, Player keeper) {
        TeamName = teamName;
        this.striker = striker;
        this.defender = defender;
        this.keeper = keeper;
        addPlayers();
    }

    public void addPlayers() {
        thePlayers.add(striker);
        thePlayers.add(defender);
        thePlayers.add(keeper);
    }

    @Override
    public String toString() {
        return TeamName;
    }
}
