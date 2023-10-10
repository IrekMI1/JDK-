package Messenger;

import java.io.*;
import java.util.List;

public class LogHandler {
    private File logFile;

    LogHandler(String fileName) throws IOException {
        logFile = new File(fileName);
        if (!logFile.exists()) {
            this.logFile.createNewFile();
        }
    }

    public String logRead() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(this.logFile));
        List<String> lines = fileReader.lines().toList();
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line + "\n");
        }
        fileReader.close();
        return sb.toString();
    }

    public void logWrite(String textLog) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(this.logFile));
        String tempText = fileReader.lines().toString();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(this.logFile, true));
        fileWriter.write(textLog);
        fileWriter.newLine();
        fileWriter.flush();
        fileWriter.close();
        fileReader.close();
    }
}
