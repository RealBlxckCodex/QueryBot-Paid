package de.blxckcodex.querybot.modules;

import de.blxckcodex.querybot.message.BotData;
import de.blxckcodex.querybot.module.QueryModule;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

public class AFKModule extends QueryModule {

    private HashMap<String, Long> awayFromKeyboard = new HashMap<>();
    private HashMap<String, Boolean> moved = new HashMap<>();
    private HashMap<String, Integer> channel = new HashMap<>();

    private BotData botData;

    public AFKModule(TS3Query query, BotData botData) {
        super(query);

        this.botData = botData;
    }

    public void start(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Client c : getQuery().getApi().getClients()){
                    if(!(c.isServerQueryClient())){
                        if(c.isAway() || c.isInputMuted() || c.isOutputMuted()){
                            if(!(moved.containsKey(c.getUniqueIdentifier()))){
                                if(awayFromKeyboard.containsKey(c.getUniqueIdentifier())){
                                    awayFromKeyboard.put(c.getUniqueIdentifier(), System.currentTimeMillis());
                                }else{
                                    long current = awayFromKeyboard.get(c.getUniqueIdentifier());
                                    if((System.currentTimeMillis() - current) >= botData.getAwayTime()){
                                        moved.put(c.getUniqueIdentifier(), true);
                                        channel.put(c.getUniqueIdentifier(), c.getChannelId());
                                        awayFromKeyboard.remove(c.getUniqueIdentifier());
                                        getQuery().getApi().sendPrivateMessage(c.getId(), botData.getAwayMessage());
                                        getQuery().getApi().moveClient(c.getId(), botData.getAfkChannelId());
                                    }

                                }
                            }
                        }else{
                            awayFromKeyboard.remove(c.getUniqueIdentifier());
                            if(moved.containsKey(c.getUniqueIdentifier())){
                                getQuery().getApi().moveClient(c.getId(), channel.get(c.getUniqueIdentifier()));
                                moved.remove(c.getUniqueIdentifier());
                            }
                        }
                    }
                }
            }
        }, 1000, 5000);
    }
}