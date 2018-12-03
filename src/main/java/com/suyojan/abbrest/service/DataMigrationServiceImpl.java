/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.service;

import com.suyojan.abbrest.entity.Testrecord;
import com.suyojan.abbrest.repository.TestRecordRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Atul Saurabh
 * @version 1.0
 */

@Service
@Transactional
public class DataMigrationServiceImpl implements DataMigrationService{
    @Autowired
    private TestRecordRepository testRecordRepository;
    
    /**
     * 
     * @param testrecords list of records need to be stored in database.
     * @return if storage is successful then returns true otherwise returns false.
     */
    @Transactional
    @Override
    public boolean migrate25Record(List<Testrecord> testrecords) {
        try {
              if (isAvailable(testrecords))
                  return true;
              else
              {
                  testRecordRepository.saveAll(testrecords);
                  return true;
              }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isAvailable(List<Testrecord> testrecords)
    {
        String migratedFrom = testrecords.get(0).getMigratedFrom();
     List<Testrecord>  records=   testRecordRepository.findTop25ByMigratedFromOrderByIdDesc(migratedFrom).stream().filter(testrecord -> {
            return testrecords.stream().anyMatch(testrecord1 -> {
                return testrecord1.getOldId() == testrecord.getOldId() && testrecord.getMigratedFrom().equals(testrecord1.getMigratedFrom());
            });
        }).collect(Collectors.toList());

     return !records.isEmpty();
    }

    
    
    
    
    
    
    
}
