
import java.util.ArrayList;

public class Pila {
	private ArrayList<Object> ar;
	String msg;
	
	public Pila() {
		 ar = new ArrayList<Object>();
		 msg = "La pila è vuota";
	}
	
	public void push(Object obj) {
		ar.add(obj);
	}
	
	public Object pop() {
		if(isEmpty()) return msg;
		return ar.remove(size()-1);
	}
	
	public Object top() {
		if(isEmpty()) return msg;
		return ar.get(size()-1);
	}
	
	public boolean isEmpty() {
		if(ar.size() == 0) return true;
		return false;
	}
	
	public int size() {
		return ar.size();
	}
}