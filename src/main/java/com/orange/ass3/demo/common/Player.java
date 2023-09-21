package com.orange.ass3.demo.common;

import org.springframework.stereotype.Component;

public interface Player {
     public String getPos();

     String getPlayerName();

     int getPlayerNumber();

     void setPlayerName(String PlayerName);

     void setPlayerNumber(int PlayerNumber);

}
