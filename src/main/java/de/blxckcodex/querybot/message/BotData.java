package de.blxckcodex.querybot.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BotData {

    private String welcomeMessage = "", supportMessageUser = "", supportMessageTeam = "", teamOnline = "",
            noTeamOnline = "", oneTeamOnline = "", pizzaNotification = "", awayMessage = "", pizzaTimerCommand = "",
            channelCounterPrefix = "", channelCounterSuffix = "";
    private int supportChannelId = 0, supportGroupId = 0, afkChannelId = 0, awayTime = 0, pizzaTime = 0,
            counterChannelId = 0;

}
