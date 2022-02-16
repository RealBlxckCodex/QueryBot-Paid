package de.blxckcodex.querybot;

import de.blxckcodex.querybot.bot.QueryBot;
import de.blxckcodex.querybot.bot.QueryConnectionData;
import de.blxckcodex.querybot.message.BotData;
import de.blxckcodex.querybot.setup.query.QuerySetup;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        QuerySetup querySetup = new QuerySetup();

        System.out.println(" ");
        System.out.println("   ____                        ____        __ \n" +
                "  / __ \\__  _____  _______  __/ __ )____  / /_\n" +
                " / / / / / / / _ \\/ ___/ / / / __  / __ \\/ __/\n" +
                "/ /_/ / /_/ /  __/ /  / /_/ / /_/ / /_/ / /_  \n" +
                "\\___\\_\\__,_/\\___/_/   \\__, /_____/\\____/\\__/  \n" +
                "                     /____/         ");
        System.out.println(" ");
        System.out.println("[SYSTEM] Checking if QuerySetup is completed...");

        if(querySetup.isSetupDone()){
            System.out.println("[SYSTEM] Setup has already been completed!");
            System.out.println("[SYSTEM] Starting QueryBot...");
            QueryConnectionData queryConnectionData = new QueryConnectionData("localhost", "serveradmin", "QueryBot", "o89ncq5E", 10011, 1, 9987);
            BotData botData = new BotData("Test", "Es wurden $(currentteam) Teamler benachrichtigt.", "Es ist gerade $(clientname) im Support.", "", "", "", "", "", "", "", "", 11, 17, 3,1,13,3);
            QueryBot queryBot = new QueryBot(queryConnectionData, botData);
            queryBot.connect();
        } else {
            System.out.println("[SYSTEM] Setup still needs to be done!");
            System.out.println("[SYSTEM] Starting Setup...");
            querySetup.start();

        }

    }
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }


}
