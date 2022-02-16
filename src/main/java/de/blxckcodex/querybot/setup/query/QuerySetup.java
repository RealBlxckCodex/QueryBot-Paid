package de.blxckcodex.querybot.setup.query;

import de.blxckcodex.querybot.Main;
import de.blxckcodex.querybot.config.query.QueryConfig;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@Getter
@Setter
public class QuerySetup {

    QueryConfig queryConfig = new QueryConfig();

    public boolean isSetupDone(){
        Path path = Paths.get("QueryConfig.json");
        return path.toFile().isFile();
    }

    public void start() throws IOException {
        String address = null, username = null, nickname = null, password = null;
        int queryPort = Integer.parseInt(null), virtualServer = Integer.parseInt(null), port = Integer.parseInt(null);

        Main.ClearConsole();

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        System.out.println("  _____      _               \n" +
                " / ____|    | |              \n" +
                "| (___   ___| |_ _   _ _ __  \n" +
                " \\___ \\ / _ \\ __| | | | '_ \\ \n" +
                " ____) |  __/ |_| |_| | |_) |\n" +
                "|_____/ \\___|\\__|\\__,_| .__/ \n" +
                "                      | |    \n" +
                "                      |_|    \n" +
                "\n" +
                "\n");
        while (true) {
            System.out.println("[SYSTEM] Setup has been started...");
            System.out.println("[SETUP] Please answer the questions by typing in.");
            System.out.println("");
            System.out.println("[SYSTEM] To cancel the setup type 'cancel'");
            System.out.println("");
            System.out.println("[SETUP] Under which IP-Address is the server running?");
            if(!scanner.next().equalsIgnoreCase("cancel")){
                address = scanner.nextLine();
            } else {
                scanner.close();
                cancelSetup();

            }
            System.out.println("[SETUP] Under which Query-Port is the server running? (BY DEFAULT: 10011");
            if(!scanner.next().equalsIgnoreCase("cancel")){
                queryPort = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.close();
                cancelSetup();

            }
            System.out.println("[SETUP] Under which VirtualServer ID is the server running?");
            if(!scanner.next().equalsIgnoreCase("cancel")){
                virtualServer = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.close();
                cancelSetup();

            }
            System.out.println("[SETUP] Under which Port is the TeamSpeak server running? (BY DEFAULT: 9987)");
            if(!scanner.next().equalsIgnoreCase("cancel")){
                port = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.close();
                cancelSetup();

            }
            System.out.println("[SETUP] With which username can the Query connect to the server? (BY DEFAULT: serveradmin)");
            if(!scanner.next().equalsIgnoreCase("cancel")){
                username = scanner.nextLine();
            } else {
                scanner.close();
                cancelSetup();

            }
            System.out.println("[SETUP] With which password can the Query connect to the server?");
            if(!scanner.next().equalsIgnoreCase("cancel")){
                password = scanner.nextLine();
            } else {
                scanner.close();
                Main.ClearConsole();
                cancelSetup();

            }
            System.out.println("[SETUP] Which Nickname should the Query have on your server? (CLIENTNAME ON THE SERVER)");
            if(!scanner.next().equalsIgnoreCase("cancel")){
                nickname = scanner.nextLine();
            } else {
                scanner.close();
                cancelSetup();
            }
            scanner.close();
            System.out.println("");
            System.out.println("[SYSTEM] Setup completed");
            System.out.println("[SYSTEM] Saving Config-File...");
            queryConfig.saveConfig(address, username, nickname, password, queryPort, virtualServer, port);
            System.out.println("[SYSTEM] Config-File has been saved!");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            Main.ClearConsole();

            System.out.println(" ");
            System.out.println("   ____                        ____        __ \n" +
                    "  / __ \\__  _____  _______  __/ __ )____  / /_\n" +
                    " / / / / / / / _ \\/ ___/ / / / __  / __ \\/ __/\n" +
                    "/ /_/ / /_/ /  __/ /  / /_/ / /_/ / /_/ / /_  \n" +
                    "\\___\\_\\__,_/\\___/_/   \\__, /_____/\\____/\\__/  \n" +
                    "                     /____/         ");
            System.out.println(" ");
            System.out.println("[SYSTEM] You have successfully completed the setup!");


        }
    }

    private void cancelSetup(){
        Main.ClearConsole();
        System.out.println("[SYSTEM] You successfully canceled the setup.");
        System.out.println("[SYSTEM] None of your answers has been saved!");
        System.out.println("[SYSTEM] If you want to start the setup again type 'setup'");
    }


}
