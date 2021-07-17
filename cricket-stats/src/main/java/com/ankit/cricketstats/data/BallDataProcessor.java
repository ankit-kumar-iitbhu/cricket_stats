package com.ankit.cricketstats.data;

import java.time.LocalDate;

import com.ankit.cricketstats.model.Ball;

import org.springframework.batch.item.ItemProcessor;

public class BallDataProcessor implements ItemProcessor<BallInput, Ball> {

  int parseIntFromStr(String num){
    return "".equals(num)? 0 : Integer.parseInt(num);
  }

  String getPhase(int innings,int over){
    if(innings!=1 && innings!=2)  return "Super Over";
    if(over<6)  return "PowerPlay";
    if(over<16) return "Middle Over";
    return "Death Over";
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

    ball.setPhase(getPhase(ball.getInnings(),ball.getOver()));

    ball.setBattingTeam(ballData.getBattingTeam());
    ball.setBowlingTeam(ballData.getBowlingTeam());

    ball.setStriker(ballData.getStriker());
    ball.setNonStriker(ballData.getNonStriker());
    ball.setBowler(ballData.getBowler());

    ball.setRunsOffBat(parseIntFromStr(ballData.getRunsOffBat()));
    ball.setExtras(parseIntFromStr(ballData.getExtras()));
    
    int bowlerExtras= parseIntFromStr(ballData.getWides())+parseIntFromStr(ballData.getNoballs());
    ball.setBowlerExtras(bowlerExtras);

    if(ball.getExtras()+ball.getRunsOffBat() == 0 ){
      ball.setDot(1);
    }

    if(ball.getRunsOffBat()==4){
      ball.setFour(1);
    }

    if(ball.getRunsOffBat()==6){
      ball.setSix(1);
    }

    int ballValidForBatsman = (parseIntFromStr(ballData.getWides())!=0) ? 0 : 1;
    int ballValidForBowler = (bowlerExtras == 0) ? 1 : 0;
    ball.setBallValidForBatsman(ballValidForBatsman);
    ball.setBallValidForBowler(ballValidForBowler);


    if(ballData.getWicketType()!=""){
      String wicketType=ballData.getWicketType();
      ball.setWicketType(wicketType);
      ball.setPlayerDismissed(ballData.getPlayerDismissed());
      if("caught".equals(wicketType) || "bowled".equals(wicketType) || "lbw".equals(wicketType) || "caught and bowled".equals(wicketType) || "hit wicket".equals(wicketType) || "stumped".equals(wicketType) ) {
        ball.setBowlerWicket(1);
      }
    }

    if(ballData.getOtherWicketType()!=""){
      ball.setOtherWicketType(ballData.getOtherWicketType());
      ball.setOtherPlayerDismissed(ballData.getOtherPlayerDismissed());
    }

    return ball;
  }

}