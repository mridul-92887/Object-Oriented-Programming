import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class Book implements Serializable {
    int bookId;
    String name, author;
    int totalCopies, availableCopies;

    public Book(int bookId, String name, String author, int totalCopies) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }
}

public class ProfessionalLibraryGUI {

    static ArrayList<Book> books = new ArrayList<>();
    static final String FILE_NAME = "books.dat";
    static int nextBookId = 1;

    public static void main(String[] args) {
        loadBooks();

        JFrame frame = new JFrame("Library Management System");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center window
        frame.setUndecorated(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(245, 245, 245));

        // Header Panel
        JPanel header = new JPanel();
        header.setBounds(0, 0, 900, 80);
        header.setBackground(new Color(50, 115, 220));
        header.setLayout(null);
        JLabel title = new JLabel("Library Management System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setBounds(30, 20, 500, 40);
        header.add(title);
        mainPanel.add(header);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 80, 900, 70);
        buttonPanel.setBackground(new Color(230, 230, 230));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));

        String[] btnNames = {"Add Book", "Remove Book", "Issue Book", "Return Book", "Show Books"};
        Color[] btnColors = {
                new Color(52, 152, 219),
                new Color(231, 76, 60),
                new Color(46, 204, 113),
                new Color(241, 196, 15),
                new Color(155, 89, 182)
        };

        JButton[] buttons = new JButton[btnNames.length];
        for (int i = 0; i < btnNames.length; i++) {
            buttons[i] = new JButton(btnNames[i]);
            buttons[i].setBackground(btnColors[i]);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
            buttons[i].setFocusPainted(false);
            buttons[i].setPreferredSize(new Dimension(140, 40));
            buttons[i].setBorder(new RoundedBorder(15));
            buttonPanel.add(buttons[i]);
        }
        mainPanel.add(buttonPanel);

        // Table Panel
        String[] columns = {"Book ID", "Book Name", "Author", "Available Copies"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setGridColor(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 170, 830, 370);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(50, 115, 220), 2));
        mainPanel.add(scrollPane);

        frame.add(mainPanel);
        frame.setVisible(true);

        // ActionListeners
        // Add Book
        buttons[0].addActionListener(e -> {
            String name = JOptionPane.showInputDialog(frame, "Enter Book Name:");
            String author = JOptionPane.showInputDialog(frame, "Enter Author Name:");
            int copies;
            try {
                copies = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Number of Copies:"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid number!");
                return;
            }
            Book newBook = new Book(nextBookId++, name, author, copies);
            books.add(newBook);
            saveBooks();
            JOptionPane.showMessageDialog(frame, "Book added successfully!");
            refreshTable(tableModel);
        });

        // Remove Book
        buttons[1].addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter Book ID to remove:");
            int id;
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid ID!");
                return;
            }
            boolean removed = books.removeIf(b -> b.bookId == id);
            if (removed) {
                saveBooks();
                JOptionPane.showMessageDialog(frame, "Book removed!");
            } else {
                JOptionPane.showMessageDialog(frame, "Book not found!");
            }
            refreshTable(tableModel);
        });

        // Issue Book
        buttons[2].addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter Book ID to issue:");
            int id;
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid ID!");
                return;
            }
            Book book = books.stream().filter(b -> b.bookId == id).findFirst().orElse(null);
            if (book != null) {
                if (book.availableCopies > 0) {
                    book.availableCopies--;
                    saveBooks();
                    JOptionPane.showMessageDialog(frame, "Book issued successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "No copies available!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Book not found!");
            }
            refreshTable(tableModel);
        });

        // Return Book
        buttons[3].addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter Book ID to return:");
            int id;
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid ID!");
                return;
            }
            Book book = books.stream().filter(b -> b.bookId == id).findFirst().orElse(null);
            if (book != null) {
                if (book.availableCopies < book.totalCopies) {
                    book.availableCopies++;
                    saveBooks();
                    JOptionPane.showMessageDialog(frame, "Book returned successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "All copies already in library!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Book not found!");
            }
            refreshTable(tableModel);
        });

        // Show Books
        buttons[4].addActionListener(e -> refreshTable(tableModel));

        // Initial table load
        refreshTable(tableModel);
    }

    // Refresh table
    static void refreshTable(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        for (Book b : books) {
            tableModel.addRow(new Object[]{b.bookId, b.name, b.author, b.availableCopies});
        }
    }

    // Save books
    static void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load books
    static void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (ArrayList<Book>) ois.readObject();
            if (!books.isEmpty()) {
                nextBookId = books.get(books.size() - 1).bookId + 1;
            }
        } catch (IOException | ClassNotFoundException e) {
            books = new ArrayList<>();
        }
    }

    // Rounded button border
    static class RoundedBorder implements Border {
        private int radius;
        RoundedBorder(int radius) { this.radius = radius; }
        public Insets getBorderInsets(Component c) { return new Insets(this.radius+1,this.radius+1,this.radius+2,this.radius); }
        public boolean isBorderOpaque() { return true; }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
}
