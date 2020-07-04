package troubleShootSearch.visitor;

import troubleShootSearch.element.MyArrayList;

public interface ArrayListVisitorI extends VisitorI {
    public void visit(MyArrayList l, String s);

}
