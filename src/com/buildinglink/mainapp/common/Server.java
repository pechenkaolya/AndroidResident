package com.buildinglink.mainapp.common;

public class Server {

    public static String returnServer(){
        String qaServer = "com.buildinglink.mainapp.debug.qa:";
        String stagingServer = "com.buildinglink.mainapp.staging:";
        String prodServer =  "com.buildinglink.mainapp:";
        return qaServer;
    }

}
