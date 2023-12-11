import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * This is the main class for my hospital system application it will apply the
 * methods of my hospital system
 * 
 * @author Chase
 *
 */
public class HospitalSystemApp {
	/**
	 * Default
	 */
	HospitalSystemApp() {

	}

	/**
	 * The main method for running the application.
	 *
	 * @param args The command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		HospitalSystem hospitalSystem = new HospitalSystem();
		Scanner scanner = new Scanner(System.in);

		Queue<Patient> incomingPatients = new LinkedList<>();
		Queue<Patient> waitingPatients = new LinkedList<>();
		Queue<Patient> outgoingPatients = new LinkedList<>();

		System.out.println("Admitting patients. Enter patient details or type 'done' to finish admission:");
		while (true) {
			System.out.print("Enter patient name (or 'done'): ");
			String name = scanner.nextLine().trim();

			if (name.equalsIgnoreCase("done")) {
				break;
			}
			System.out.println("Is the patient in critical, severe, or moderate condition: ");
			String condition = scanner.nextLine().trim();

			Patient patient = new Patient(name, condition);
			incomingPatients.add(patient);
			System.out.println("Patient " + patient.getName() + " added to pending queue.");
		}

		System.out.println("Assigning rooms to pending patients...");
		while (!incomingPatients.isEmpty()) {
			Patient patient = incomingPatients.poll();
			System.out.println("Patient " + patient.getName() + " is Patient ID: " + patient.getId());

			hospitalSystem.allocateRoom(patient);

			Room assignedRoom = patient.getAssignedRoom();
			if (assignedRoom != null) {

				outgoingPatients.add(patient);
			} else {
				waitingPatients.add(patient);
			}

		}
		while (!outgoingPatients.isEmpty()) {
			Patient patient = outgoingPatients.poll();
			hospitalSystem.admitPatient(patient);
			hospitalSystem.assignStaffToPatient(patient);
			hospitalSystem.allocateEquipment(patient);
			hospitalSystem.simulateTreatment(patient);
			hospitalSystem.dischargePatient(patient);
		}

		while (!waitingPatients.isEmpty()) {
			Patient patient = waitingPatients.poll();
			hospitalSystem.allocateRoom(patient);

			Room assignedRoom = patient.getAssignedRoom();
			if (assignedRoom != null) {
				outgoingPatients.add(patient);
			} else {
				hospitalSystem.admitPatient(patient);
				System.out.println("Patient " + patient.getId()
						+ " is being transport to different hosptial cause there is no room here");
				hospitalSystem.dischargePatient(patient);
			}

		}
		while (!outgoingPatients.isEmpty()) {
			Patient patient = outgoingPatients.poll();
			hospitalSystem.admitPatient(patient);
			hospitalSystem.assignStaffToPatient(patient);
			hospitalSystem.allocateEquipment(patient);
			hospitalSystem.simulateTreatment(patient);
			hospitalSystem.dischargePatient(patient);

		}

	}// end main
}// end class
