package com.jwelzbacher.swisstournament.DTOs.comparators;

import com.jwelzbacher.swisstournament.DTOs.PlayerScore;

import java.util.Comparator;

public class PlayerScoreComparator implements Comparator<PlayerScore> {
    @Override
    public int compare(PlayerScore o1, PlayerScore o2) {
        // * -1 is needed to reverse the order
        return o1.compareTo(o2) * -1;
    }
}
