package com.ankit.cricketstats.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BallId implements Serializable {

    private long matchId;
    private int innings;
    private int over;
    private int ball;

}
