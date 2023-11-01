import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminCustomerDetailsPage extends JPanel implements ActionListener {
    ProjectWindow window;
    JLabel navPanel;
    JButton toCatalogPage;
    JButton toStockPage;
    JButton toProfitPage;
    JButton toInventoryPage;
    JButton toCustomerView;
    JLabel title;
    public static ArrayList<CustomerInformation> customers;

    public AdminCustomerDetailsPage(ProjectWindow w) {
        window = w;
        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));

        title = new JLabel("Customer Details");
        title.setSize(1460, 70);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 35));
        title.setForeground(Color.WHITE);

        buildNav();

        customers = new ArrayList<CustomerInformation>();

        add(title);
        add(toCatalogPage);
        add(toStockPage);
        add(toProfitPage);
        add(toInventoryPage);
        add(toCustomerView);
        add(navPanel);

        toCatalogPage.addActionListener(this);
        toStockPage.addActionListener(this);
        toProfitPage.addActionListener(this);
        toInventoryPage.addActionListener(this);
        toCustomerView.addActionListener(this);
    }

    public void buildNav() {
        navPanel = new JLabel();
        navPanel.setBounds(-20, 0, 260, 900);
        navPanel.setIcon(new ImageIcon("Images/AdminPanelView3.png"));

        toCatalogPage = new JButton();
        toStockPage = new JButton();
        toProfitPage = new JButton();
        toInventoryPage = new JButton();
        toCustomerView = new JButton();

        toCatalogPage.setOpaque(false);
        toCatalogPage.setContentAreaFilled(false);
        toCatalogPage.setBorderPainted(false);
        toCatalogPage.setBounds(-5, 55, 247, 62);

        toStockPage.setOpaque(false);
        toStockPage.setContentAreaFilled(false);
        toStockPage.setBorderPainted(false);
        toStockPage.setBounds(-5, 0, 247, 61);

        toProfitPage.setOpaque(false);
        toProfitPage.setContentAreaFilled(false);
        toProfitPage.setBorderPainted(false);
        toProfitPage.setBounds(-5, 173, 247, 59);

        toInventoryPage.setOpaque(false);
        toInventoryPage.setContentAreaFilled(false);
        toInventoryPage.setBorderPainted(false);
        toInventoryPage.setBounds(-5, 228, 247, 61);

        toCustomerView.setOpaque(false);
        toCustomerView.setContentAreaFilled(false);
        toCustomerView.setBorderPainted(false);
        toCustomerView.setBounds(10, 670, 210, 63);
    }

    public void update() {
        int y = 100;
        for(int u  = 0; u < customers.size(); u++) {
            customers.get(u).setBounds(260, y, 900, 60);
            customers.get(u).setText(customers.get(u).getName());
            customers.get(u).setFont(new Font("Sans", Font.PLAIN, 17));
            customers.get(u).setOpaque(true);
            customers.get(u).setBackground(Color.white);
            customers.get(u).setHorizontalAlignment(JLabel.CENTER);
            add(customers.get(u));
            y += 62;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == toCatalogPage) {
            window.openAdminCatalogPage(this);
        } else if (e.getSource() == toStockPage) {
            window.openAdminStockPage(this);
        } else if (e.getSource() == toProfitPage) {
            window.openAdminProfitPage(this);
        } else if (e.getSource() == toInventoryPage) {
            window.openAdminInventoryPage(this);
        } else if (e.getSource() == toCustomerView) {
            window.openCustomerPage(this);
        }
    }
}
