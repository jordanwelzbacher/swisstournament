package com.jwelzbacher.swisstournament.repositories;

import com.jwelzbacher.swisstournament.models.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PairingRepository extends JpaRepository<Pairing, Long> {
    List<Pairing> findByRoundId(Long roundId);
}
