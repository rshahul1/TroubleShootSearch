package troubleShootSearch.element;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckFile {

    // Class with fileInfo.txt and Synonyms.txt data in Arraylist and hashmap respectively	
    ArrayList<String> fileData= new ArrayList<String>();
    ArrayList<String> semInput= new ArrayList<String>();
    HashMap<String, String> semData = new HashMap<String, String>();

    public CheckFile(ArrayList<String> fileData, ArrayList<String> semInput) {
        this.fileData=fileData;
        this.semInput=semInput;

        String [] parts;
        for(int i=0;i<semInput.size();i++) {
            parts = semInput.get(i).split("=");
            (this.semData).put(parts[0], parts[1]);
        }


    }
    public ArrayList getFileData(){
        return fileData;
    }
    public HashMap getSemData(){
        return semData;
    }

}
