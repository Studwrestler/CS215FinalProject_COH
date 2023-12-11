import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * My patient class that allows me to create a new patient
 * 
 * @author Chase
 *
 */
public class Patient {
	private int id;// used to give the patient an ID number
	private String name;// used to give the patient a name
	private String condition;// used to give the patient a condition
	private int priority;// used to set the priority of the patient
	private static int nextId = 1;// used to start ID numbers
	private static final Random random = new Random();// Used to generate a random priority if one can not be assigned
														// based on condition
	private Staff assignedStaff;// used to assign staff to the patient
	private Room assignedRoom;// used to assign a room to the patient
	private List<Equipment> assignedEquipment; // use to assign equipment to the patient

	/**
	 * Basic constructor for a Patient
	 * 
	 * @param name      input for name of the patient
	 * @param condition input for condition of the patient
	 */
	public Patient(String name, String condition) {
		this.id = nextId++;
		this.name = name;
		this.condition = condition;
		this.priority = generatePriority(condition.toLowerCase());
		this.assignedEquipment = new ArrayList<>();
	}// end constructor

	/**
	 * gets the name
	 * 
	 * @return the name
	 */

	public String getName() {
		return name;
	}// end getName

	/**
	 * sets the name of the patient
	 * 
	 * @param name input for new name
	 */

	public void setName(String name) {
		this.name = name;
	}// end setName

	/**
	 * gets the condition
	 * 
	 * @return the condition
	 */

	public String getCondition() {
		return condition;
	}// end getCondition

	/**
	 * set the condition as well as the priority
	 * 
	 * @param condition input for new condition
	 */

	public void setCondition(String condition) {
		this.condition = condition;
		this.priority = generatePriority(condition.toLowerCase());
	}// end setCondition

	/**
	 * gets the ID number
	 * 
	 * @return the ID number
	 */

	public int getId() {
		return id;
	}// end getId

	/**
	 * Gets the priority
	 * 
	 * @return the priority
	 */

	public int getPriority() {
		return priority;
	}// end getPriority

	/**
	 * Generates a Priority based on the condition
	 * 
	 * @param condition input for the priority to based on
	 * @return the priority
	 */

	private int generatePriority(String condition) {

		if (condition.contains("emergency") || condition.contains("critical")) {
			return 10;
		} else if (condition.contains("serious") || condition.contains("severe")) {
			return 8;
		} else if (condition.contains("moderate") || condition.contains("medium")) {
			return 5;
		} else {
			return random.nextInt(4) + 1;
		}
	}// end generatePriority

	/**
	 * sets the assigned staff for the patient
	 * 
	 * @param staff input what staff you want assigned
	 */

	public void setAssignedStaff(Staff staff) {
		this.assignedStaff = staff;
	}// end setAssignedStaff

	/**
	 * gets the assigned staff
	 * 
	 * @return the assigned staff
	 */
	public Staff getAssignedStaff() {
		return assignedStaff;
	}// end getAssignedStaff

	/**
	 * sets the assigned room
	 * 
	 * @param room input for assigning room
	 */

	public void setAssignedRoom(Room room) {
		this.assignedRoom = room;
	}// end setAssignedRoom

	/**
	 * Gets the assigned Room
	 * 
	 * @return the assigned room
	 */

	public Room getAssignedRoom() {
		return assignedRoom;
	}// end getAssignedRoom

	/**
	 * Adds equipment to the patient
	 * 
	 * @param equipment input for equipment you want assigned
	 */

	public void addAssignedEquipment(Equipment equipment) {
		assignedEquipment.add(equipment);
	}// end addAssignedEquipment

	/**
	 * gets the Assigned Equipment
	 * 
	 * @return the assigned equipment
	 */

	public List<Equipment> getAssignedEquipment() {
		return assignedEquipment;
	}// end getAssignedEquipment

	/**
	 * removes staff from patient
	 */

	public void removeAssignedStaff() {
		assignedStaff = null;
	}// end removeAssignedStaff

	/**
	 * removes patient from room
	 */

	public void removeFromRoom() {
		assignedRoom = null;
	}// end removeRoom

}// end class
