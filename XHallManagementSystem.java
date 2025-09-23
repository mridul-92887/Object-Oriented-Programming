import java.io.*;
import java.util.*;

class ConsoleColors {
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String BLUE_BOLD = "\033[1;34m";
}

class Student {
    String name, id, department, bloodGroup, phone, email, room;

    Student(String name, String id, String department, String bloodGroup,String phone, String email, String room) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.email = email;
        this.room = room;
    }
}

class Room {
    String roomNo;
    int capacity;
    int occupied;

    Room(String roomNo, int capacity) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.occupied = 0;
    }
}

class WaitingStudent {
    String name, id, requestedRoom;

    WaitingStudent(String name, String id, String requestedRoom) {
        this.name = name;
        this.id = id;
        this.requestedRoom = requestedRoom;
    }
}

public class XHallManagementSystem {

    private static final String ADMIN_EMAIL = "mridul.92887@gmail.com";
    private static final String ADMIN_PASSWORD = "mridul+++";
    private static final String CEO_EMAIL = "ceo@hostel.com";
    private static final String CEO_PASSWORD = "ceo123";

    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static LinkedList<WaitingStudent> waitingQueue = new LinkedList<>();
    private static Stack<String> actionLog = new Stack<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        loadFromFile();

        int userType = authenticateUser();
        if (userType == 1) {
            mainMenu();
        } else if (userType == 2) {
            ceoMenu();
        }

        saveToFile();
        System.out.println(ConsoleColors.YELLOW + "System exited. Goodbye!" + ConsoleColors.RESET);
    }

    private static int authenticateUser() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.println(ConsoleColors.BLUE_BOLD + "\n===== HOSTEL MANAGEMENT LOGIN =====" + ConsoleColors.RESET);
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
                System.out.println(ConsoleColors.GREEN + "Admin login successful!" + ConsoleColors.RESET);
                return 1;
            } else if (email.equals(CEO_EMAIL) && password.equals(CEO_PASSWORD)) {
                System.out.println(ConsoleColors.GREEN + "CEO login successful!" + ConsoleColors.RESET);
                return 2;
            } else {
                attempts++;
                System.out.println(ConsoleColors.RED + "Wrong email or password! Try again." + ConsoleColors.RESET);
            }
        }
        System.out.println(ConsoleColors.RED + "Too many failed attempts. Exiting..." + ConsoleColors.RESET);
        System.exit(0);
        return 0;
    }

    private static void initializeRooms() {
        String[] roomNumbers = { "101", "102", "103", "104", "105" };
        for (String rn : roomNumbers) {
            rooms.add(new Room(rn, 4));
        }
    }

    private static void mainMenu() {
        int choice;
        do {
            System.out.println(ConsoleColors.BLUE_BOLD + "\n===== HALL MANAGEMENT SYSTEM =====" + ConsoleColors.RESET);
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Modify Student");
            System.out.println("6. Allocate Room");
            System.out.println("7. Vacate Room");
            System.out.println("8. Room Occupancy");
            System.out.println("9. Recent Actions");
            System.out.println("10. Generate Report");
            System.out.println("11. View Waiting List");
            System.out.println("12. Exit");
            System.out.print(ConsoleColors.YELLOW + "Enter choice: " + ConsoleColors.RESET);
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> removeStudent();
                case 5 -> modifyStudent();
                case 6 -> allocateRoom();
                case 7 -> vacateRoom();
                case 8 -> roomOccupancy();
                case 9 -> showRecentActions();
                case 10 -> generateReport();
                case 11 -> showWaitingList();
                case 12 -> System.out.println(ConsoleColors.YELLOW + "Exiting..." + ConsoleColors.RESET);
                default -> System.out.println(ConsoleColors.RED + "Invalid choice!" + ConsoleColors.RESET);
            }
        } while (choice != 12);
    }

    private static void ceoMenu() {
        int choice;
        do {
            System.out.println(ConsoleColors.PURPLE + "\n===== CEO CONTROL PANEL =====" + ConsoleColors.RESET);
            System.out.println("1. Add Student (Override)");
            System.out.println("2. Remove Student (Override)");
            System.out.println("3. Force Room Changes");
            System.out.println("4. View All System Logs");
            System.out.println("5. Go to Admin Menu"); // New option
            System.out.println("6. Exit CEO Mode");
            System.out.print(ConsoleColors.YELLOW + "Enter choice: " + ConsoleColors.RESET);
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> ceoAddStudent();
                case 2 -> ceoRemoveStudent();
                case 3 -> forceRoomChanges();
                case 4 -> viewAllLogs();
                case 5 -> mainMenu(); // CEO can access admin menu
                case 6 -> System.out.println(ConsoleColors.YELLOW + "Exiting CEO Mode..." + ConsoleColors.RESET);
                default -> System.out.println(ConsoleColors.RED + "Invalid choice!" + ConsoleColors.RESET);
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.println(ConsoleColors.BLUE_BOLD + "\nEnter student details:" + ConsoleColors.RESET);
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Department: ");
        String dept = sc.nextLine();
        System.out.print("Blood Group: ");
        String bg = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        printAvailableRooms();
        System.out.print("Enter room number (or leave blank for auto-allocation): ");
        String roomChoice = sc.nextLine();

        String assignedRoom = "Not Allocated";
        if (!roomChoice.isEmpty()) {
            if (isRoomAvailable(roomChoice)) {
                assignedRoom = roomChoice;
                incrementRoomOccupancy(roomChoice);
            } else {
                System.out.println(ConsoleColors.RED + "Room not available. Auto-assigning..." + ConsoleColors.RESET);
                Room available = findAvailableRoom();
                if (available != null) {
                    assignedRoom = available.roomNo;
                    available.occupied++;
                }
            }
        } else {
            Room available = findAvailableRoom();
            if (available != null) {
                assignedRoom = available.roomNo;
                available.occupied++;
            }
        }

        Student s = new Student(name, id, dept, bg, phone, email, assignedRoom);
        students.add(s);
        actionLog.push("Added student: " + name);
        System.out.println(ConsoleColors.GREEN + "Student added successfully!" + ConsoleColors.RESET);
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println(ConsoleColors.RED + "No students in the system!" + ConsoleColors.RESET);
            return;
        }
        System.out.println(ConsoleColors.BLUE_BOLD + "\n===== ALL STUDENTS =====" + ConsoleColors.RESET);
        System.out.printf(ConsoleColors.CYAN + "%-10s %-25s %-15s %-10s\n" + ConsoleColors.RESET, "ID", "NAME", "PHONE", "ROOM");
        for (Student s : students) {
            System.out.printf("%-10s %-25s %-15s %-10s\n", s.id, s.name, s.phone, s.room);
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.id.equals(id)) {
                printStudentDetails(s);
                return;
            }
        }
        System.out.println(ConsoleColors.RED + "Student not found!" + ConsoleColors.RESET);
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        String id = sc.nextLine();
        Student toRemove = null;
        for (Student s : students) {
            if (s.id.equals(id)) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            if (!toRemove.room.equals("Not Allocated"))
                decrementRoomOccupancy(toRemove.room);
            students.remove(toRemove);
            actionLog.push("Removed student: " + toRemove.name);
            System.out.println(ConsoleColors.GREEN + "Student removed successfully!" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.RED + "Student not found!" + ConsoleColors.RESET);
        }
    }

    private static void modifyStudent() {
        System.out.print("Enter student ID to modify: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.id.equals(id)) {
                System.out.print("New name (leave blank to keep current): ");
                String name = sc.nextLine();
                if (!name.isEmpty())
                    s.name = name;
                System.out.print("New department: ");
                String dept = sc.nextLine();
                if (!dept.isEmpty())
                    s.department = dept;
                System.out.print("New blood group: ");
                String bg = sc.nextLine();
                if (!bg.isEmpty())
                    s.bloodGroup = bg;
                System.out.print("New phone: ");
                String phone = sc.nextLine();
                if (!phone.isEmpty())
                    s.phone = phone;
                System.out.print("New email: ");
                String email = sc.nextLine();
                if (!email.isEmpty())
                    s.email = email;
                actionLog.push("Modified student: " + s.name);
                System.out.println(ConsoleColors.GREEN + "Student updated!" + ConsoleColors.RESET);
                return;
            }
        }
        System.out.println(ConsoleColors.RED + "Student not found!" + ConsoleColors.RESET);
    }

    private static void allocateRoom() {
        System.out.print("Enter student ID to allocate room: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.id.equals(id)) {
                if (!s.room.equals("Not Allocated")) {
                    System.out.println(ConsoleColors.RED + "Room already allocated!" + ConsoleColors.RESET);
                    return;
                }
                printAvailableRooms();
                System.out.print("Enter room number to allocate: ");
                String roomNo = sc.nextLine();
                if (isRoomAvailable(roomNo)) {
                    s.room = roomNo;
                    incrementRoomOccupancy(roomNo);
                    System.out.println(ConsoleColors.GREEN + "Room allocated successfully!" + ConsoleColors.RESET);
                    actionLog.push("Allocated room " + roomNo + " to " + s.name);
                } else {
                    System.out.println(ConsoleColors.RED + "Room full. Added to waiting list." + ConsoleColors.RESET);
                    waitingQueue.add(new WaitingStudent(s.name, s.id, roomNo));
                    actionLog.push("Added to waiting list: " + s.name);
                }
                return;
            }
        }
        System.out.println(ConsoleColors.RED + "Student not found!" + ConsoleColors.RESET);
    }

    private static void vacateRoom() {
        System.out.print("Enter student ID to vacate room: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.id.equals(id)) {
                if (s.room.equals("Not Allocated")) {
                    System.out.println(ConsoleColors.RED + "No room allocated!" + ConsoleColors.RESET);
                    return;
                }
                String vacatedRoom = s.room;
                s.room = "Not Allocated";
                decrementRoomOccupancy(vacatedRoom);
                System.out.println(ConsoleColors.GREEN + "Room vacated successfully!" + ConsoleColors.RESET);
                actionLog.push("Vacated room " + vacatedRoom + " from " + s.name);

                Iterator<WaitingStudent> it = waitingQueue.iterator();
                while (it.hasNext()) {
                    WaitingStudent ws = it.next();
                    if (ws.requestedRoom.equals(vacatedRoom)) {
                        for (Student st : students) {
                            if (st.id.equals(ws.id)) {
                                st.room = vacatedRoom;
                                incrementRoomOccupancy(vacatedRoom);
                                System.out.println(ConsoleColors.GREEN + "Automatically allocated " + vacatedRoom + " to " + st.name + ConsoleColors.RESET);
                                actionLog.push("Auto-allocated room " + vacatedRoom + " to " + st.name);
                                it.remove();
                                break;
                            }
                        }
                        break;
                    }
                }
                return;
            }
        }
        System.out.println(ConsoleColors.RED + "Student not found!" + ConsoleColors.RESET);
    }

    private static void roomOccupancy() {
        System.out.println(ConsoleColors.PURPLE + "\n===== ROOM OCCUPANCY =====" + ConsoleColors.RESET);
        System.out.printf("%-10s %-10s %-10s\n", "Room", "Occupied", "Available");
        for (Room r : rooms) {
            System.out.printf("%-10s %-10d %-10d\n", r.roomNo, r.occupied, r.capacity - r.occupied);
        }
    }

    private static void showRecentActions() {
        System.out.println(ConsoleColors.YELLOW + "\n===== RECENT ACTIONS =====" + ConsoleColors.RESET);
        int count = 0;
        ListIterator<String> it = actionLog.listIterator(actionLog.size());
        while (it.hasPrevious() && count < 5) {
            System.out.println(ConsoleColors.CYAN + "- " + it.previous() + ConsoleColors.RESET);
            count++;
        }
    }

    private static void showWaitingList() {
        System.out.println(ConsoleColors.BLUE + "\n===== WAITING LIST =====" + ConsoleColors.RESET);
        for (WaitingStudent ws : waitingQueue) {
            System.out.println(ConsoleColors.CYAN + ws.name + " (ID: " + ws.id + ") waiting for " + ws.requestedRoom + ConsoleColors.RESET);
        }
    }

    private static void generateReport() {
        try (PrintWriter pw = new PrintWriter("hall_report.txt")) {
            pw.println("ID\tName\tRoom\tDepartment");
            for (Student s : students) {
                pw.println(s.id + "\t" + s.name + "\t" + s.room + "\t" + s.department);
            }
            actionLog.push("Generated report");
            System.out.println(ConsoleColors.GREEN + "Report generated as hall_report.txt" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Error generating report!" + ConsoleColors.RESET);
        }
    }

    private static void ceoAddStudent() {
        System.out.println(ConsoleColors.BLUE_BOLD + "\n===== CEO ADD STUDENT =====" + ConsoleColors.RESET);
        addStudent(); // Can override room allocation if needed
        actionLog.push("CEO added student");
    }

    private static void ceoRemoveStudent() {
        System.out.println(ConsoleColors.BLUE_BOLD + "\n===== CEO REMOVE STUDENT =====" + ConsoleColors.RESET);
        removeStudent(); // CEO can remove anyone
        actionLog.push("CEO removed student");
    }

    private static void forceRoomChanges() {
        System.out.print("Enter old room number: ");
        String oldRoom = sc.nextLine();
        System.out.print("Enter new room number: ");
        String newRoom = sc.nextLine();
        int moved = 0;
        for (Student s : students) {
            if (s.room.equals(oldRoom)) {
                s.room = newRoom;
                moved++;
            }
        }
        for (Room r : rooms) {
            if (r.roomNo.equals(oldRoom))
                r.occupied -= moved;
            if (r.roomNo.equals(newRoom))
                r.occupied += moved;
        }
        actionLog.push("CEO forced room change from " + oldRoom + " to " + newRoom);
        System.out.println(ConsoleColors.GREEN + moved + " students moved." + ConsoleColors.RESET);
    }

    private static void viewAllLogs() {
        System.out.println(ConsoleColors.PURPLE + "\n===== SYSTEM LOG =====" + ConsoleColors.RESET);
        for (String log : actionLog) {
            System.out.println(ConsoleColors.CYAN + log + ConsoleColors.RESET);
        }
    }

    private static void printAvailableRooms() {
        System.out.println(ConsoleColors.PURPLE + "\n===== AVAILABLE ROOMS =====" + ConsoleColors.RESET);
        for (Room r : rooms) {
            if (r.occupied < r.capacity) {
                System.out.println(ConsoleColors.GREEN + r.roomNo + " - " + r.occupied + "/" + r.capacity + " occupied" + ConsoleColors.RESET);
            } else {
                System.out.println(ConsoleColors.RED + r.roomNo + " - FULL" + ConsoleColors.RESET);
            }
        }
    }

    private static Room findAvailableRoom() {
        for (Room r : rooms) {
            if (r.occupied < r.capacity)
                return r;
        }
        return null;
    }

    private static boolean isRoomAvailable(String roomNo) {
        for (Room r : rooms) {
            if (r.roomNo.equals(roomNo) && r.occupied < r.capacity)
                return true;
        }
        return false;
    }

    private static void incrementRoomOccupancy(String roomNo) {
        for (Room r : rooms) {
            if (r.roomNo.equals(roomNo))
                r.occupied++;
        }
    }

    private static void decrementRoomOccupancy(String roomNo) {
        for (Room r : rooms) {
            if (r.roomNo.equals(roomNo))
                r.occupied--;
        }
    }

    private static void printStudentDetails(Student s) {
        System.out.println(ConsoleColors.BLUE_BOLD + "===== STUDENT DETAILS =====" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "ID: " + ConsoleColors.RESET + s.id);
        System.out.println(ConsoleColors.GREEN + "Name: " + ConsoleColors.RESET + s.name);
        System.out.println(ConsoleColors.GREEN + "Department: " + ConsoleColors.RESET + s.department);
        System.out.println(ConsoleColors.GREEN + "Blood Group: " + ConsoleColors.RESET + s.bloodGroup);
        System.out.println(ConsoleColors.GREEN + "Phone: " + ConsoleColors.RESET + s.phone);
        System.out.println(ConsoleColors.GREEN + "Email: " + ConsoleColors.RESET + s.email);
        System.out.println(ConsoleColors.GREEN + "Room: " + ConsoleColors.RESET + s.room);
    }

    private static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                pw.println(String.join(",", s.name, s.id, s.department, s.bloodGroup, s.phone, s.email, s.room));
            }
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED + "Error saving student data." + ConsoleColors.RESET);
        }
    }

    private static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    students.add(new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]));
                }
            }
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED + "No saved data found. Starting fresh." + ConsoleColors.RESET);
        }
    }
}
