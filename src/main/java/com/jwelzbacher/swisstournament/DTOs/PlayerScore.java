package com.jwelzbacher.swisstournament.DTOs;

import com.jwelzbacher.swisstournament.Constants;
import com.jwelzbacher.swisstournament.models.Pairing;
import com.jwelzbacher.swisstournament.models.Player;
import com.jwelzbacher.swisstournament.models.Tournament;
import com.jwelzbacher.swisstournament.repositories.PairingRepository;
import com.jwelzbacher.swisstournament.repositories.PlayerRepository;
import com.jwelzbacher.swisstournament.repositories.TournamentRepository;
import com.jwelzbacher.swisstournament.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerScore {
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PairingRepository pairingRepository;
    @Autowired
    PlayerRepository playerRepository;

    private Long id;

    private String name;

    private int wins;

    private int losses;

    private int draws;

    private Double matchPoints;

    private Map<Integer, Double> tiebreakers;

    PlayerScore(Player player) {


        Tournament tournament = tournamentRepository.findById(player.getTournamentId()).get();
        this.id = player.getId();
        this.name = tournament.isUseFirstLast() ? player.getDisplayName() : userRepository.getById(player.getUserId()).getUsername();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        List<Pairing> pairingsAsFirst = pairingRepository.findByFirstPlayerId(player.getId());
        List<Pairing> pairingsAsSecond = pairingRepository.findBySecondPlayerId(player.getId());

        for (Pairing pairing : pairingsAsFirst) {
            if (pairing.getFirstPlayerId().equals(player.getId())) { //Are they player A or B?
                if (pairing.getMatchResultFirstPlayer().equals("WIN")) wins++;
                else if (pairing.getMatchResultFirstPlayer().equals("DRAW")) draws++;
                else losses++;
            } else {
                if (pairing.getMatchResultSecondPlayer().equals("WIN")) wins++;
                else if (pairing.getMatchResultSecondPlayer().equals("DRAW")) draws++;
                else losses++;
            }
        }
        for (Pairing pairing : pairingsAsSecond) {
            if (pairing.getFirstPlayerId().equals(player.getId())) { //Are they player A or B?
                if (pairing.getMatchResultFirstPlayer().equals("WIN")) wins++;
                else if (pairing.getMatchResultFirstPlayer().equals("DRAW")) draws++;
                else losses++;
            } else {
                if (pairing.getMatchResultSecondPlayer().equals("WIN")) wins++;
                else if (pairing.getMatchResultSecondPlayer().equals("DRAW")) draws++;
                else losses++;
            }
        }
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.matchPoints = wins * tournament.getWinPoints() + draws * tournament.getDrawPoints() + losses * tournament.getLossPoints();

        Map<Integer, Double> tiebreakers = new HashMap<>();
        tiebreakers.put(1, getTiebreakerScore(tournament.getFirstTiebreaker(), player));
        tiebreakers.put(2, getTiebreakerScore(tournament.getSecondTiebreaker(), player));
        tiebreakers.put(3, getTiebreakerScore(tournament.getThirdTiebreaker(), player));
        tiebreakers.put(4, getTiebreakerScore(tournament.getFourthTiebreaker(), player));
        tiebreakers.put(5, getTiebreakerScore(tournament.getFifthTiebreaker(), player));
        this.tiebreakers = tiebreakers;
    }

    private Double getTiebreakerScore(int tiebreaker, Player player) {
        switch (tiebreaker) {
            case Constants.NONE:
                return 0.0;
            case Constants.OMWP:
                return getOpponentMatchWinPercentage(player);
//            case Constants.MEDIAN_BUCHHOLZ:
//                return getMedianBuchholz(player);
//                break;
//            case Constants.GWP:
//                return getGWP(player);
//                break;
//            case Constants.OGWP:
//                return getOGWP(player);
//                break;
//            case Constants.CUSTOM_A:
//                return getCustomA(player);
//                break;
//            case Constants.CUSTOM_B:
//                return getCustomB(player);
//                break;
            default:
                return 0.0;
        }
    }

    private Double getOpponentMatchWinPercentage(Player player) {
        List<Pairing> pairingsAsFirst = pairingRepository.findByFirstPlayerId(player.getId());
        List<Pairing> pairingsAsSecond = pairingRepository.findBySecondPlayerId(player.getId());
        double sum = 0.0;
        for (Pairing pairing : pairingsAsFirst) {
            sum += getMatchWinPercentage(playerRepository.getById(pairing.getSecondPlayerId()));
        }
        for (Pairing pairing : pairingsAsSecond) {
            sum += getMatchWinPercentage(playerRepository.getById(pairing.getFirstPlayerId()));
        }
        return sum / (pairingsAsFirst.size() + pairingsAsSecond.size());
    }

    private Double getMatchWinPercentage(Player player) {
        List<Pairing> pairingsAsFirst = pairingRepository.findByFirstPlayerId(player.getId());
        List<Pairing> pairingsAsSecond = pairingRepository.findBySecondPlayerId(player.getId());
        double sum = 0.0;
        for (Pairing pairing : pairingsAsFirst) {
            if (pairing.getMatchResultFirstPlayer().equals("WIN")) sum+=1;
        }
        for (Pairing pairing : pairingsAsSecond) {
            if (pairing.getMatchResultSecondPlayer().equals("WIN")) sum+=1;
        }
        return sum / (pairingsAsFirst.size() + pairingsAsSecond.size());
    }
}
