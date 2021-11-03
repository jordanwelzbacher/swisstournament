package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.models.Pairing;
import com.jwelzbacher.swisstournament.repositories.PairingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PairingService {

    @Autowired
    PairingRepository pairingRepository;

    public List<Pairing> getPairingsByRoundId(Long roundId) {
        return pairingRepository.findByRoundId(roundId);
    }
}
