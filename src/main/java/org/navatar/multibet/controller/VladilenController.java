package org.navatar.multibet.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.navatar.multibet.domain.Views;
import org.navatar.multibet.domain.Vladilen;
import org.navatar.multibet.repository.VladilenRepo;
import org.navatar.multibet.service.VladilenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VladilenController {

    private final VladilenRepo vladilenRepo;
    private final VladilenService vladilenService;

    @Autowired
    public VladilenController(VladilenRepo vladilenRepo, VladilenService vladilenService) {
        this.vladilenRepo = vladilenRepo;
        this.vladilenService = vladilenService;
    }

    @GetMapping("/tasks")
    @JsonView(Views.IdName.class)
    public List<Vladilen> list() {
        return vladilenRepo.findAll();
    }

    @GetMapping("/task/{id}")
    @JsonView(Views.FullVladilen.class)
    public Vladilen getOne(@PathVariable("id") Vladilen vladilen) {
        return vladilen;
    }

    @PostMapping("/task")
    public Vladilen create(@RequestBody Vladilen vladilen) {
        return vladilenRepo.save(vladilen);
    }

    @PutMapping("/task/{id}")
    public Vladilen update(
            @PathVariable("id") Vladilen vladilenFromDb,
            @RequestBody Vladilen vladilen
    ) {
        BeanUtils.copyProperties(vladilen, vladilenFromDb, "id");

        return vladilenRepo.save(vladilenFromDb);
    }

    @PatchMapping("/task/{id}")
    public Vladilen patchupdate(
            @PathVariable("id") Vladilen vladilenFromDb,
            @RequestBody Vladilen vladilen
    ) {
//        vladilenFromDb.setLastname(vladilen.getLastname());
//        return vladilenRepo.save(vladilenFromDb);

        return vladilenService.patchupdate(vladilenFromDb,vladilen);
    }

    @DeleteMapping("/task/{id}")
    public void delete(@PathVariable("id") Vladilen vladilen) {
        vladilenRepo.delete(vladilen);
    }
}
