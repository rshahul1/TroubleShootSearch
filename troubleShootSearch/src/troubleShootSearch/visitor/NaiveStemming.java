package troubleShootSearch.visitor;

import troubleShootSearch.driver.Driver;
import troubleShootSearch.element.MyTree;
import troubleShootSearch.util.MyLogger;

import java.util.ArrayList;

public class NaiveStemming implements TreeVisitorI {
    public NaiveStemming(){
        MyLogger.writeMessage("Inside NaiveStemming Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }
    public ArrayList<String> naiveWord = new ArrayList<String>();
    public ArrayList<String> fileData = new ArrayList<String>();
    public ArrayList<Integer> line = new ArrayList<Integer>();
    @Override
    public void visit(MyTree t, String s) {
           //checks of the user input obeys NaiveStemming match
        MyLogger.writeMessage("--Naive Stemming Match Visitor--", MyLogger.DebugLevel.VISITOR);
        String[] parts = s.split(" ");
        t.traverseInOrder(parts[0],this);
       
        this.fileData = t.getFileData();

             if(naiveWord.size()!=0) {
                 Driver.entireOutput.add("Word Count : "+this.naiveWord.size());
                 for (int j = 0; j < fileData.size(); j++) {
                     if (((fileData.get(j)).indexOf(naiveWord.get(0))) != -1) {
                         line.add(j);
                     }
                 }
       
                 Driver.entireOutput.add("line no : ");
                 for (int i = 0; i < line.size(); i++)
                     Driver.entireOutput.add(line.get(i).toString());
                 this.naiveWord.clear();
                 this.line.clear();
             }
             else
                 Driver.entireOutput.add("No Naive Stemming");
    }
}
