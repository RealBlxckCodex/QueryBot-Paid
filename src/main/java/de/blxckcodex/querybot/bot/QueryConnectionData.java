package de.blxckcodex.querybot.bot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QueryConnectionData {

    private String address, username, nickname, password;
    private int queryPort, virtualServer, port;

}
