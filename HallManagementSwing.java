import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HallManagementSwing {

    private JFrame frame;
    private JPanel menuPanel, actionPanel;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Room> rooms = new ArrayList<>();
    private LinkedList<WaitingStudent> waitingQueue = new LinkedList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HallManagementSwing().createGUI());
    }

    private void createGUI() {
        frame = new JFrame("Hall Management System");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        initializeRooms();

        // Menu Panel (Left)
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1, 10, 10));
        menuPanel.setBackground(new Color(30, 30, 60));

        JButton addBtn = new JButton("Add Student");
        JButton displayBtn = new JButton("Display Students");
        JButton modifyBtn = new JButton("Modify Student");
        JButton removeBtn = new JButton("Remove Student");
        JButton allocateBtn = new JButton("Allocate Room");
        JButton vacateBtn = new JButton("Vacate Room");
        JButton waitingBtn = new JButton("View Waiting List");

        // Button Colors
        JButton[] buttons = {addBtn, displayBtn, modifyBtn, removeBtn, allocateBtn, vacateBtn, waitingBtn};
        for (JButton btn : buttons) {
            btn.setBackground(new Color(70, 130, 180));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            menuPanel.add(btn);
        }

        // Action Panel (Center)
        actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.setBackground(new Color(230, 230, 250));

        // Table for students
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Department", "Blood Group", "Phone", "Email", "Room"}, 0);
        studentTable = new JTable(tableModel);
        studentTable.setFont(new Font("Arial", Font.PLAIN, 14));
        studentTable.setRowHeight(25);
        actionPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // Button Actions
        addBtn.addActionListener(e -> showAddStudentDialog());
        displayBtn.addActionListener(e -> refreshStudentTable());
        modifyBtn.addActionListener(e -> showModifyStudentDialog());
        removeBtn.addActionListener(e -> showRemoveStudentDialog());
        allocateBtn.addActionListener(e -> showAllocateRoomDialog());
        vacateBtn.addActionListener(e -> showVacateRoomDialog());
        waitingBtn.addActionListener(e -> showWaitingListDialog());

        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(actionPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void initializeRooms() {
        String[] roomNumbers = {"101", "102", "103", "104", "105"};
        for (String rn : roomNumbers) {
            rooms.add(new Room(rn, 4));
        }
    }

    private void showAddStudentDialog() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField bgField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField roomField = new JTextField();

        Object[] message = {
                "ID:", idField,
                "Name:", nameField,
                "Department:", deptField,
                "Blood Group:", bgField,
                "Phone:", phoneField,
                "Email:", emailField,
                "Room (Optional):", roomField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String assignedRoom = roomField.getText().isEmpty() ? autoAllocateRoom() : roomField.getText();
            if (!isRoomAvailable(assignedRoom)) {
                JOptionPane.showMessageDialog(frame, "Room full. Added to waiting list.");
                waitingQueue.add(new WaitingStudent(nameField.getText(), idField.getText(), assignedRoom));
                assignedRoom = "Not Allocated";
            } else {
                incrementRoomOccupancy(assignedRoom);
            }
            Student s = new Student(nameField.getText(), idField.getText(), deptField.getText(), bgField.getText(), phoneField.getText(), emailField.getText(), assignedRoom);
            students.add(s);
            refreshStudentTable();
        }
    }

    private void refreshStudentTable() {
        tableModel.setRowCount(0);
        for (Student s : students) {
            tableModel.addRow(new Object[]{s.id, s.name, s.department, s.bloodGroup, s.phone, s.email, s.room});
        }
    }

    private void showModifyStudentDialog() {
        String id = JOptionPane.showInputDialog(frame, "Enter Student ID to modify:");
        for (Student s : students) {
            if (s.id.equals(id)) {
                JTextField nameField = new JTextField(s.name);
                JTextField deptField = new JTextField(s.department);
                JTextField bgField = new JTextField(s.bloodGroup);
                JTextField phoneField = new JTextField(s.phone);
                JTextField emailField = new JTextField(s.email);

                Object[] message = {
                        "Name:", nameField,
                        "Department:", deptField,
                        "Blood Group:", bgField,
                        "Phone:", phoneField,
                        "Email:", emailField
                };

                int option = JOptionPane.showConfirmDialog(frame, message, "Modify Student", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    s.name = nameField.getText();
                    s.department = deptField.getText();
                    s.bloodGroup = bgField.getText();
                    s.phone = phoneField.getText();
                    s.email = emailField.getText();
                    refreshStudentTable();
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Student not found!");
    }

    private void showRemoveStudentDialog() {
        String id = JOptionPane.showInputDialog(frame, "Enter Student ID to remove:");
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.id.equals(id)) {
                if (!s.room.equals("Not Allocated")) decrementRoomOccupancy(s.room);
                it.remove();
                refreshStudentTable();
                JOptionPane.showMessageDialog(frame, "Student removed!");
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Student not found!");
    }

    private void showAllocateRoomDialog() {
        String id = JOptionPane.showInputDialog(frame, "Enter Student ID to allocate room:");
        for (Student s : students) {
            if (s.id.equals(id)) {
                if (!s.room.equals("Not Allocated")) {
                    JOptionPane.showMessageDialog(frame, "Room already allocated!");
                    return;
                }
                String roomNo = JOptionPane.showInputDialog(frame, "Enter Room Number to allocate:");
                if (!isRoomAvailable(roomNo)) {
                    JOptionPane.showMessageDialog(frame, "Room full. Added to waiting list.");
                    waitingQueue.add(new WaitingStudent(s.name, s.id, roomNo));
                    return;
                }
                s.room = roomNo;
                incrementRoomOccupancy(roomNo);
                refreshStudentTable();
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Student not found!");
    }

    private void showVacateRoomDialog() {
        String id = JOptionPane.showInputDialog(frame, "Enter Student ID to vacate room:");
        for (Student s : students) {
            if (s.id.equals(id)) {
                if (s.room.equals("Not Allocated")) {
                    JOptionPane.showMessageDialog(frame, "No room allocated!");
                    return;
                }
                String vacatedRoom = s.room;
                s.room = "Not Allocated";
                decrementRoomOccupancy(vacatedRoom);

                // Auto-allocate from waiting list
                Iterator<WaitingStudent> wit = waitingQueue.iterator();
                while (wit.hasNext()) {
                    WaitingStudent ws = wit.next();
                    if (ws.requestedRoom.equals(vacatedRoom)) {
                        for (Student st : students) {
                            if (st.id.equals(ws.id)) {
                                st.room = vacatedRoom;
                                incrementRoomOccupancy(vacatedRoom);
                                wit.remove();
                                break;
                            }
                        }
                        break;
                    }
                }

                refreshStudentTable();
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Student not found!");
    }

    private void showWaitingListDialog() {
        StringBuilder sb = new StringBuilder();
        for (WaitingStudent ws : waitingQueue) {
            sb.append(ws.name).append(" (ID: ").append(ws.id).append(") waiting for ").append(ws.requestedRoom).append("\n");
        }
        if (sb.length() == 0) sb.append("No students in waiting list.");
        JOptionPane.showMessageDialog(frame, sb.toString(), "Waiting List", JOptionPane.INFORMATION_MESSAGE);
    }

    // Room Methods
    private boolean isRoomAvailable(String roomNo) {
        for (Room r : rooms) if (r.roomNo.equals(roomNo) && r.occupied < r.capacity) return true;
        return false;
    }

    private void incrementRoomOccupancy(String roomNo) {
        for (Room r : rooms) if (r.roomNo.equals(roomNo)) r.occupied++;
    }

    private void decrementRoomOccupancy(String roomNo) {
        for (Room r : rooms) if (r.roomNo.equals(roomNo)) r.occupied--;
    }

    private String autoAllocateRoom() {
        for (Room r : rooms) if (r.occupied < r.capacity) return r.roomNo;
        return "Not Allocated";
    }

    // Classes
    class Student {
        String name, id, department, bloodGroup, phone, email, room;
        Student(String name, String id, String department, String bloodGroup, String phone, String email, String room) {
            this.name = name; this.id = id; this.department = department;
            this.bloodGroup = bloodGroup; this.phone = phone; this.email = email; this.room = room;
        }
    }

    class Room {
        String roomNo; int capacity; int occupied;
        Room(String roomNo, int capacity) { this.roomNo = roomNo; this.capacity = capacity; this.occupied = 0; }
    }

    class WaitingStudent {
        String name, id, requestedRoom;
        WaitingStudent(String name, String id, String requestedRoom) { this.name = name; this.id = id; this.requestedRoom = requestedRoom; }
    }
}
