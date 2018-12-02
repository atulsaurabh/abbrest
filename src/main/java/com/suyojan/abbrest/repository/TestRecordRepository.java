/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.repository;

import com.suyojan.abbrest.entity.Testrecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Atul Saurabh
 * @version 1.0
 * @see org.springframework.data.jpa.repository.JpaRepository
 */

@Repository
public interface TestRecordRepository extends JpaRepository<Testrecord, Long>
{
    /**
     * 
     * @param migratedFrom identification of the client.
     * @return A list of com.suyojan.abbrest.entity.Testrecord  
     */
    /*
       Returing list of recent 25 com.suyojan.abbrest.entity.Testrecord which 
       are sent last client
    */
    List<Testrecord> findTop25ByMigratedFromOrderByIdDesc(String migratedFrom);
}
