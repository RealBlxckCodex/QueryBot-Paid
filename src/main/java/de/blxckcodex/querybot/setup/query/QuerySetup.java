package de.blxckcodex.querybot.setup.query;

import de.blxckcodex.querybot.Main;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@Getter
@Setter
public class QuerySetup {



    public boolean isSetupDone(){
        Path path = Paths.get("QueryConfig.json");
        return path.toFile().isFile();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        Main.ClearConsole();

    }


}
