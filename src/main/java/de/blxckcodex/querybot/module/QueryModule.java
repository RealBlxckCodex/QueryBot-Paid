package de.blxckcodex.querybot.module;

import com.github.theholywaffle.teamspeak3.TS3ApiAsync;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import lombok.Getter;

public class QueryModule extends TS3EventAdapter {

    @Getter
    private TS3Query query;
    private TS3ApiAsync ts3ApiAsync;

    public QueryModule(TS3Query query) {
        this.query = query;
        this.sendLog();
    }

    public void registerEvents() {
        getQuery().getApi().registerAllEvents();
        getQuery().getApi().addTS3Listeners(this);
    }

    public TS3ApiAsync getTs3ApiAsync() {
        return this.ts3ApiAsync;
    }

    void sendLog() {
        String modules = this.getClass().getName().replace("de.blxckcodex.querybot.modules.", "");
        System.out.println("[MODULE] Loading " + modules.replace("Module", "") + " Module...");
    }
}
