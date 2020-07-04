package troubleShootSearch.element;


import troubleShootSearch.visitor.ExactMatch;
import troubleShootSearch.visitor.NaiveStemming;
import troubleShootSearch.visitor.SemanticMatch;
import troubleShootSearch.visitor.VisitorI;

import java.util.ArrayList;

public interface ElementI {
    public void accept(VisitorI v, String s, CheckFile cf);
 //   public void accept(SemanticMatch v, String s, CheckFile cf);
 //   public void accept(NaiveStemming v, String s, CheckFile cf);

}
