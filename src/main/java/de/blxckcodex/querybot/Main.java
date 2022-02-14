package de.blxckcodex.querybot;

import de.blxckcodex.querybot.bot.QueryBot;
import de.blxckcodex.querybot.bot.QueryConnectionData;
import de.blxckcodex.querybot.message.BotData;

public class Main {

    public static void main(String[] args){
        QueryConnectionData queryConnectionData = new QueryConnectionData("localhost", "serveradmin", "QueryBot", "o89ncq5E", 10011, 1, 9987);
        BotData botData = new BotData("Test", "Es wurden $(currentteam) Teamler benachrichtigt.", "Es ist gerade $(clientname) im Support.", "", "", "", "", "", "", "", "", 11, 17, 3,1,13,3);
        QueryBot queryBot = new QueryBot(queryConnectionData, botData);
        queryBot.connect();
    }

}
