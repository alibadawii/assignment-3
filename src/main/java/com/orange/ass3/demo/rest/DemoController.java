package com.orange.ass3.demo.rest;

import com.orange.ass3.demo.common.League;
import com.orange.ass3.demo.common.Player;
import com.orange.ass3.demo.common.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private League theLeague;

    @Autowired
    public DemoController(
            @Value("${league.name}") String LeagueName,

            @Value("${t1.name}") String T1Name,
            @Value("${t2.name}") String T2Name,

            @Qualifier("striker") Player T1Striker,
            @Qualifier("defender") Player T1Defender,
            @Qualifier("goalkeeper") Player T1Keeper,
            @Value("${p1.name}") String P1Name,
            @Value("${p2.name}") String P2Name,
            @Value("${p3.name}") String P3Name,
            @Value("${p1.number}") int P1Number,
            @Value("${p2.number}") int P2Number,
            @Value("${p3.number}") int P3Number,

            @Qualifier("striker") Player T2Striker,
            @Qualifier("defender") Player T2Defender,
            @Qualifier("goalkeeper") Player T2Keeper,
            @Value("${p4.name}") String P4Name,
            @Value("${p5.name}") String P5Name,
            @Value("${p6.name}") String P6Name,
            @Value("${p4.number}") int P4Number,
            @Value("${p5.number}") int P5Number,
            @Value("${p6.number}") int P6Number) {

        theLeague = new League();
        theLeague.setLeagueName(LeagueName);

        T1Striker.setPlayerName(P1Name);
        T1Striker.setPlayerNumber(P1Number);
        T1Defender.setPlayerName(P2Name);
        T1Defender.setPlayerNumber(P2Number);
        T1Keeper.setPlayerName(P3Name);
        T1Keeper.setPlayerNumber(P3Number);

        T2Striker.setPlayerName(P4Name);
        T2Striker.setPlayerNumber(P4Number);
        T2Defender.setPlayerName(P5Name);
        T2Defender.setPlayerNumber(P5Number);
        T2Keeper.setPlayerName(P6Name);
        T2Keeper.setPlayerNumber(P6Number);

        Team t1 = new Team(T1Name, T1Striker, T1Defender, T1Keeper);
        Team t2 = new Team(T2Name, T2Striker, T2Defender, T2Keeper);
        theLeague.setT1(t1);
        theLeague.setT2(t2);
    }

    @GetMapping("/leagueinfo")
    public String getLeagueinfo(){
        return theLeague.toString();
    }

    @GetMapping("/badawii")
    public String DebugTest(){
        return "teESTTT";
    }

}
