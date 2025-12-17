interface Notification {
    void meetingReminder();
    void taskUpdate();
    void securityAlert();
}

abstract class Employee {
    protected String name;
    protected int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    abstract void accessOffice();
}

class Manager extends Employee implements Notification {

    public Manager(String name, int employeeId) {
        super(name, employeeId);
    }

    @Override
    void accessOffice() {
        System.out.println(name + " is accessing the office with full privileges.");
    }

    @Override
    public void meetingReminder() {
        System.out.println("Meeting Reminder sent by Manager " + name);
    }

    @Override
    public void taskUpdate() {
        System.out.println("Task Update notification sent by Manager " + name);
    }

    @Override
    public void securityAlert() {
        System.out.println("Security Alert issued by Manager " + name);
    }
}

public class lab_56 {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 1001);

        manager.accessOffice();

        Notification notify = (Notification) manager;
        notify.meetingReminder();
        notify.taskUpdate();
        notify.securityAlert();
    }
}
