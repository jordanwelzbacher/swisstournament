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

    public boolean isAdmin(Long tournamentId, Long adminId) {
        List<Admin> admins = adminRepository.findByTournamentId(tournamentId);
        for (Admin admin : admins) if (admin.getUserId().equals(adminId)) return true;
        return false;
    }

    public void deleteByAdminId(Long adminId) {
        adminRepository.deleteById(adminId);
    }

}
