 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class user_inyange {

    public JFrame frame;
    private JButton btnProfile;
    private JButton btnViewProposal;
    private JButton btnLogout;
    private JButton Distributors;
    private JButton Sales;
    private JButton Products;
    private JButton Orders;
    private JButton Users;
    private JButton btnFeedback;

    private JPanel tablePanel;
    private JPanel formPanel;
    private JLabel lblWelcome;

    private JTable table1;
    private JTable table12;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	user_inyange window = new user_inyange();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public user_inyange() {
        initialize();
        connection();
        table1 = new JTable();
    }

    Connection con;
    PreparedStatement pst;

    void connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/votting_system", "root", "");
            System.out.print("Connected well");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1050, 733);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel topBarPanel = new JPanel();
        topBarPanel.setBackground(Color.BLUE);
        topBarPanel.setBounds(0, 0, 1050, 50);
        frame.getContentPane().add(topBarPanel);
        topBarPanel.setLayout(null);

        lblWelcome = new JLabel("INYANGE MANAGEMENT SYSTEM");
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Verdana", Font.BOLD, 16));
        lblWelcome.setBounds(0, 0, 1050, 50);
        topBarPanel.add(lblWelcome);

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBackground(new Color(0, 128, 0));
        sidebarPanel.setBounds(0, 50, 200, 700);
        frame.getContentPane().add(sidebarPanel);
        sidebarPanel.setLayout(null);

        JLabel lblHomepage = new JLabel("BISTRIBUTER PAGE");
        lblHomepage.setForeground(Color.WHITE);
        lblHomepage.setHorizontalAlignment(SwingConstants.CENTER);
        lblHomepage.setFont(new Font("Verdana", Font.BOLD, 19));
        lblHomepage.setBounds(0, 0, 200, 28);
        sidebarPanel.add(lblHomepage);

        btnProfile = new JButton("PROFILE");
        btnProfile.setFont(new Font("Verdana", Font.BOLD, 14));
        btnProfile.setBounds(0, 50, 200, 40);
        btnProfile.setOpaque(true);
        btnProfile.setBackground(new Color(0, 128, 0));
        btnProfile.setBorderPainted(false);
        btnProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        sidebarPanel.add(btnProfile);

        btnViewProposal = new JButton("Add New Announcements");
        btnViewProposal.setFont(new Font("Verdana", Font.BOLD, 14));
        btnViewProposal.setBounds(0, 100, 200, 40);
        btnViewProposal.setOpaque(true);
        btnViewProposal.setBackground(new Color(0, 128, 0));
        btnViewProposal.setBorderPainted(false);
        btnViewProposal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Announcements sales_page_ = new Announcements();
                sales_page_.frame.setVisible(true);
                frame.dispose(); // Close the login window

            	
            }
        });
        sidebarPanel.add(btnViewProposal);

        Distributors = new JButton("Distributors");
        Distributors.setFont(new Font("Verdana", Font.BOLD, 14));
        Distributors.setBounds(0, 150, 200, 40);
        Distributors.setOpaque(true);
        Distributors.setBackground(new Color(0, 128, 0));
        Distributors.setBorderPainted(false);
        Distributors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	distributers_page sales_page_ = new distributers_page();
                sales_page_.frame.setVisible(true);
                frame.dispose(); // Close the login window

            }
        });
        sidebarPanel.add(Distributors);

        Sales = new JButton("Sales");
        Sales.setFont(new Font("Verdana", Font.BOLD, 14));
        Sales.setBounds(0, 200, 200, 40);
        Sales.setOpaque(true);
        Sales.setBackground(new Color(0, 128, 0));
        Sales.setBorderPainted(false);
        Sales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hide form panel
            	distr_sales sales_page_ = new distr_sales();
                sales_page_.frame.setVisible(true);
                frame.dispose(); // Close the login window

            }
        });
        sidebarPanel.add(Sales);

        Products = new JButton("Stock");
        Products.setFont(new Font("Verdana", Font.BOLD, 14));
        Products.setBounds(0, 250, 200, 40);
        Products.setOpaque(true);
        Products.setBackground(new Color(0, 128, 0));
        Products.setBorderPainted(false);
        Products.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                distr_stock sales_page_ = new distr_stock();
                sales_page_.frame.setVisible(true);
                frame.dispose(); // Close the login window

            }
        });
        sidebarPanel.add(Products);

        Orders = new JButton("Orders");
        Orders.setFont(new Font("Verdana", Font.BOLD, 14));
        Orders.setBounds(0, 300, 200, 40);
        Orders.setOpaque(true);
        Orders.setBackground(new Color(0, 128, 0));
        Orders.setBorderPainted(false);
        Orders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oders_page_distr usersPage = new oders_page_distr();
                usersPage.frame.setVisible(true);
                frame.dispose(); // Close the current window

            }
        });
        sidebarPanel.add(Orders);

        Users = new JButton("Clients");
        Users.setFont(new Font("Verdana", Font.BOLD, 14));
        Users.setBounds(0, 350, 200, 40);
        Users.setOpaque(true);
        Users.setBackground(new Color(0, 128, 0));
        Users.setBorderPainted(false);
        Users.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the users_page
                clients usersPage = new clients();
                usersPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });

        sidebarPanel.add(Users);

        btnFeedback = new JButton("Feedback/Contact Admin");
        btnFeedback.setFont(new Font("Verdana", Font.BOLD, 14));
        btnFeedback.setBounds(0, 400, 200, 40);
        btnFeedback.setOpaque(true);
        btnFeedback.setBackground(new Color(0, 128, 0));
        btnFeedback.setBorderPainted(false);
        btnFeedback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	feedBack_page sales_page_ = new feedBack_page();
                sales_page_.frame.setVisible(true);
                frame.dispose(); // Close the login window

            }
        });
        sidebarPanel.add(btnFeedback);

        // Create a small space between the Feedback button and the Logout button
        JPanel spacePanel = new JPanel();
        spacePanel.setBounds(0, 450, 200, 20);
        spacePanel.setOpaque(false);
        sidebarPanel.add(spacePanel);

        // Add a logout button to the sidebar
        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Verdana", Font.BOLD, 14));
        btnLogout.setBounds(0, 470, 200, 40);
        btnLogout.setOpaque(true);
        btnLogout.setBackground(Color.RED);
        btnLogout.setBorderPainted(false);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	LogIn sales_page_ = new LogIn();
                sales_page_.frame.setVisible(true);
                frame.dispose(); // Close the login window

            }
        });
        sidebarPanel.add(btnLogout);

        // Create and add the three cards in the middle bar
        createCards();

        // Initially show the welcome message with the default username
        showWelcomeMessage("Username");
    }

    // Function to create cards in the middle bar
    private void createCards() {
        // Define the card size and position
        int cardWidth = 200;
        int cardHeight = 150;
        int cardX = 250;
        int cardY = 100;

        // Card 1: Sales
        JPanel salesCard = createCard("Sales", "Total Sales", "21");
        salesCard.setBounds(cardX, cardY, cardWidth, cardHeight);
        frame.getContentPane().add(salesCard);

        // Card 2: Products
        JPanel productsCard = createCard("Products", "Available Products", "50");
        productsCard.setBounds(cardX + cardWidth + 50, cardY, cardWidth, cardHeight);
        frame.getContentPane().add(productsCard);

        // Card 3: Stock
        JPanel stockCard = createCard("Stock", "Total Stock", "1000");
        stockCard.setBounds(cardX + (cardWidth + 50) * 2, cardY, cardWidth, cardHeight);
        frame.getContentPane().add(stockCard);
    }

    // Function to create a card with specified title, subtitle, and value
    private JPanel createCard(String title, String subtitle, String value) {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setPreferredSize(new Dimension(200, 150));
        cardPanel.setMaximumSize(new Dimension(200, 150));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        titleLabel.setBounds(10, 10, 150, 20);
        cardPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
        subtitleLabel.setBounds(10, 40, 150, 20);
        cardPanel.add(subtitleLabel);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Verdana", Font.BOLD, 36));
        valueLabel.setBounds(10, 70, 150, 50);
        cardPanel.add(valueLabel);

        // Round the borders of the card
        Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        return cardPanel;
    }

    private void showWelcomeMessage(String username) {
        lblWelcome.setText("INYANGE MANAGEMENT SYSTEM");
    }
}
