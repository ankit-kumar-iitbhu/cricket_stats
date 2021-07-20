package com.ankit.cricketstats.repository;

import java.util.List;

import com.ankit.cricketstats.model.Ball;
import com.ankit.cricketstats.model.BallId;
import com.ankit.cricketstats.response.BatsmanVsBowler;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BallRepository extends CrudRepository<Ball,BallId> {

    List<Ball> findByStrikerAndBowler(String batsman,String bowler);

    //select sum(a12),count(*) where a9 == 'V Kohli' && a11 == 'JJ Bumrah' && (a5 ==1 || a5==2) && (a14==0)

    @Query(" SELECT new com.ankit.cricketstats.response.BatsmanVsBowler( SUM(b.ballValidForBatsman),SUM(b.runsOffBat), SUM(b.bowlerWicket), COUNT( DISTINCT(b.matchId)) , SUM(b.four), Sum(b.six), Sum(b.dot) ) "
    +"FROM Ball AS b "
    +"WHERE b.striker= ?1 AND b.bowler= ?2 AND b.innings in (1,2) ")
    List<BatsmanVsBowler> getHeadToHead(String batsman,String bowler);
}

