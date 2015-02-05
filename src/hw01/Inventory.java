package hw01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Class to represent an simple inventory implementation.
 * Basic functions implemented such as add, remove, search(contains) and to string. 
 * @author Pedro de Oliveira Lira - pdeolive@syr.edu
 *
 */
public class Inventory {

	private Map<Integer,Item> inventory;
	
	public Inventory(){
		inventory = new HashMap<Integer, Item>(); 
	}
	
	
	/**
	 * method to add an i item to the inventory 
	 * @param i
	 * @param q
	 * @exception IllegalArgumentException - i not null; i ID already on inventory.
	 * @return True if successfully added. 
	 */
	public boolean add( Item i) throws IllegalArgumentException{
		if (i == null){
			throw new IllegalArgumentException();
		}
		
		if (inventory.containsKey(i.getId())){
			throw new IllegalArgumentException();
		}
	
		inventory.put(i.getId(),i);
		
		return true;
	}
	

	/**
	 * Method to clean up the entire inventory. 
	 */
	public void cleanInv(){
		inventory.clear();
	}
	
	/**
	 * method to remove an item by its ID. 
	 * 
	 * @param id
	 * @throws IllegalArgumentException - If there is no item on the Inventory with this ID.
	 * @return
	 */
	public boolean remove(int id) throws IllegalArgumentException{
		if (!inventory.containsKey(id)){
			throw new IllegalArgumentException();
		}
		
		inventory.remove(id);
		return true;
	}
	
	/*
	 * Method to check if an item exists by an ID.
	 */
	public boolean containsItem(int itemID){
		return inventory.containsKey(itemID) ? true : false;
	}
	
	@Override
	public String toString(){
		String toStr = "==========--------The inventary-------==========\n";
		
		Iterator it = inventory.keySet().iterator();
	    for (Integer id : inventory.keySet()){
	        toStr += inventory.get(id).toString() + "\n";
		    toStr += "\n==========----------------------------==========";
	    }
	    return toStr;
	}
	
}
