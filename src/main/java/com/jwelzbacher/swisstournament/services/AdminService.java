package com.jwelzbacher.swisstournament.services;

import com.jwelzbacher.swisstournament.DTOs.AdminWithUsername;
import com.jwelzbacher.swisstournament.exceptions.BadRequestException;
import com.jwelzbacher.swisstournament.models.Admin;
import com.jwelzbacher.swisstournament.repositories.AdminRepository;
import com.jwelzbacher.swisstournament.repositories.AdminWithUsernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminWithUsernameRepository adminWithUsernameRepository;
    @Autowired
    TournamentService tournamentService;
    @Autowired
    UserService userService;

    public List<AdminWithUsername> getAdminsByTournamentId(Long tournamentId) {
        return adminWithUsernameRepository.findByTournamentId(tournamentId);
    }

    public Admin getByAdminId(Long adminId) {
        return adminRepository.getById(adminId);
    }

    public boolean isAdmin(Long tournamentId, Long adminId) {
        List<Admin> admins = adminRepository.findByTournamentId(tournamentId);
        for (Admin admin : admins) if (admin.getUserId().equals(adminId)) return true;
        return false;
    }

    public void deleteByAdminId(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    public AdminWithUsername addAdmin(Long tournamentId, Long userId) {
        if (tournamentService.isOwner(tournamentId, userId)) throw new BadRequestException("Owner cannot be admin");
        if (isAdmin(tournamentId, userId)) throw new BadRequestException("This user is already an admin");
        if (! userService.isUser(userId)) throw new BadRequestException("This user does not exist");
        Admin admin = new Admin();
        admin.setUserId(userId);
        admin.setTournamentId(tournamentId);
        return adminWithUsernameRepository.findByAdminId(adminRepository.save(admin).getId());
    }
}
