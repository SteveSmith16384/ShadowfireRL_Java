package ssmith.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortedArrayList<T> extends ArrayList<T> {

	private static final long serialVersionUID = 1L;


	@SuppressWarnings("unchecked")
    public void addWithSort(T value) {
        add(value);
        Comparable<T> cmp = (Comparable<T>) value;
        for (int i = size()-1; i > 0 && cmp.compareTo(get(i-1)) < 0; i--)
            Collections.swap(this, i, i-1);
    }
    
    
    public void addAllWithSort(Collection<T> value) {
    	for(T o : value) {
    		this.addWithSort(o);
    	}
    }
    
}
