package troubleShootSearch.util;

import troubleShootSearch.driver.Driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements StdoutDisplayInterface,FileDisplayInterface {
    public Results(){
        MyLogger.writeMessage("Inside Results Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void writeToFile() {
       //method writes the outputString to the file output.txt 
        try {
            String joinOutput = " ";
            FileWriter f = new FileWriter(Driver.outFile);
            for (int i = 0; i < Driver.entireOutput.size(); i++) {
                joinOutput = joinOutput + Driver.entireOutput.get(i);
                joinOutput = joinOutput + "\n";
            }
            f.write(joinOutput);
            f.close();
            MyLogger.writeMessage("Output.txt is generated", MyLogger.DebugLevel.FILE_GENERATE);
        }  catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void writeToStdout() {
        String joinString = " ";
        for(int i =0;i<Driver.entireOutput.size();i++){
            joinString = joinString + Driver.entireOutput.get(i);
            joinString = joinString + "\n";

        }
        System.out.println(joinString);
    }
}
