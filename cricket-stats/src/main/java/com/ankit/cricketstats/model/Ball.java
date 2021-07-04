package com.ankit.cricketstats.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter 
public class Ball {
    
    private long matchId;
    private int season;
    private String venue;
    private int innings;
    private int over;
    private int ball;
    private String battingTeam;
    private String bowlingTeam;
    private String striker;
    private String non_striker;
    private String bowler;
    private int runs_off_bat;
    private int extras;
    private int wides;
    private int noballs;
    private int byes;
    private int legbyes;
    private int penalty;
    private String wicketType;
    private String playerDismissed;
    private String otherWicketType;
    private String otherPlayerDismissed;

}
