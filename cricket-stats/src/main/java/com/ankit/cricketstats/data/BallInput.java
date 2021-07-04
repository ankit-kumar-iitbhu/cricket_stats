package com.ankit.cricketstats.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter 
public class BallInput {

    private String match_id;
    private String season;
    private String startDate;
    private String venue;
    private String innings;
    private String ball;
    private String battingTeam;
    private String bowlingTeam;
    private String striker;
    private String nonStriker;
    private String bowler;
    private String runsOffBat;
    private String extras;
    private String wides;
    private String noballs;
    private String byes;
    private String legbyes;
    private String penalty;
    private String wicketType;
    private String playerDismissed;
    private String otherWicketType;
    private String otherPlayerDismisse;
    
}
