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

public class InyangeAdmin {

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
                    InyangeAdmin window = new InyangeAdmin();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InyangeAdmin() {
        initialize();
        // connection(); // You can add your database connection here if needed
        // table1 = new JTable(); // This line seems unnecessary here
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1050, 733);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel topBarPanel = new JPanel();
        topBarPanel.setBackground(Color.BLUE);
        topBarPanel.setPreferredSize(new Dimension(1050, 50));
        frame.getContentPane().add(topBarPanel, BorderLayout.NORTH);
        topBarPanel.setLayout(new BorderLayout());

        lblWelcome = new JLabel("INYANGE MANAGEMENT SYSTEM");
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Verdana", Font.BOLD, 16));
        topBarPanel.add(lblWelcome, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        JPanel cardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        createCards(cardPanel);

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBackground(new Color(0, 128, 0));
        sidebarPanel.setPreferredSize(new Dimension(200, 683));
        mainPanel.add(sidebarPanel, BorderLayout.EAST);
        sidebarPanel.setLayout(new GridLayout(9, 1, 0, 10));

        btnProfile = new JButton("Profile");
        btnProfile.setFont(new Font("Verdana", Font.BOLD, 14));
        btnProfile.setOpaque(true);
        btnProfile.setBackground(new Color(0, 128, 0));
        btnProfile.setBorderPainted(false);
        btnProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfilePage profilePage = new ProfilePage();
                profilePage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(btnProfile);

        btnViewProposal = new JButton("Add New Announcements");
        btnViewProposal.setFont(new Font("Verdana", Font.BOLD, 14));
        btnViewProposal.setOpaque(true);
        btnViewProposal.setBackground(new Color(0, 128, 0));
        btnViewProposal.setBorderPainted(false);
        btnViewProposal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Announcements addAnnouncementPage = new Announcements();
                addAnnouncementPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(btnViewProposal);

        Distributors = new JButton("Distributors");
        Distributors.setFont(new Font("Verdana", Font.BOLD, 14));
        Distributors.setOpaque(true);
        Distributors.setBackground(new Color(0, 128, 0));
        Distributors.setBorderPainted(false);
        Distributors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	distributers_page distributorsPage = new distributers_page();
                distributorsPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(Distributors);

        Sales = new JButton("Sales");
        Sales.setFont(new Font("Verdana", Font.BOLD, 14));
        Sales.setOpaque(true);
        Sales.setBackground(new Color(0, 128, 0));
        Sales.setBorderPainted(false);
        Sales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	sales_page salesPage = new sales_page();
                salesPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(Sales);

        Products = new JButton("Products");
        Products.setFont(new Font("Verdana", Font.BOLD, 14));
        Products.setOpaque(true);
        Products.setBackground(new Color(0, 128, 0));
        Products.setBorderPainted(false);
        Products.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	product_page productsPage = new product_page();
                productsPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(Products);

        Orders = new JButton("Orders");
        Orders.setFont(new Font("Verdana", Font.BOLD, 14));
        Orders.setOpaque(true);
        Orders.setBackground(new Color(0, 128, 0));
        Orders.setBorderPainted(false);
        Orders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	oders_page ordersPage = new oders_page();
                ordersPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(Orders);

        Users = new JButton("Users");
        Users.setFont(new Font("Verdana", Font.BOLD, 14));
        Users.setOpaque(true);
        Users.setBackground(new Color(0, 128, 0));
        Users.setBorderPainted(false);
        Users.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	users_page usersPage = new users_page();
                usersPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(Users);

        btnFeedback = new JButton("Feedback");
        btnFeedback.setFont(new Font("Verdana", Font.BOLD, 14));
        btnFeedback.setOpaque(true);
        btnFeedback.setBackground(new Color(0, 128, 0));
        btnFeedback.setBorderPainted(false);
        btnFeedback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	feedBack_page feedbackPage = new feedBack_page();
                feedbackPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(btnFeedback);

        sidebarPanel.add(new JPanel()); // Add space panel

        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Verdana", Font.BOLD, 14));
        btnLogout.setOpaque(true);
        btnLogout.setBackground(Color.RED);
        btnLogout.setBorderPainted(false);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	LogIn loginPage = new LogIn();
                loginPage.frame.setVisible(true);
                frame.dispose(); // Close the current window
            }
        });
        sidebarPanel.add(btnLogout);
    }

    private void createCards(JPanel cardPanel) {
        JPanel salesCard = createCard("Sales", "Total Sales", "21");
        cardPanel.add(salesCard);

        JPanel productsCard = createCard("Products", "Available Products", "50");
        cardPanel.add(productsCard);

        JPanel stockCard = createCard("Stock", "Total Stock", "1000");
        cardPanel.add(stockCard);
    }

    private JPanel createCard(String title, String subtitle, String value) {
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setPreferredSize(new Dimension(200, 150));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout());
        cardPanel.add(contentPanel, BorderLayout.CENTER);

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(subtitleLabel, BorderLayout.NORTH);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Verdana", Font.BOLD, 36));
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(valueLabel, BorderLayout.CENTER);

        Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(roundedBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        return cardPanel;
    }
}

class ProfilePage {
    JFrame frame;

    public ProfilePage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JLabel lblProfile = new JLabel("Profile Page");
        lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
        lblProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(lblProfile, BorderLayout.CENTER);
    }
}

// Other page classes like AddAnnouncementPage, DistributorsPage, SalesPage, etc. follow the same pattern.
