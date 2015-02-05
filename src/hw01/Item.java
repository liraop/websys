package hw01;

public class Item {

	private String name;
	private String description;
	private int id;
	private int quantity;
	

	public Item(String name, String description) throws Exception{
		setName(name);
		setDescription(description);
		setId();
		this.quantity = 1;
	}
	
	public void setQuantity(int i) {
		this.quantity += i;
	}
	
	public int getQuantity(){
		return this.quantity;
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

	private void setId() {
		this.id = this.hashCode();
	}
	
	@Override
	public String toString(){
		return "Item ID: "+getId()+"\nItem name: "+getName()+"\nQuantity: "+getQuantity()+"\nItem description: "+getDescription()+"\n";		
	}
}
