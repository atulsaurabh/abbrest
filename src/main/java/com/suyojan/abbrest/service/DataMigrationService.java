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
 * @author Suyojan
 */

@Service
public interface DataMigrationService 
{
    
    public boolean migrate25Record(List<Testrecord> testrecords);
    public List<Testrecord> retrieve25Records(String migratedFrom);
}
