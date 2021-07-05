package com.ankit.cricketstats.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter 
@Entity
@IdClass(BallId.class)
public class Ball {
    @Id
    private long matchId;
    private int season;
    private String venue;
    @Id
    private int innings;
    @Id
    private int over;
    @Id
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
