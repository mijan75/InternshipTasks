package com.ssliwireless.www.Server.API.controller;

import com.ssliwireless.www.Server.API.models.FeesCollection;
import com.ssliwireless.www.Server.API.models.Student;
import com.ssliwireless.www.Server.API.service.FeeCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class FeeCollectionController {

    @Autowired
    FeeCollectionService feeCollectionService;

    @GetMapping("/{id}")
    public FeesCollection getInformation(@PathVariable String id) {
        System.out.println("Hello");
        return feeCollectionService.getInfo(id);
    }

    @PutMapping
    public void update(@RequestBody FeesCollection feesCollection) {
        feeCollectionService.save(feesCollection);
    }

    @PostMapping("/student")
    public void update1(@RequestParam String id, @RequestParam String feesAmount, @RequestParam String feeStatus, @RequestParam String paidAmount, @RequestParam String dueAmount) {
        System.out.println("I ama here");
        FeesCollection feesCollection = new FeesCollection(id, feesAmount, feeStatus, Double.parseDouble(paidAmount), Double.parseDouble(dueAmount));
        feeCollectionService.save(feesCollection);
    }
}