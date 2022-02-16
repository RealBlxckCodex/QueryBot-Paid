package de.blxckcodex.querybot.config.query;
import com.google.gson.Gson;
import lombok.Getter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Getter
public class QueryConfig {

    private final Gson gson = new Gson();
    private final File file = new File("./config/QueryConfig.json");

    public void saveConfig(String address, String username, String nickname, String password, int queryPort, int virtualServer, int port) {

        try(FileWriter fileWriter = new FileWriter(file)){
            if(!file.exists()) file.createNewFile();
            fileWriter.write(gson.toJson(address));
            fileWriter.write(gson.toJson(username));
            fileWriter.write(gson.toJson(nickname));
            fileWriter.write(gson.toJson(password));
            fileWriter.write(gson.toJson(queryPort));
            fileWriter.write(gson.toJson(virtualServer));
            fileWriter.write(gson.toJson(port));

        } catch (IOException e){
            e.printStackTrace();
        }

    }


}
