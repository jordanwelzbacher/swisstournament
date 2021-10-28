package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.Constants;
import com.jwelzbacher.swisstournament.DTOs.PlayerScore;
import com.jwelzbacher.swisstournament.DTOs.comparators.PlayerScoreComparator;
import com.jwelzbacher.swisstournament.models.Pairing;
import com.jwelzbacher.swisstournament.models.Player;
import com.jwelzbacher.swisstournament.models.Tournament;
import com.jwelzbacher.swisstournament.repositories.PairingRepository;
import com.jwelzbacher.swisstournament.repositories.PlayerRepository;
import com.jwelzbacher.swisstournament.repositories.TournamentRepository;
import com.jwelzbacher.swisstournament.repositories.UserRepository;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlayerService {
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PairingRepository pairingRepository;
    @Autowired
    PlayerRepository playerRepository;

    public List<PlayerScore> getPlayersByTournamentId(Long id) {

        List<Player> players = playerRepository.findByTournamentId(id);

        Tournament tournament = tournamentRepository.findById(id).get();

        List<PlayerScore> playerScores = new ArrayList<>();

        for (Player player : players) {
            PlayerScore playerScore = new PlayerScore();
            playerScore.setId(player.getId());
            playerScore.setUserId(player.getUserId());
            playerScore.setName(tournament.isUseFirstLast() || player.getUserId() == null ? player.getDisplayName() : userRepository.getById(player.getUserId()).getUsername());
            int wins = 0;
            int losses = 0;
            int draws = 0;

            List<Pairing> pairings = pairingRepository.findByPlayerId(player.getId());

            for (Pairing pairing : pairings) {
                if (pairing.getFirstPlayerId().equals(player.getId())) {
                    if (pairing.getMatchResultFirstPlayer().equals("WIN")) wins++;
                    else if (pairing.getMatchResultFirstPlayer().equals("DRAW")) draws++;
                    else losses++;
                } else {
                    if (pairing.getMatchResultSecondPlayer().equals("WIN")) wins++;
                    else if (pairing.getMatchResultSecondPlayer().equals("DRAW")) draws++;
                    else losses++;
                }
            }
            playerScore.setWins(wins);
            playerScore.setLosses(losses);
            playerScore.setDraws(draws);
            playerScore.setMatchPoints(wins * tournament.getWinPoints() + draws * tournament.getDrawPoints() + losses * tournament.getLossPoints());

            playerScore.setFirstTiebreaker(getTiebreakerScore(tournament.getFirstTiebreaker(), player));
            playerScore.setSecondTiebreaker(getTiebreakerScore(tournament.getSecondTiebreaker(), player));
            playerScore.setThirdTiebreaker(getTiebreakerScore(tournament.getThirdTiebreaker(), player));
            playerScore.setFourthTiebreaker(getTiebreakerScore(tournament.getFourthTiebreaker(), player));
            playerScore.setFifthTiebreaker(getTiebreakerScore(tournament.getFifthTiebreaker(), player));

            playerScores.add(playerScore);
        }

        if (playerScores.size() > 1) {
            playerScores.sort(new PlayerScoreComparator());

            int rank = 1;
            int countSame = 0;
            playerScores.get(0).setRank(1);

            for (int i = 0; i < playerScores.size() - 1; i++) {
                if (playerScores.get(i).compareTo(playerScores.get(i + 1)) == 0) {
                    countSame++;
                    playerScores.get(i + 1).setRank(rank);
                } else {
                    rank += countSame + 1;
                    playerScores.get(i + 1).setRank(rank);
                    countSame = 0;
                }
            }
        }
        return playerScores;
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
        List<Pairing> pairings = pairingRepository.findByPlayerId(player.getId());
        double sum = 0.0;
        for (Pairing pairing : pairings) {
            if (pairing.getFirstPlayerId().equals(player.getId())) {
                sum += getMatchWinPercentage(playerRepository.getById(pairing.getSecondPlayerId()));
            }
            else sum += getMatchWinPercentage(playerRepository.getById(pairing.getFirstPlayerId()));
        }
        return DoubleRounder.round(sum / pairings.size(), 6);
    }

    private Double getMatchWinPercentage(Player player) {
        List<Pairing> pairings = pairingRepository.findByPlayerId(player.getId());
        double sum = 0.0;
        for (Pairing pairing : pairings) {
            if (pairing.getFirstPlayerId().equals(player.getId())) {
                if (pairing.getMatchResultFirstPlayer().equals("WIN")) sum += 1;
            }
            else {
                if (pairing.getMatchResultSecondPlayer().equals("WIN")) sum += 1;
            }
        }
        return sum / pairings.size();
    }
}
