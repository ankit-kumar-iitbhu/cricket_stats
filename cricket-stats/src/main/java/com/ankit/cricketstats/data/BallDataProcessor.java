package com.ankit.cricketstats.data;

import java.time.LocalDate;

import com.ankit.cricketstats.model.Ball;

import org.springframework.batch.item.ItemProcessor;

public class BallDataProcessor implements ItemProcessor<BallInput, Ball> {

  int parseIntFromStr(String num){
    return "".equals(num)? 0 : Integer.parseInt(num);
  }


  @Override
  public Ball process(final BallInput ballData) throws Exception {
    Ball ball= new Ball();
    ball.setMatchId(Long.parseLong(ballData.getMatchId()));
    ball.setSeason(Integer.parseInt(ballData.getSeason()));
    ball.setStartDate(LocalDate.parse(ballData.getStartDate()));
    ball.setVenue(ballData.getVenue());
    ball.setInnings(Integer.parseInt(ballData.getInnings()));

    //spliting ball field in csv into ball and over
    String[] splitBall = ballData.getBall().split("\\.");
    ball.setOver(Integer.parseInt(splitBall[0]));
    ball.setBall(Integer.parseInt(splitBall[1]));

    ball.setBattingTeam(ballData.getBattingTeam());
    ball.setBowlingTeam(ballData.getBowlingTeam());
    ball.setStriker(ballData.getStriker());
    ball.setNonStriker(ballData.getNonStriker());
    ball.setBowler(ballData.getBowler());

    ball.setRunsOffBat(parseIntFromStr(ballData.getRunsOffBat()));
    ball.setExtras(parseIntFromStr(ballData.getExtras()));
    ball.setWides(parseIntFromStr(ballData.getWides()));
    ball.setNoballs(parseIntFromStr(ballData.getNoballs()));
    ball.setByes(parseIntFromStr(ballData.getByes()));
    ball.setLegbyes(parseIntFromStr(ballData.getLegbyes()));
    ball.setPenalty(parseIntFromStr(ballData.getPenalty()));
    
    ball.setWicketType(ballData.getWicketType());
    ball.setPlayerDismissed(ballData.getPlayerDismissed());
    ball.setOtherWicketType(ballData.getOtherWicketType());
    ball.setOtherPlayerDismissed(ballData.getOtherPlayerDismissed());
   
    return ball;
  }

}