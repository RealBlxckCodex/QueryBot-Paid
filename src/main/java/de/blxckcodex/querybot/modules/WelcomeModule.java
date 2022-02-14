package de.blxckcodex.querybot.modules;

import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import de.blxckcodex.querybot.message.BotData;
import de.blxckcodex.querybot.module.QueryModule;

public class WelcomeModule extends QueryModule {

    private BotData botData;

    public WelcomeModule(TS3Query query, BotData botData){
        super(query);
        this.botData = botData;
    }

    @Override
    public void onClientJoin(ClientJoinEvent e){
        getQuery().getApi().sendPrivateMessage(e.getClientId(), botData.getWelcomeMessage());
    }

}
