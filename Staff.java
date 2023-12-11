/**
 * My staff class that allows me to create staff
 * 
 * @author Chase
 *
 */
public class Staff {
	private int id;// used for assigning an ID to the staff
	private String name;// used to set name for staff
	private String specialization;// used to set specialization of staff
	private boolean availiable;// used to set availability of the staff

	/**
	 * Basic constructor to create a new staff
	 * 
	 * @param id             input for id number
	 * @param name           input for name
	 * @param specialization input for specialization
	 */

	public Staff(int id, String name, String specialization) {
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.availiable = true;
	}// end constructor

	/**
	 * gets Id number
	 * 
	 * @return the id number
	 */

	public int getId() {
		return id;
	}// end getId

	/**
	 * sets the ID number
	 * 
	 * @param id input for new ID number
	 */

	public void setId(int id) {
		this.id = id;
	}// end setId

	/**
	 * Gets the name
	 * 
	 * @return the name
	 */

	public String getName() {
		return name;
	}// end getName

	/**
	 * sets the name
	 * 
	 * @param name input for new name
	 */

	public void setName(String name) {
		this.name = name;
	}// end setName

	/**
	 * gets the specialization
	 * 
	 * @return the specialization
	 */

	public String getSpecialization() {
		return specialization;
	}// end getSpecialization

	/**
	 * sets the specialization
	 * 
	 * @param specialization input for new specialization
	 */

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}// end setSpecialization

	/**
	 * finds if staff is available
	 * 
	 * @return
	 */

	public boolean isAvailiable() {
		return availiable;
	}// end isAvailable

	/**
	 * sets if staff is available
	 * 
	 * @param avaliable input for if staff available
	 */

	public void setAvailiable(boolean avaliable) {
		this.availiable = avaliable;
	}// end setAvailable

}// end class
