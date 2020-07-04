package troubleShootSearch.visitor;

import troubleShootSearch.element.MyTree;

public interface TreeVisitorI extends VisitorI {
    public void visit(MyTree t, String s);
}
