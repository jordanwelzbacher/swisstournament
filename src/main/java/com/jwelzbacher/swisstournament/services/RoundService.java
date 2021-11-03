package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.models.Round;
import com.jwelzbacher.swisstournament.repositories.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoundService {

    @Autowired
    RoundRepository roundRepository;

    public List<Round> getRoundsByTournamentId(Long tournamentId) {
        return roundRepository.findByTournamentIdOrderByRoundNumber(tournamentId);
    }

}
