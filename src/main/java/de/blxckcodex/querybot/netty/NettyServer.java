package de.blxckcodex.querybot.netty;

import com.blogspot.debukkitsblog.net.Datapackage;
import com.blogspot.debukkitsblog.net.Executable;
import com.blogspot.debukkitsblog.net.Server;

import java.net.Socket;

public class NettyServer extends Server {


    /**
     * Constructs a simple server with all possible configurations
     *
     * @param port                    The port to listen on
     * @param autoRegisterEveryClient Whether a client that connects should be registered to send it
     *                                broadcast and direct messages later
     * @param keepConnectionAlive     Whether the connection should be kept alive using a ping package.
     *                                The transmission interval can be set using
     *                                <code>setPingInterval(int seconds)</code>.
     * @param useSSL
     */
    public NettyServer(int port, boolean autoRegisterEveryClient, boolean keepConnectionAlive, boolean useSSL) {
        super(port, autoRegisterEveryClient, keepConnectionAlive, useSSL);
    }

    /**
     * Called just before the actual server starts. Register your handler methods in
     * here using
     * <code>registerMethod(String identifier, Executable executable)</code>!
     */
    @Override
    public void preStart() {
        registerMethod("", new Executable() {
            @Override
            public void run(Datapackage pack, Socket socket) {

            }
        });

    }
}
