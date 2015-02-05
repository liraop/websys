package hw01;

/**
 * Class to represent an Item.
 * Basically getters and setters for its atributes are implemented.
 * @author Pedro de Oliveira Lira - pdeolive@syr.edu
 *
 */
public class Item {

	private String name;
	private String description;
	private float weight;
	private int id;	

	public Item(int id, String name, String description, float weight) throws Exception{
		setName(name);
		setDescription(description);
		setWeight(weight);
		setId(id);
	}
	
	private void setId(int id) {
		this.id = id;
	}
	
	private void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode(){
		int hash = 1;
		hash *= (hash + name.hashCode());
		hash *= (hash + description.hashCode());
		return hash;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException{
		if ( name == null || name.trim().equals("")){
			new IllegalArgumentException();
		} else {
			this.name = name;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws IllegalArgumentException {
		if ( description == null || description.trim().equals("")){
			new IllegalArgumentException();
		} else {
			this.description = description;
		}
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString(){
		return "\nItem ID:"+getId()+"\nItem name: "+getName()+"\nItem weight: "+getWeight()+"\nItem description: "+getDescription()+"\n";		
	}

	private float getWeight() {
		return this.weight;
	}
}
