package de.blxckcodex.querybot.netty;

import com.blogspot.debukkitsblog.net.Client;

public class NettyClient extends Client {
    /**
     * Constructs a simple client with all possible configurations
     *
     * @param hostname The hostname to connect to
     * @param port     The port to connect to
     * @param timeout  The timeout after a connection attempt will be given up
     * @param useSSL   Whether a secure SSL connection should be used
     * @param id       The id the server may use to identify this client
     * @param group    The group name the server may use to identify this and similar
     */
    public NettyClient(String hostname, int port, int timeout, boolean useSSL, String id, String group) {
        super(hostname, port, timeout, useSSL, id, group);
    }
}
