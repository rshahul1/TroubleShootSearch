package troubleShootSearch.visitor;

import troubleShootSearch.driver.Driver;
import troubleShootSearch.element.MyArrayList;
import troubleShootSearch.util.MyLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SemanticMatch implements ArrayListVisitorI {
    public SemanticMatch(){
        MyLogger.writeMessage("Inside Semantic Match Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }
    @Override
    public void visit(MyArrayList l, String s) {
	    //checks if the user input obeys semantic match
        MyLogger.writeMessage("--Semantic Match Visitor--", MyLogger.DebugLevel.VISITOR);
        ArrayList<String> fileData = new ArrayList<String>();
        fileData = l.getFileData();
        HashMap<String, String> semData = new HashMap<String, String>();
        semData = l.getSemData();
        String match = " ";
        String[] parts = s.split(" ");
        if (semData.containsKey(parts[1])) {
            match = semData.get(parts[1]);
        } else if (semData.containsValue(parts[1])) {
            // String match = semData.getKey(parts[1]);
            for (Map.Entry entry : semData.entrySet()) {
                if (parts[1].equals(entry.getValue())) {
                    match = (String) entry.getKey();
                    break; //breaking because its one to one map
                }
            }
        }
	//goes inside the loop only if there is a match in synonyms.txt else no semantic match
        if (!(match.equals(" "))) {
            String semString = parts[0] + " " + match;

            ExactMatch ex = new ExactMatch();
            ex.visit(l, semString);
        }
        else
            Driver.entireOutput.add("No Semantic Match");
    }
    }

