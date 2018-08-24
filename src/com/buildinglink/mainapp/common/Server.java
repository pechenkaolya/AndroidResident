package com.buildinglink.mainapp.common;

public class Server {

    public static String setUpEndpoint(){
        String qaServer = "com.buildinglink.mainapp.debug.qa:";
        String stagingServer = "com.buildinglink.mainapp.debug.staging:";
        String prodServer =  "com.buildinglink.mainapp:";
        return stagingServer;
    }

}
