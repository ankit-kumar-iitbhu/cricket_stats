package com.ankit.cricketstats.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BatsmanVsBowler {

    private Long ballFaced;
    private Long runScored;
    private Long wicket;
    private Long matchCount;
    private Long fours;
    private Long sixs;
    private Long dots;
}
