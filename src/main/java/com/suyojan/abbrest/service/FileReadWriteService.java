package com.suyojan.abbrest.service;


import com.suyojan.abbrest.configuration.Configuration;
import com.suyojan.abbrest.configuration.DbParam;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Scanner;

@Service
public class FileReadWriteService
{

    public DbParam getDatabaseParam(String insdir)
    {
        File file=new File(insdir+"/sysconfig.properties");
        try {
            Properties properties=new Properties();
            properties.load(new FileInputStream(file));
            DbParam param = new DbParam();
            param.setDbIp(properties.getProperty("dbip"));
            param.setDbName(properties.getProperty("dbname"));
            param.setDbPassword(properties.getProperty("dbpassword"));
            param.setDbPort(properties.getProperty("dbport"));
            param.setDbUser(properties.getProperty("dbuser"));
            return param;
        }
        catch (IOException fnfe)
        {
            fnfe.printStackTrace();
        }
        return null;

    }
}
