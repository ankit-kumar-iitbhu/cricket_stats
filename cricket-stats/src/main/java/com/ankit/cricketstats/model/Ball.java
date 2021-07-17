package com.ankit.cricketstats.model;

import java.time.LocalDate;

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
    private LocalDate startDate;
    private String venue;

    @Id
    private int innings;
    @Id
    private int over;
    @Id
    private int ball;
    private String phase; // values - PowerPlay,Middle Over,Death Over, Super Over

    private String battingTeam;
    private String bowlingTeam;

    private String striker;
    private String nonStriker;
    private String bowler;

    private int runsOffBat; // runs attributed to batsman
    private Integer four; // 1 if true
    private Integer six; // 1 if true
    private Integer dot; // 1 if true
    private int extras; //total extras
    private int bowlerExtras; //extras attributed to bowler
    private int ballValidForBatsman;
    private int ballValidForBowler;


    private Integer bowlerWicket; // 1 if true
    private String wicketType;
    private String playerDismissed;
    private String otherWicketType;
    private String otherPlayerDismissed;

    //Integer is used where null value is accepted.

}
