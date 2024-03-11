import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INYANGEuser {

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
                    INYANGEuser window = new INYANGEuser();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public INYANGEuser() {
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

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBackground(new Color(0, 128, 0));
        sidebarPanel.setPreferredSize(new Dimension(200, 0));
        contentPanel.add(sidebarPanel, BorderLayout.WEST);
        sidebarPanel.setLayout(new GridLayout(10, 1, 0, 10));

        JLabel lblHomepage = new JLabel("BISTRIBUTER PAGE");
        lblHomepage.setForeground(Color.WHITE);
        lblHomepage.setHorizontalAlignment(SwingConstants.CENTER);
        lblHomepage.setFont(new Font("Verdana", Font.BOLD, 19));
        sidebarPanel.add(lblHomepage);

        btnProfile = new JButton("PROFILE");
        btnProfile.setFont(new Font("Verdana", Font.BOLD, 14));
        btnProfile.setForeground(Color.WHITE);
        btnProfile.setBackground(new Color(0, 128, 0));
        btnProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfilePage profilePage = new ProfilePage();
                profilePage.frame.setVisible(true);
            }
        });
        sidebarPanel.add(btnProfile);

        btnViewProposal = new JButton("Add New Announcements");
        btnViewProposal.setFont(new Font("Verdana", Font.BOLD, 14));
        btnViewProposal.setForeground(Color.WHITE);
        btnViewProposal.setBackground(new Color(0, 128, 0));
        btnViewProposal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Announcements announcements = new Announcements();
                announcements.frame.setVisible(true);
            }
        });
        sidebarPanel.add(btnViewProposal);

        Distributors = new JButton("Distributors");
        Distributors.setFont(new Font("Verdana", Font.BOLD, 14));
        Distributors.setForeground(Color.WHITE);
        Distributors.setBackground(new Color(0, 128, 0));
        Distributors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	distr_sales distributorsPage = new distr_sales();
                distributorsPage.frame.setVisible(true);
            }
        });
        sidebarPanel.add(Distributors);

        Sales = new JButton("Sales");
        Sales.setFont(new Font("Verdana", Font.BOLD, 14));
        Sales.setForeground(Color.WHITE);
        Sales.setBackground(new Color(0, 128, 0));
        Sales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	distr_sales salesPage = new distr_sales();
                salesPage.frame.setVisible(true);
            }
        });
        sidebarPanel.add(Sales);

        Products = new JButton("Stock");
        Products.setFont(new Font("Verdana", Font.BOLD, 14));
        Products.setForeground(Color.WHITE);
        Products.setBackground(new Color(0, 128, 0));
        Products.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	distr_stock stockPage = new distr_stock();
                stockPage.frame.setVisible(true);
            }
        });
        sidebarPanel.add(Products);

        Orders = new JButton("Orders");
        Orders.setFont(new Font("Verdana", Font.BOLD, 14));
        Orders.setForeground(Color.WHITE);
        Orders.setBackground(new Color(0, 128, 0));
        Orders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	oders_page_distr ordersPage = new oders_page_distr();
                ordersPage.frame.setVisible(true);
            }
        });
        sidebarPanel.add(Orders);

        Users = new JButton("Clients");
        Users.setFont(new Font("Verdana", Font.BOLD, 14));
        Users.setForeground(Color.WHITE);
        Users.setBackground(new Color(0, 128, 0));
        Users.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	clients clientsPage = new clients();
                clientsPage.frame.setVisible(true);
            }
        });
        sidebarPanel.add(Users);

        btnFeedback = new JButton("Feedback/Contact Admin");
        btnFeedback.setFont(new Font("Verdana", Font.BOLD, 14));
        btnFeedback.setForeground(Color.WHITE);
        btnFeedback.setBackground(new Color(0, 128, 0));
        btnFeedback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	feedBack_page feedbackPage = new feedBack_page();
                feedbackPage.frame.setVisible(true);
            }
        });
        sidebarPanel.add(btnFeedback);

        btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Verdana", Font.BOLD, 14));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(Color.RED);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        sidebarPanel.add(btnLogout);
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

// Other page classes like Announcements, DistributorsPage, SalesPage, etc. follow the same pattern.
