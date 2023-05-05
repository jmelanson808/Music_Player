/**
 * Jesse Melanson and Jose Mendez
 */
import java.util.ArrayList;

public class ListStack<T> implements Stack<T> {

	ArrayList<T> list = new ArrayList<T>();
	
	@Override
	public void push(T item) {
		list.add(item);
	}

	@Override
	public T pop() {
		if(isEmpty() == false) {
			T temp = list.get(list.size()-1);
			list.remove(list.size()-1);
			return temp;
		}
		return null;
	}

	@Override
	public T peek() {
		if(isEmpty() == false) {
			return list.get(list.size()-1);
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(list.size() == 0) {
			return true;
		}
		return false;
	}

}
