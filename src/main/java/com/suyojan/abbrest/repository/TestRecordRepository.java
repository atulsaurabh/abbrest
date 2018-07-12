/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.repository;

import com.suyojan.abbrest.entity.Testrecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Suyojan
 */

@Repository
public interface TestRecordRepository extends JpaRepository<Testrecord, Long>
{
    
}
