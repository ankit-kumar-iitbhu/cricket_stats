package com.ankit.cricketstats.repository;

import java.util.List;

import com.ankit.cricketstats.model.Ball;
import com.ankit.cricketstats.model.BallId;

import org.springframework.data.repository.CrudRepository;

public interface BallRepository extends CrudRepository<Ball,BallId> {

    
    List<Ball> findByStrikerAndBowler(String batsman,String bowler);
}
