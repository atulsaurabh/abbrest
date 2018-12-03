/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.service;

import com.suyojan.abbrest.entity.Testrecord;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Atul Saurabh
 * @version 1.0
 */

@Service
public interface DataMigrationService 
{
    /**
     * 
     * @param testrecords list of records need to be stored in database.
     * @return if storage is successful then returns true otherwise returns false.
     */
    public boolean migrate25Record(List<Testrecord> testrecords);
}
