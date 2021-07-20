package com.ankit.cricketstats.controller;

import java.util.List;

import com.ankit.cricketstats.model.Ball;
import com.ankit.cricketstats.repository.BallRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RivalryController {

    @Autowired
    private BallRepository ballRepository;

    @RequestMapping(value = "/findByStrikerAndBowler", method = RequestMethod.GET)
    List<Ball> getBallByStriker(@RequestParam String striker,@RequestParam String bowler){
        return ballRepository.findByStrikerAndBowler(striker,bowler);
    }
    
}
