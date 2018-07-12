/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.restcontroller;

import com.suyojan.abbrest.entity.Testrecord;
import java.util.List;
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
       @PostMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
       @ResponseBody  
       public boolean update25Batch(@RequestBody List<Testrecord> testrecords)
       {
           System.out.println("Data Arraieved "+testrecords.size());
           if(testrecords.size() <= 25)
               return true;
           else
               return false;
       }
}
