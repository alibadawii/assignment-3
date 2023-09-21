package com.orange.ass3.demo.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class Striker implements Player{

    private String PlayerName;
    private int PlayerNumber;

    @Override
    public String getPos() {
        return "ST";
    }

    @Override
    public String getPlayerName() {
        return PlayerName;
    }

    @Override
    public int getPlayerNumber() {
        return PlayerNumber;
    }

    @Override
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    @Override
    public void setPlayerNumber(int playerNumber) {
        PlayerNumber = playerNumber;
    }
}
