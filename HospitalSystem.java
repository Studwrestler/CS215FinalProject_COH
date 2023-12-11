import java.util.ArrayList;
import java.util.List;

/**
 * This is my Hospital System class it will hold all the main lists and methods
 * for my Hospital system
 * 
 * @author Chase
 *
 */
public class HospitalSystem {
	private List<Patient> patients;// will store a list of patients
	private List<Staff> staffList;// will store a list of staff
	private List<Room> rooms;// will store a list of rooms
	private List<Equipment> equipment;// will store a list of equipment

	/**
	 * Main constructor that initializes my lists of each type
	 */

	public HospitalSystem() {
		this.patients = new ArrayList<>();
		this.staffList = new ArrayList<>();
		this.rooms = new ArrayList<>();
		this.equipment = new ArrayList<>();

		initializeStaff();
		initializeRooms();
		initializeEquipment();

	}// end constructor

	/**
	 * allows you to add a patient to the patients list
	 * 
	 * @param patient input that is put in the list
	 */

	public void admitPatient(Patient patient) {
		patients.add(patient);
	}// end admitPatient

	/**
	 * used to add staff to the staff list
	 * 
	 * @param staff input that is put in the list
	 */

	public void addStaff(Staff staff) {
		staffList.add(staff);
	}// end addStaff

	/**
	 * my logic that assigns a staff based on their priority level
	 * 
	 * @param patient input that is assigned the staff
	 */

	public void assignStaffToPatient(Patient patient) {
		int patientPriority = patient.getPriority();
		Staff assignedStaff = null;
		for (Staff staff : staffList) {
			if (staff.getSpecialization().equals("Surgeon") && patientPriority >= 10) {
				assignedStaff = staff;
				break;

			} else if (staff.getSpecialization().equals("Doctor") && patientPriority >= 8) {
				assignedStaff = staff;
				break;
			} else if (staff.getSpecialization().equals("Nurse") && patientPriority >= 5) {
				assignedStaff = staff;
				break;
			}

		}

		if (assignedStaff != null) {
			patient.setAssignedStaff(assignedStaff);
			System.out.println("Assigned " + assignedStaff.getSpecialization() + " " + assignedStaff.getName()
					+ " to Patient ID: " + patient.getId());
		} else {
			System.out.println("No suitable staff available for Patient ID: " + patient.getId());
		}
	}// end assignStaffToPatient

	/**
	 * My logic to assign a patient to a room type based on their priority
	 * 
	 * @param patient input that is assigned the room
	 */

	public void allocateRoom(Patient patient) {
		Room assignedRoom = null;

		if (patient.getPriority() >= 10) {
			assignedRoom = findAvailableRoomByType("Surgery");
		} else if (patient.getPriority() >= 8) {
			assignedRoom = findAvailableRoomByType("Emergency");
		} else if (patient.getPriority() >= 5) {
			assignedRoom = findAvailableRoomByType("General");
		}

		if (assignedRoom != null) {
			assignedRoom.setAvailable(false);
			patient.setAssignedRoom(assignedRoom);
			System.out.println("Assigned Room " + assignedRoom.getId() + " to Patient ID: " + patient.getId());
		} else {
			System.out.println("Patient " + patient.getId() + " is waiting for a room");
		}

	}// end allocateRoom

	/**
	 * My logic for finding an available room of a certain type
	 * 
	 * @param roomType input for type of room you want
	 * @returns the room if available other it returns null
	 */

	private Room findAvailableRoomByType(String roomType) {
		for (Room room : rooms) {
			if (room.isAvailable() && room.getType().equals(roomType)) {
				return room;
			}
		}
		return null;
	}// end findAvailableRoomByType

	/**
	 * my logic for allocating Equipment based on priority
	 * 
	 * @param patient input you want to assign equipment too
	 */

	public void allocateEquipment(Patient patient) {
		Equipment assignedEquipment = null;

		for (Equipment equipment : equipment) {
			if (equipment.isAvailable()) {
				if ((patient.getPriority() >= 10 && equipment.getType().equals("Ventilator"))
						|| (patient.getPriority() >= 8 && equipment.getType().equals("Defibrillator"))
						|| (equipment.getType().equals("Stethoscope"))) {
					assignedEquipment = equipment;
					break;
				}
			}
		}

		if (assignedEquipment != null || false) {
			assignedEquipment.setAvailable(false);
			patient.addAssignedEquipment(assignedEquipment);
			System.out.println("Assigned " + assignedEquipment.getType() + " to Patient ID: " + patient.getId());
		} else {
			System.out.println("No available suitable equipment for Patient ID: " + patient.getId());
		}
	}// end allocateEquipment

	/**
	 * my logic for exiting the hospital and wiping data
	 */

	public void exit() {
		System.out.println("Exiting the hospital system...");

		patients.clear();
		staffList.clear();
		rooms.clear();
		equipment.clear();

		System.exit(0);
	}// end exit

	/**
	 * My logic for removing staff, room, and equipment that is assigned to a
	 * patient
	 * 
	 * @param patient input that you want this stuff removed from
	 */

	public void deallocateResources(Patient patient) {
		Room assignedRoom = patient.getAssignedRoom();
		if (assignedRoom != null) {
			patient.removeFromRoom();
			assignedRoom.setAvailable(true);
		}

		Staff assignedStaff = patient.getAssignedStaff();
		if (assignedStaff != null) {
			patient.removeAssignedStaff();
		}

		List<Equipment> assignedEquipment = patient.getAssignedEquipment();
		for (Equipment equipment : assignedEquipment) {
			equipment.setAvailable(true);
		}
	}

	/**
	 * my logic for creating staff for my hospital
	 */

	private void initializeStaff() {
		staffList.add(new Staff(1, "Smith", "Doctor"));
		staffList.add(new Staff(2, "Johnson", "Doctor"));
		staffList.add(new Staff(3, "Jane", "Nurse"));
	}// end initialize staff

	/**
	 * my logic for creating rooms in my hospital
	 */

	private void initializeRooms() {
		rooms.add(new Room(101, "Emergency"));
		rooms.add(new Room(102, "Surgery"));
		rooms.add(new Room(103, "General"));

	}// end initializeRooms

	/**
	 * my logic for creating equipment for my hospital
	 */
	private void initializeEquipment() {
		equipment.add(new Equipment(1, "Ventalator"));
		equipment.add(new Equipment(1, "Defibrillator"));
		equipment.add(new Equipment(1, "Stethoscope"));

	}// end initializeEquipment

	/**
	 * simulates a type of treatment based on the patients priority
	 * 
	 * @param patient input that you want to receive treatment
	 */

	public void simulateTreatment(Patient patient) {
		System.out.println("Simulating treatment for Patient ID: " + patient.getId());

		int priority = patient.getPriority();
		if (priority >= 10) {
			System.out.println("Patient " + patient.getId() + " is receiving urgent care.");

		} else if (priority >= 8) {
			System.out.println("Patient " + patient.getId() + " is receiving intensive care.");

		} else {
			System.out.println("Patient " + patient.getId() + " is receiving general care.");

		}

	}// end simulateTreatment

	/**
	 * My logic to discharge a patient from the hospital
	 * 
	 * @param patient input that you want discharged
	 */

	public void dischargePatient(Patient patient) {
		if (patients.contains(patient)) {
			patients.remove(patient);
			System.out.println("Patient ID: " + patient.getId() + " has been discharged.");
			deallocateResources(patient);

		} else {
			System.out.println("Patient ID: " + patient.getId() + " not found in the hospital.");
		}
	}// end dischargePatient

}// end class
