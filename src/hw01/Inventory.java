package hw01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {

	private Map<Integer,Item> inventory;
	
	public Inventory(){
		inventory = new HashMap<Integer, Item>(); 
	}
	
	
	/**
	 * method to add q number of i item to the inventory 
	 * @param i
	 * @param q
	 * @exception IllegalArgumentException - q > 0 and not null. i not null. 
	 * @return True if successfully added. 
	 */
	public boolean add( Item i, Integer q) throws IllegalArgumentException{
		if ( q == null || q == 0){
			throw new IllegalArgumentException();
		}
		
		if (i == null){
			throw new IllegalArgumentException();
		}
		
		
		if (inventory.containsKey(i.getId())){
			inventory.get(i).setQuantity(q);;
		} else {
			inventory.put(i.getId(),i);
		}
		return true;
	}
	
	/**
	 * method to add an item to inventory
	 * @param Item i
	 * @return True if successfully added. 
	 */
	public boolean add(Item i) throws IllegalArgumentException{
		try {
			this.add(i,1);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	

	public void cleanInv(){
		inventory.clear();
	}
	
	/**
	 * method to remove an item by its ID. 
	 * 
	 * @param id
	 * @return
	 */
	public boolean remove(String id){
		return true;
	}
	
	
	@Override
	public String toString(){
		String toStr = "==========--------The inventary-------==========\n";
		
		Iterator it = inventory.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        toStr = pairs.getValue() + "\n";
	        it.remove(); // avoids a ConcurrentModificationException
		    toStr += "\n==========----------------------------==========";
	    }
	    return toStr;
	}
	
}
