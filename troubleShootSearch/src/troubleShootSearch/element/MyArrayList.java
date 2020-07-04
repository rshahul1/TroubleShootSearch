package troubleShootSearch.element;

import troubleShootSearch.visitor.ExactMatch;
import troubleShootSearch.visitor.SemanticMatch;
import troubleShootSearch.visitor.VisitorI;

import java.util.ArrayList;
import java.util.HashMap;

public class MyArrayList implements ElementI {
    String s = " ";
    ArrayList<String> fileData = new ArrayList<String>();
    HashMap<String, String> semData = new HashMap<String, String>();

   //Every time a visitor is created, accept method has to be invoked to implement visit method for Exact and Semantic Match.

    @Override
    public void accept(VisitorI v, String s, CheckFile cf) {
        this.fileData = cf.getFileData();
        this.s = s;
        this.semData = cf.getSemData();
	//checking if v is an instance of exact or semantic match before calling the respective visit method.
        if( v instanceof ExactMatch)
            ((ExactMatch)v).visit(this, s);
        else
            ((SemanticMatch)v).visit(this,s);

    }

    public HashMap getSemData(){
        return semData;
    }
    public ArrayList getFileData(){
         return fileData;
      }
}
