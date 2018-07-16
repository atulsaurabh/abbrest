/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.restcontroller;

import com.suyojan.abbrest.entity.Testrecord;
import com.suyojan.abbrest.service.DataMigrationService;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Suyojan
 */

@RestController
@RequestMapping("/abbrest")
public class Batch25UpdateController 
{
    @Autowired
    private DataMigrationService dataMigrationService;
    
       @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
       @ResponseBody  
       public boolean update25Batch(@RequestBody List<Testrecord> testrecords)
       {
           LocalDateTime localDateTime = LocalDateTime.now();
           System.out.println("Data Arived with size "+testrecords.size()+" AT "+localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
           testrecords.forEach(testrecord -> {
               testrecord.setOldId(testrecord.getId());
               testrecord.setId(null);
               testrecord.getTestresultCollection().forEach(testresult -> {
                       testresult.setOldid(testresult.getId());
                       testresult.setId(null);
               });
           });
           if(dataMigrationService.migrate25Record(testrecords))
               return true;
           else
               return false;
       }
}
