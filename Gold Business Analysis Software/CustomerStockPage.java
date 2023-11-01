import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CustomerStockPage extends JPanel implements ActionListener {

    ProjectWindow window;
    JLabel navPanel;
    JButton toCatalogPage;
    JButton toAdminView;
    JLabel title;
    public static JLabel goldLabel;
    JLabel goldPriceLabel;
    public static JLabel silverLabel;
    JLabel silverPriceLabel;
    
    public CustomerStockPage(ProjectWindow w) {
        window = w;

        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));


        title = new JLabel("Gold & Silver Prices");
        title.setSize(1460, 70);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 35));
        title.setForeground(Color.WHITE);

        buildNav();

        goldPriceLabel = new JLabel("Current Gold Price (per gram): ");
        goldPriceLabel.setSize(770, 180);
        goldPriceLabel.setHorizontalAlignment(JLabel.CENTER);
        goldPriceLabel.setVerticalAlignment(JLabel.CENTER);
        goldPriceLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        goldPriceLabel.setForeground(Color.WHITE);

        silverPriceLabel = new JLabel("Current Silver Price (per gram): ");
        silverPriceLabel.setSize(778, 860);
        silverPriceLabel.setHorizontalAlignment(JLabel.CENTER);
        silverPriceLabel.setVerticalAlignment(JLabel.CENTER);
        silverPriceLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        silverPriceLabel.setForeground(Color.WHITE);

        goldLabel = new JLabel("$"+ String.format("%.2f", AdminStockPage.goldPrice));
        goldLabel.setSize(845, 355);
        goldLabel.setHorizontalAlignment(JLabel.CENTER);
        goldLabel.setVerticalAlignment(JLabel.CENTER);
        goldLabel.setFont(new Font("Sans", Font.PLAIN, 95));
        goldLabel.setForeground(Color.GREEN);

        silverLabel = new JLabel("$"+ String.format("%.2f", AdminStockPage.silverPrice));
        silverLabel.setSize(790, 1040);
        silverLabel.setHorizontalAlignment(JLabel.CENTER);
        silverLabel.setVerticalAlignment(JLabel.CENTER);
        silverLabel.setFont(new Font("Sans", Font.PLAIN, 95));
        silverLabel.setForeground(Color.GREEN);


        add(title);
        add(toCatalogPage);
        add(toAdminView);
        add(navPanel);
        add(goldLabel);
        add(goldPriceLabel);
        add(silverLabel);
        add(silverPriceLabel);

        toCatalogPage.addActionListener(this);
        toAdminView.addActionListener(this);

    }

    public static void updateStockValues() {
        goldLabel.setText("$"+ String.format("%.2f", AdminStockPage.goldPrice));
        silverLabel.setText("$"+ String.format("%.2f", AdminStockPage.silverPrice));
    }

    public void buildNav() {
        navPanel = new JLabel();
        navPanel.setBounds(-20, 0, 260, 900);
        navPanel.setIcon(new ImageIcon("Images/AdminPanelView6.png"));

        toCatalogPage = new JButton();
        toAdminView = new JButton();

        toCatalogPage.setOpaque(false);
        toCatalogPage.setContentAreaFilled(false);
        toCatalogPage.setBorderPainted(false);
        toCatalogPage.setBounds(-5, 55, 247, 62);

        toAdminView.setOpaque(false);
        toAdminView.setContentAreaFilled(false);
        toAdminView.setBorderPainted(false);
        toAdminView.setBounds(10, 670, 210, 63);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == toCatalogPage) {
            window.openCustomerCatalogPage(this);
        } else if (e.getSource() == toAdminView) {
            window.openAdminPage(this);
        }
    }
}

