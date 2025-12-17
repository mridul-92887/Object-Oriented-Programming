class LibraryCard {
    private String studentId;
    private String borrowingHistory;
    private Student student;

    public LibraryCard(String studentId) {
        this.studentId = studentId;
        this.borrowingHistory = "";
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void addBorrowedBook(String bookTitle) {
        borrowingHistory += bookTitle + " ";
    }

    public void showLibraryCard() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Borrowing History: " + borrowingHistory);
        System.out.println("Belongs to: " + student.getName());
    }
}

class Student {
    private String name;
    private LibraryCard libraryCard;

    public Student(String name, LibraryCard libraryCard) {
        this.name = name;
        this.libraryCard = libraryCard;
        libraryCard.setStudent(this);
    }

    public String getName() {
        return name;
    }

    public LibraryCard getLibraryCard() {
        return libraryCard;
    }
}

class BookReservation {
    private String bookTitle;
    private String reservationDate;
    private String dueDate;
    private Student student;

    public BookReservation(String bookTitle, String reservationDate, String dueDate, Student student) {
        this.bookTitle = bookTitle;
        this.reservationDate = reservationDate;
        this.dueDate = dueDate;
        this.student = student;
        student.getLibraryCard().addBorrowedBook(bookTitle);
    }

    public void showReservation() {
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Reservation Date: " + reservationDate);
        System.out.println("Due Date: " + dueDate);
        System.out.println("Reserved by: " + student.getName());
    }
}

public class lab_54 {
    public static void main(String[] args) {

        LibraryCard card = new LibraryCard("CSE-221045");
        Student ayaan = new Student("Ayaan", card);

        BookReservation reservation =
                new BookReservation("Object Oriented Programming", "12-09-2025", "20-09-2025", ayaan);

        reservation.showReservation();
        ayaan.getLibraryCard().showLibraryCard();
    }
}
