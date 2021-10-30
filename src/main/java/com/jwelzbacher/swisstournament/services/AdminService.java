package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.models.Admin;
import com.jwelzbacher.swisstournament.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAdminsByTournamentId(Long tournamentId) {
        return adminRepository.findByTournamentId(tournamentId);
    }

}
