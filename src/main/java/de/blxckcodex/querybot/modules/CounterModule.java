package de.blxckcodex.querybot.modules;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import de.blxckcodex.querybot.message.BotData;
import de.blxckcodex.querybot.module.QueryModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterModule extends QueryModule {

    private BotData botData;

    public CounterModule(TS3Query query, BotData botData) {
        super(query);
        this.botData = botData;
    }

    @Override
    public void onClientJoin(ClientJoinEvent e) {
        super.onClientJoin(e);
        this.updateChannel();
    }

    @Override
    public void onClientLeave(ClientLeaveEvent e) {
        super.onClientLeave(e);
        this.updateChannel();
    }

    void updateChannel() {
        TS3Api api = getQuery().getApi();
        Map<ChannelProperty, String> properties = new HashMap<>();
        List<Client> clients = api.getClients();

        AtomicInteger atomicInteger = new AtomicInteger();
        api.getClients().forEach((client -> {
            if (client.isServerQueryClient())
                atomicInteger.addAndGet(1);
        }));

        properties.put(ChannelProperty.CHANNEL_NAME, botData.getChannelCounterPrefix() + (clients.size() - atomicInteger.get()) + " / "
                + api.getServerInfo().getMaxClients() + botData.getChannelCounterSuffix());
        api.editChannel(this.botData.getCounterChannelId(), properties);
    }

}

