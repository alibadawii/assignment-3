package com.orange.ass3.demo.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class Defender implements Player{

    private String PlayerName;
    private int PlayerNumber;

    @Override
    public String getPos() {
        return "CB";
    }

    @Override
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    @Override
    public void setPlayerNumber(int playerNumber) {
        PlayerNumber = playerNumber;
    }

    @Override
    public String getPlayerName() {
        return PlayerName;
    }

    @Override
    public int getPlayerNumber() {
        return PlayerNumber;
    }

}