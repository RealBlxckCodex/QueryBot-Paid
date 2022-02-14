package de.blxckcodex.querybot.bot;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import de.blxckcodex.querybot.message.BotData;
import de.blxckcodex.querybot.module.QueryModule;
import de.blxckcodex.querybot.modules.AFKModule;
import de.blxckcodex.querybot.modules.CounterModule;
import de.blxckcodex.querybot.modules.SupportModule;
import de.blxckcodex.querybot.modules.WelcomeModule;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class QueryBot {

    private final TS3Config config = new TS3Config();
    private final TS3Query query = new TS3Query(config);
    private final TS3Api api = query.getApi();

    private QueryConnectionData queryConnectionData;
    private BotData botData;
    private QueryModule queryModule;

    private List<QueryModule> modules;

    public QueryBot(QueryConnectionData queryConnectionData, BotData botData){
        this.queryConnectionData = queryConnectionData;
        this.botData = botData;
        this.modules = new ArrayList<>();
    }

    public void connect(){
        config.setHost(queryConnectionData.getAddress());
        config.setQueryPort(queryConnectionData.getQueryPort());
        config.setFloodRate(TS3Query.FloodRate.UNLIMITED);
        query.connect();
        api.login(queryConnectionData.getUsername(), queryConnectionData.getPassword());
        api.selectVirtualServerByPort(queryConnectionData.getPort());
        api.setNickname(queryConnectionData.getNickname());
        this.modules.forEach(QueryModule::registerEvents);
    }
    public void registerModules() {
        this.registerModule(new AFKModule(query, botData));
        this.registerModule(new CounterModule(query, botData));
        this.registerModule(new SupportModule(query, botData));
        this.registerModule(new WelcomeModule(query, botData));
    }

    public void registerModule(QueryModule queryModule) {
        this.modules.add(queryModule);
        if (query.isConnected()) {
            queryModule.registerEvents();
        }
    }




}
