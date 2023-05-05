import java.util.ArrayList;

public class ListQueue<T> implements Queue<T> {

	ArrayList<T> list = new ArrayList<T>();
	
	@Override
	public void add(T item) {
		list.add(item);
	}

	@Override
	public T remove() {
		if (list.size() != 0){
			return list.remove(0);
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (list.size() == 0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return list.size();
	}

}
