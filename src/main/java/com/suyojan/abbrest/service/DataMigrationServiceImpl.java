/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.service;

import com.suyojan.abbrest.entity.Testrecord;
import com.suyojan.abbrest.repository.TestRecordRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Suyojan
 */

@Service
@Transactional
public class DataMigrationServiceImpl implements DataMigrationService{
    @Autowired
    private TestRecordRepository testRecordRepository;

    @Transactional
    @Override
    public boolean migrate25Record(List<Testrecord> testrecords) {
        try {
            testRecordRepository.saveAll(testrecords);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
}
