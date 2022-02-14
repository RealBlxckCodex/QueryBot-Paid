package de.blxckcodex.querybot;

import de.blxckcodex.querybot.bot.QueryBot;
import de.blxckcodex.querybot.bot.QueryConnectionData;
import de.blxckcodex.querybot.message.BotData;
import de.blxckcodex.querybot.setup.query.QuerySetup;

public class Main {

    public static void main(String[] args){

        QuerySetup querySetup = new QuerySetup();

        if(querySetup.isSetupDone() == true){
            QueryConnectionData queryConnectionData = new QueryConnectionData("localhost", "serveradmin", "QueryBot", "o89ncq5E", 10011, 1, 9987);
            BotData botData = new BotData("Test", "Es wurden $(currentteam) Teamler benachrichtigt.", "Es ist gerade $(clientname) im Support.", "", "", "", "", "", "", "", "", 11, 17, 3,1,13,3);
            QueryBot queryBot = new QueryBot(queryConnectionData, botData);
            queryBot.connect();
        } else {

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
