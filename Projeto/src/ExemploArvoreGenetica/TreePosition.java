package ExemploArvoreGenetica;

public interface TreePosition<T> extends Position<T> {

	void setElement(T o);
	T getElement();
	PositionList<Position<T>> getChildren();
	void setChildren(PositionList<Position<T>> c);
	TreePosition<T> getParent();
	void setParent(TreePosition<T> v);

}
