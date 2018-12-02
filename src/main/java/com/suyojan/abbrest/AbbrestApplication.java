package com.suyojan.abbrest;

import com.suyojan.abbrest.configuration.Configuration;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 
 * @author Atul Saurabh
 * @version 1.0
 *
 */
@SpringBootApplication
public class AbbrestApplication
{

    /**
     * 
     * @param args Not required at all. All the default behavior.
     * 
     */
	public static void main(String[] args) throws Exception {
                /*
                    Spring bootstraping is done using run method.
                    It enables all the default behavior of the project.
                    Majorly It starts embedde tomcat server and 
                    establishes connection to the configured database.
                 */

        String insdir = args[0];
        if (insdir == null)
        	throw new Exception("Kindly run with --insdir option");
        else
		{
			String dir=insdir.split("=")[1];
			Configuration.INS_DIR=dir;
		}
		SpringApplication.run(AbbrestApplication.class, args);
	}


}
