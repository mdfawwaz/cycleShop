package com.talentsprint.cycleshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.talentsprint.cycleshop.business.NeedsAuth;
import com.talentsprint.cycleshop.entity.Cycle;
import com.talentsprint.cycleshop.repository.CycleRepository;
import com.talentsprint.cycleshop.service.CycleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cycle")
public class CycleController {

    @Autowired
    private CycleService cycleService;
    
    @Autowired
    private CycleRepository cycleRepository;

    //@NeedsAuth(loginPage = "/loginpage")
    @PutMapping("/{id}/borrow")
    public String borrowCycle(@PathVariable long id, @RequestParam(required = false, defaultValue = "1") int count) {
        cycleService.borrowCycle(id, count);
        return "Cycles borrowed successfully";
    }

   // @NeedsAuth(loginPage = "/loginpage")
    @PutMapping("/{id}/return")
    public String returnCycle(@PathVariable long id, @RequestParam(required = false, defaultValue = "1") int count) {
        cycleService.returnCycle(id, count);
        return "Cycles returned successfully"; 
    }

    @PutMapping("/{id}/restock")
    public String restockCycle(@PathVariable long id, @RequestParam(required = false, defaultValue = "1") int count) {
        cycleService.restockBy(id, count);
        return "Cycles restocked successfully"; 
    }

    @PutMapping("")
    public List<Cycle> listAvailableCycles() {
        // Implement logic to list available cycles
        return cycleService.listAvailableCycles();
    }

    @PutMapping("/{id}")
    public Cycle cycleDetail(@PathVariable long id) {
        return cycleService.findByIdOrThrow404(id);
    }
    
    @PutMapping("/addcycle")
    @ResponseBody
    public Cycle addCycle(@Valid @RequestBody Cycle cycle) {
    		return cycleRepository.save(cycle);
    }
}
