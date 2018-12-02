/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.restcontroller;

import com.suyojan.abbrest.entity.Testrecord;
import com.suyojan.abbrest.service.DataMigrationService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Atul Saurabh
 * @version 1.0
 *
 */

@RestController
//@RequestMapping("/abbrest")
public class Batch25UpdateController 
{
    @Autowired
    private DataMigrationService dataMigrationService;
      /**
       * 
       * @param testrecords list of records sent by the client. 
       *                    The client sends records in form of JSON.
       * @return true or false to the client according to operation is successful 
       *         or fail respectively
       */  
       @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
       @ResponseBody  
       public boolean update25Batch(@RequestBody List<Testrecord> testrecords)
       {
           LocalDateTime localDateTime = LocalDateTime.now();
           System.out.println("Data Arived with size "+testrecords.size()+" AT "+localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
           /*
             The ids of all records is set to null as a fresh 
             main server id needs to generated.
             The ids sent by the client is stored in old id
             so that it can be refered if required.
           */
           testrecords.forEach(testrecord -> {
               testrecord.setOldId(testrecord.getId());
               testrecord.setId(null);
               testrecord.getTestresultCollection().forEach(testresult -> {
                       testresult.setOldid(testresult.getId());
                       testresult.setId(null);
               });
           });
           
           /*
             testrecords are given to the service to store inside the main server
             datanase.
           */
           if(dataMigrationService.migrate25Record(testrecords))
           /*
              if updation is successful return true to the client.    
            */
               return true;
           else
               /*
                  If the updation is not successful the return false to the 
                  client.
               */
               return false;
       }
       
       /**
        * 
        * @param migratedFrom identification of the client
        * @return recently sent records from the client
        */
       @PostMapping(value = "/{migratedFrom}",produces = MediaType.APPLICATION_JSON_VALUE)
       @ResponseBody
       public List<Testrecord> getLast25TestRecords(@PathVariable String migratedFrom)
       {
           /*
               Returns a bunch of 25 most recent records sent by the client identified by migratedFrom.
           */
           return dataMigrationService.retrieve25Records(migratedFrom);
       }
       
   
}
