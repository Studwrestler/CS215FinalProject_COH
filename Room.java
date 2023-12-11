/**
 * My Room class that allows me to create Rooms
 * 
 * @author Chase
 *
 */
public class Room {
	private int id;// used to set a room number
	private String type;// used to set the type of room
	private boolean available;// used to determine if the room is available

	/**
	 * My constructor for a Room
	 * 
	 * @param id   input to set the room number
	 * @param type input to set the room type
	 */

	public Room(int id, String type) {
		this.id = id;
		this.type = type;
		this.available = true;
	}// end constructor

	/**
	 * gets the room number
	 * 
	 * @return the room number
	 */

	public int getId() {
		return id;
	}// end getId

	/**
	 * sets the room number
	 * 
	 * @param id input for setting the room number
	 */

	public void setId(int id) {
		this.id = id;
	}// end setId

	/**
	 * gets the type of room
	 * 
	 * @return the type of room
	 */

	public String getType() {
		return type;
	}// end getType

	/**
	 * sets the room type
	 * 
	 * @param type input for setting the room type
	 */

	public void setType(String type) {
		this.type = type;
	}// end setType

	/**
	 * is true or false if room is available
	 * 
	 * @return if room available
	 */

	public boolean isAvailable() {
		return available;
	}// end isAvailable

	/**
	 * sets availability of the Room
	 * 
	 * @param available input true or false
	 */

	public void setAvailable(boolean available) {
		this.available = available;
	}// end setAvailable

}// end class
