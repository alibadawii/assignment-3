package com.orange.ass3.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.max;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class League {

    private String LeagueName;
    private Team t1;
    private Team t2;

    //Simulating the match to find the winner
    public String SimulateMatch(Team t1, Team t2) {
        Team winner = new Team();
        boolean draw = false;
        List<Player> t1tempPlayers=new ArrayList<>();
        List<Player> t2tempPlayers=new ArrayList<>();
        Random random = new Random();
        int t1Goals = random.nextInt(10);
        int t2Goals = random.nextInt(10);
        String t1tempPlayersString = "";
        String t2tempPlayersString = "";
        if (t1Goals > t2Goals) {
            winner=t1;
        } else if (t1Goals == t2Goals) {
            draw=true;
        } else {
            winner=t2;
        }
        for (int i = 0; i < t1Goals; i++) {
            int j = random.nextInt(t1.getThePlayers().size());
            Player player1 = t1.getThePlayers().get(j);
            t1tempPlayers.add(player1);
            t1tempPlayersString=PlayersLoop(t1tempPlayers);
        }
        for (int i = 0; i < t2Goals; i++) {
            int k = random.nextInt(t2.getThePlayers().size());
            Player player2 = t2.getThePlayers().get(k);
            t2tempPlayers.add(player2);
            t2tempPlayersString=PlayersLoop(t2tempPlayers);

        }
        String t1GoalsString=Integer.toString(t1Goals);
        String t2GoalsString=Integer.toString(t2Goals);
        if (draw){
            return "THE MATCH ENDED IN A DRAW"+ "\n"
                    +" The match ended " + t1GoalsString +" - "+ t2GoalsString + "\n"
                    +t1.getTeamName()+" goalscorers are" + "\n"
                    +t1tempPlayersString+ "\n"
                    +"and" + "\n"
                    +t2.getTeamName()+" goalscorers are" + "\n"
                    +t2tempPlayersString;
        }else {
            return "THE WINNER IS " + winner + "\n"
                    +" The match ended " + t1GoalsString +" - "+ t2GoalsString + "\n"
                    +t1.getTeamName()+" goalscorers are" + "\n"
                    +t1tempPlayersString+ "\n"
                    +"and" + "\n"
                    +t2.getTeamName()+" goalscorers are" + "\n"
                    +t2tempPlayersString;
        }
    }

    public String PlayersLoop(List<Player> thePlayers){
        String thePlayerString="";
        for (int i=0;i<thePlayers.size();i++){
            thePlayerString=thePlayerString+" "+thePlayers.get(i).getPlayerName();
        }
        return thePlayerString;
    }

    //printing
    public String toString() {
        return "League Name: " + this.getLeagueName() + "\n" +
                "Today the playing teams are: " + t1.getTeamName() + " VS " + t2.getTeamName() + "\n"
                + this.SimulateMatch(t1, t2);
    }
}