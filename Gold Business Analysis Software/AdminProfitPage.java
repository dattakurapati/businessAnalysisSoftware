import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminProfitPage extends JPanel implements ActionListener {
    ProjectWindow window;
    JLabel navPanel;
    JButton toCatalogPage;
    JButton toCustomerDetailsPage;
    JButton toStockPage;
    JButton toInventoryPage;
    JButton toCustomerView;
    JLabel title;
    JLabel profitLabel;
    JLabel profit;
    JLabel individualSold;
    JLabel chain;
    JLabel bracelet;
    JLabel earRing;
    JLabel rings;
    JLabel other;
    public static double profitMade;
    public static int cs;
    public static int bs;
    public static int es;
    public static int rs;
    public static int os;
    
    public AdminProfitPage(ProjectWindow w) {
        window = w;
        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));


        title = new JLabel("Profitability Analysis");
        title.setSize(1460, 70);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 35));
        title.setForeground(Color.WHITE);

        buildNav();

        profitMade = 0;    
        cs = 0;
        bs = 0;
        es = 0;
        rs = 0;
        os = 0;


        profitLabel = new JLabel("Total Profit: ");
        profit = new JLabel("$" + String.format("%.2f", profitMade));
        individualSold = new JLabel("Number of Each Item Sold: ");
        chain = new JLabel("Chains: " + cs);
        bracelet = new JLabel("Bracelets: " + bs);
        earRing = new JLabel("Ear Rings: " + es);
        rings = new JLabel("Rings: " + rs);
        other = new JLabel("Other: " + os);
        
        JLabel[] allLabels = {profitLabel, profit, individualSold, chain, bracelet, earRing, rings, other};
        JLabel[] changeLabels = {chain, bracelet, earRing, rings, other};
        for(int i = 0; i < allLabels.length; i++) {
            allLabels[i].setFont(new Font("Sans", Font.PLAIN, 17));
            allLabels[i].setForeground(Color.WHITE);
        }

        profitLabel.setBounds(270, 100, 200, 50);
        profit.setBounds(270, 120, 1000, 300);
        profit.setFont(new Font("Sans", Font.PLAIN, 120));
        individualSold.setBounds(270, 400, 270, 60);

        int x = 270;
        int y = 450;
        int q = 1;
        for(int z = 0; z < changeLabels.length; z++) {
            changeLabels[z].setBounds(x, y, 200, 150);
            if(q % 3 == 0) {
                x += 300;
                y = 450;
            } else {
                y += 100;
            }
            q++;
        }

        add(title);
        add(toCatalogPage);
        add(toCustomerDetailsPage);
        add(toStockPage);
        add(toInventoryPage);
        add(toCustomerView);
        add(navPanel);
        add(profitLabel);
        add(profit);
        add(individualSold);
        add(chain);
        add(bracelet);
        add(earRing);
        add(rings);
        add(other);

        toCatalogPage.addActionListener(this);
        toCustomerDetailsPage.addActionListener(this);
        toStockPage.addActionListener(this);
        toInventoryPage.addActionListener(this);
        toCustomerView.addActionListener(this);
    }

    public void update() {
        cs = 0;
        bs = 0;
        es = 0;
        rs = 0;
        os = 0;
        profitMade =0;
        for(int x = 0; x < CustomerCatalogPage.catalogElementsCus.size(); x++) {
            if(CustomerCatalogPage.catalogElementsCus.get(x).getTypeOfJewelry().equals("Chains")) {
                cs += CustomerCatalogPage.catalogElementsCus.get(x).getSold();
            } else if(CustomerCatalogPage.catalogElementsCus.get(x).getTypeOfJewelry().equals("Bracelets")) {
                bs += CustomerCatalogPage.catalogElementsCus.get(x).getSold();
            } else if (CustomerCatalogPage.catalogElementsCus.get(x).getTypeOfJewelry().equals("Ear Rings")) {
                es += CustomerCatalogPage.catalogElementsCus.get(x).getSold();
            } else if (CustomerCatalogPage.catalogElementsCus.get(x).getTypeOfJewelry().equals("Rings")) {
                rs += CustomerCatalogPage.catalogElementsCus.get(x).getSold();
            } else {
                os += CustomerCatalogPage.catalogElementsCus.get(x).getSold();
            }
            profitMade += CustomerCatalogPage.catalogElementsCus.get(x).getProfit();
        }

        profit.setText(String.format("%.2f", profitMade));
        chain.setText("Chains: " + cs);
        bracelet.setText("Bracelet: " + bs);
        earRing.setText("Ear Rings: " + es);
        rings.setText("Rings: " + rs);
        other.setText("Other: " + os);

    }

    public void buildNav() {
        navPanel = new JLabel();
        navPanel.setBounds(-20, 0, 260, 900);
        navPanel.setIcon(new ImageIcon("Images/AdminPanelView4.png"));

        toCatalogPage = new JButton();
        toCustomerDetailsPage = new JButton();
        toStockPage = new JButton();
        toInventoryPage = new JButton();
        toCustomerView = new JButton();

        toCatalogPage.setOpaque(false);
        toCatalogPage.setContentAreaFilled(false);
        toCatalogPage.setBorderPainted(false);
        toCatalogPage.setBounds(-5, 55, 247, 62);

        toCustomerDetailsPage.setOpaque(false);
        toCustomerDetailsPage.setContentAreaFilled(false);
        toCustomerDetailsPage.setBorderPainted(false);
        toCustomerDetailsPage.setBounds(-5, 115, 247, 60);

        toStockPage.setOpaque(false);
        toStockPage.setContentAreaFilled(false);
        toStockPage.setBorderPainted(false);
        toStockPage.setBounds(-5, 0, 247, 61);

        toInventoryPage.setOpaque(false);
        toInventoryPage.setContentAreaFilled(false);
        toInventoryPage.setBorderPainted(false);
        toInventoryPage.setBounds(-5, 228, 247, 61);

        toCustomerView.setOpaque(false);
        toCustomerView.setContentAreaFilled(false);
        toCustomerView.setBorderPainted(false);
        toCustomerView.setBounds(10, 670, 210, 63);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == toCatalogPage) {
            window.openAdminCatalogPage(this);
        } else if (e.getSource() == toCustomerDetailsPage) {
            window.openAdminCustomerDetailsPage(this);
        } else if (e.getSource() == toStockPage) {
            window.openAdminStockPage(this);
        } else if (e.getSource() == toInventoryPage) {
            window.openAdminInventoryPage(this);
        } else if (e.getSource() == toCustomerView) {
            window.openCustomerPage(this);
        }
    }
}
