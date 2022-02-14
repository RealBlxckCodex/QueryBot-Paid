package de.blxckcodex.querybot.modules;


import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import de.blxckcodex.querybot.message.BotData;
import de.blxckcodex.querybot.module.QueryModule;

public class SupportModule extends QueryModule {

    private BotData botData;

    public SupportModule(TS3Query query, BotData botData) {
        super(query);

        this.botData = botData;
    }

    @Override
    public void onClientMoved(ClientMovedEvent e) {

        if (e.getTargetChannelId() == botData.getSupportChannelId()) {
            int i1 = 0;
            for (Client c : getQuery().getApi().getClients()) {
                for (int i = 0; i < c.getServerGroups().length; i++) {
                    if (c.getServerGroups()[i] == botData.getSupportGroupId()) {
                        i1++;
                        getQuery().getApi().sendPrivateMessage(c.getId(), botData.getSupportMessageTeam().replace("$(clientname)", getQuery().getApi().getClientInfo(e.getClientId()).getNickname()));
                    }
                }
            }

            getQuery().getApi().sendPrivateMessage(e.getClientId(), botData.getSupportMessageUser().replace("$(currentteam)", String.valueOf(i1)));
            if (i1 == 1) {
                getQuery().getApi().sendPrivateMessage(e.getClientId(), botData.getOneTeamOnline().replace("$(currentteam)", String.valueOf(i1)));
            } else if (i1 == 0) {
                getQuery().getApi().sendPrivateMessage(e.getClientId(), botData.getNoTeamOnline().replace("$(currentteam)", String.valueOf(i1)));
            } else if (i1 > 1) {
                getQuery().getApi().sendPrivateMessage(e.getClientId(), botData.getTeamOnline().replace("$(currentteam)", String.valueOf(i1)));
            }
        }
    }
}

