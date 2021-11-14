package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.exceptions.BadRequestException;
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

    public Pairing getById(Long pairingId) {
        try {
            return pairingRepository.findById(pairingId).get();
        }
        catch (Exception e) {
            throw new BadRequestException("Invalid pairing Id");
        }
    }
}
