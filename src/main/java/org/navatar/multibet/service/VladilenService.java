package org.navatar.multibet.service;

import org.navatar.multibet.domain.Vladilen;
import org.navatar.multibet.repository.VladilenRepo;
import org.springframework.stereotype.Service;

@Service
public class VladilenService {

    private final VladilenRepo vladilenRepo;

    public VladilenService(VladilenRepo vladilenRepo) {
        this.vladilenRepo = vladilenRepo;
    }

    public Vladilen patchupdate(Vladilen vladilenFromDb, Vladilen vladilen) {
        vladilenFromDb.setLastname(vladilen.getLastname());
        return vladilenRepo.save(vladilenFromDb);
    }

}
