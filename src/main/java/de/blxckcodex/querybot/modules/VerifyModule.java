package de.blxckcodex.querybot.modules;

import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import de.blxckcodex.querybot.message.BotData;
import de.blxckcodex.querybot.module.QueryModule;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class VerifyModule extends QueryModule {

    private BotData botData;

    public VerifyModule(TS3Query query, BotData botData) {
        super(query);
        this.botData = botData;
    }

    public void onVerifyCommand(TextMessageEvent e){
        Client client = getQuery().getApi().getClientInfo(e.getInvokerId());
        if(e.getMessage().equalsIgnoreCase("!verify")){
            getQuery().getApi().sendPrivateMessage(e.getInvokerId(), "Bitte benutze: '!verify <Ingame-Name>'");
        } else if(e.getMessage().startsWith("!verify ")){
            for (int i = 0; i < client.getServerGroups().length; i++) {
                if (client.getServerGroups()[i] != botData.getVerifyGroupId()) {
                    String playername = e.getMessage().replace("!verify ", "");
                    getQuery().getApi().sendPrivateMessage(e.getInvokerId(), "Du hast Ingame eine Nachricht erhalten.");
                    getQuery().getApi().sendPrivateMessage(e.getInvokerId(), "Bitte befolge die dort genannten Anweisungen um dich zu verifizieren");


                } else {
                    getQuery().getApi().sendPrivateMessage(e.getInvokerId(), "Du bist bereits verifiziert!");

                }

            }
        }

    }

    private Integer getIconAsInteger(final String name) {
        Integer iconId = null;
        try {
            final URL url = new URL("https://minotar.net//helm//" + name + "//16.png");
            final InputStream inputStream = url.openStream();
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.flush();
            ImageIO.write(ImageIO.read(inputStream), "PNG", byteArrayOutputStream);
            iconId = getQuery().getAsyncApi().uploadIconDirect(byteArrayOutputStream.toByteArray()).getUninterruptibly().intValue();
            byteArrayOutputStream.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return iconId;
    }

}