package troubleShootSearch.visitor;

import troubleShootSearch.driver.Driver;
import troubleShootSearch.element.MyArrayList;
import troubleShootSearch.util.MyLogger;

import java.util.ArrayList;

public class ExactMatch implements ArrayListVisitorI {

    public ExactMatch(){
        MyLogger.writeMessage("Inside ExactMatch Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }
    @Override
    public void visit(MyArrayList l, String s) {
	    //checks if the userinput is an exact match with the file input
        MyLogger.writeMessage("--Exact Match Visitor--", MyLogger.DebugLevel.VISITOR);
        ArrayList<String> fileData= new ArrayList<String>();
        fileData = l.getFileData();
        int count =0;
        int flag =0;

        for(int i=0;i<fileData.size();i++){
            if((fileData.get(i)).toLowerCase().contains(s.toLowerCase())){
                count++;
                Driver.entireOutput.add( count + ". " +fileData.get(i));
                flag = 1;
            }

        }
        if(flag ==0)
            Driver.entireOutput.add("No Exact Match");


    }
}
