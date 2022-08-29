package be.uantwerpen.fti.ei.geavanceerde.platform.helper;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
/**
 * With help of internet
 * ConfigFileReader
 * @author Ayoub Aouraghe
 * */
public class ConfigFileReader {
    private static ConfigFileReader configFileReaderInstance;
    private ConfigFileReader() {}

    /**
     * ConfigFileReader
     * @return
     */
    public static ConfigFileReader getConfigFileReaderInstance() {
        return configFileReaderInstance == null ? configFileReaderInstance = new ConfigFileReader() : configFileReaderInstance;
    }

    /**
     *loadOrCreateConfig function
     * @param configFile
     * @return
     */
    public HashMap<String, Integer> loadOrCreateConfig(final String configFile) {
        HashMap<String, Integer> dataMap = null;
        try {
            File _file = new File("src/" + configFile);
            if (_file.exists()) {
                Scanner myReader = new Scanner(_file);
                dataMap = new HashMap<>();
                while (myReader.hasNextLine()) {
                    /// read data
                    String data = myReader.nextLine();
                    data = data.replace(" ", "");
                    /// process data
                    int splitIndex = data.indexOf(":");
                    int dataLength = data.length();
                    String var_key = splitIndex != -1 ? data.substring(0, splitIndex) : "";
                    String var_data = splitIndex != -1 ? data.substring(splitIndex + 1, dataLength) : "";
                    dataMap.put(var_key, Integer.parseInt(var_data));
                }
            }
        } catch (Exception ignored) {};
        return dataMap;
    }
}
