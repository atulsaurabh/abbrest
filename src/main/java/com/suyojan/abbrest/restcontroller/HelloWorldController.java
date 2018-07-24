/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Suyojan
 */

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @GetMapping
    public String hello()
    {
        return "Hello World";
    }
}
