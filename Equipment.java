/**
 * My equipment class that allows me to create equipment
 * 
 * @author Chase
 *
 */
public class Equipment {
	private int id;// used to give a number to the equipment
	private String type;// used to tell you the type of equipment
	private boolean available;// used to tell you if its available

	/**
	 * Basic constructor for Equipment
	 * 
	 * @param id   input you want for the number
	 * @param type input you want for the type
	 */

	public Equipment(int id, String type) {
		this.id = id;
		this.type = type;
		this.available = true;
	}// end constructor

	/**
	 * gets the ID number
	 * 
	 * @return the ID number
	 */

	public int getId() {
		return id;
	}// end getId

	/**
	 * set the Id number
	 * 
	 * @param id input for new id number
	 */

	public void setId(int id) {
		this.id = id;
	}// end setId

	/**
	 * gets the type
	 * 
	 * @return the type of Equipment
	 */

	public String getType() {
		return type;
	}// end getType

	/**
	 * sets the type
	 * 
	 * @param type input for new type
	 */

	public void setType(String type) {
		this.type = type;
	}// end setType

	/**
	 * tells you if equipment is available
	 * 
	 * @return true or false if its available
	 */

	public boolean isAvailable() {
		return available;
	}// end isAvailable

	/**
	 * Allows you set if equipment is available
	 * 
	 * @param available
	 */

	public void setAvailable(boolean available) {
		this.available = available;
	}// end setAvailable

}// end class
