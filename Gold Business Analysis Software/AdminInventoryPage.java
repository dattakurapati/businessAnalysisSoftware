import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminInventoryPage extends JPanel implements ActionListener {
    ProjectWindow window;
    JLabel navPanel;
    JButton toCatalogPage;
    JButton toCustomerDetailsPage;
    JButton toProfitPage;
    JButton toStockPage;
    JButton toCustomerView;
    JLabel title;
    JLabel chainsLabel;
    JLabel braceletsLabel;
    JLabel earRingsLabel;
    JLabel ringsLabel;
    JLabel otherLabel;
    public static JLabel chainsQuan;
    public static JLabel earRingsQuan;
    public static JLabel ringsQuan;
    public static JLabel braceletsQuan;
    public static JLabel otherQuan;
    public static JLabel chainsWeight;
    public static JLabel earRingsWeight;
    public static JLabel ringsWeight;
    public static JLabel braceletsWeight;
    public static JLabel otherWeight;
    public static int cq;
    public static int eq;
    public static int rq;
    public static int bq;
    public static int oq;
    public static int cw;
    public static int ew;
    public static int rw;
    public static int bw;
    public static int ow;

    public AdminInventoryPage(ProjectWindow w) {
        window = w;
        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));


        title = new JLabel("Inventory");
        title.setSize(1460, 70);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 35));
        title.setForeground(Color.WHITE);

        buildNav();

        cq = 0;
        eq = 0;
        rq = 0;
        bq = 0;
        oq = 0;
        cw = 0;
        ew = 0;
        rw = 0;
        bw = 0;
        ow = 0;

        chainsLabel = new JLabel("Chains --> ");
        braceletsLabel= new JLabel("Bracelets --> "); 
        earRingsLabel = new JLabel("Ear Rings--> ");
        ringsLabel = new JLabel("Rings --> ");
        otherLabel = new JLabel("Other --> ");
        chainsQuan = new JLabel("Quantity: " + cq);
        earRingsQuan = new JLabel("Quantity: " + eq);
        ringsQuan = new JLabel("Quantity: " + rq);
        braceletsQuan = new JLabel("Quantity: "+bq);
        otherQuan = new JLabel("Quantity: "+ oq);
        chainsWeight = new JLabel("Total Weight: " + cw + " gm");
        earRingsWeight = new JLabel("Total Weight: " + ew + " gm");
        ringsWeight = new JLabel("Total Weight: " + rw + " gm");
        braceletsWeight= new JLabel("Total Weight: " + bw + " gm");
        otherWeight = new JLabel("Total Weight: " + ow + " gm");

        int x = 350;
        int y = 150;
        int q = 1;
        JLabel[] allLabels = {chainsLabel, braceletsLabel, earRingsLabel, ringsLabel, otherLabel, 
            chainsQuan, braceletsQuan, earRingsQuan, ringsQuan, otherQuan, chainsWeight, 
            braceletsWeight, earRingsWeight, ringsWeight, otherWeight};
        for(int i = 0; i < allLabels.length; i++) {
            allLabels[i].setFont(new Font("Sans", Font.PLAIN, 17));
            allLabels[i].setForeground(Color.WHITE);
            allLabels[i].setBounds(x, y, 300, 60);
            if(q % 10 == 0) {
                x += 300;
                y = 150;
            } else if(q % 5 == 0) {
                x += 200;
                y = 150;
            } else {
                y += 100;
            }
            q++;
        }

        add(title);
        add(toCatalogPage);
        add(toCustomerDetailsPage);
        add(toProfitPage);
        add(toStockPage);
        add(toCustomerView);
        add(navPanel);
        add(chainsLabel);
        add(braceletsLabel);
        add(earRingsLabel);
        add(ringsLabel);
        add(otherLabel);
        add(chainsQuan);
        add(earRingsQuan);
        add(ringsQuan);
        add(braceletsQuan);
        add(otherQuan);
        add(chainsWeight);
        add(earRingsWeight);
        add(ringsWeight);
        add(braceletsWeight);
        add(otherWeight);

        toCatalogPage.addActionListener(this);
        toCustomerDetailsPage.addActionListener(this);
        toProfitPage.addActionListener(this);
        toStockPage.addActionListener(this);
        toCustomerView.addActionListener(this);
        
    }

    public void update() {
        cq = 0;
        eq = 0;
        rq = 0;
        bq = 0;
        oq = 0;
        cw = 0;
        ew = 0;
        rw = 0;
        bw = 0;
        ow = 0;
        for(int x = 0; x < CustomerCatalogPage.catalogElementsCus.size(); x++) {
            if(CustomerCatalogPage.catalogElementsCus.get(x).getTypeOfJewelry().equals("Chains")) {
                cq += CustomerCatalogPage.catalogElementsCus.get(x).getQuantity();
                cw += CustomerCatalogPage.catalogElementsCus.get(x).getAbsoluteWeight();
            } else if(CustomerCatalogPage.catalogElementsCus.get(x).getTypeOfJewelry().equals("Bracelets")) {
                bq += CustomerCatalogPage.catalogElementsCus.get(x).getQuantity();
                bw += CustomerCatalogPage.catalogElementsCus.get(x).getAbsoluteWeight();
            } else if (CustomerCatalogPage.catalogElementsCus.get(x).getTypeOfJewelry().equals("Ear Rings")) {
                eq += CustomerCatalogPage.catalogElementsCus.get(x).getQuantity();
                ew += CustomerCatalogPage.catalogElementsCus.get(x).getAbsoluteWeight();
            } else if (CustomerCatalogPage.catalogElementsCus.get(x).getTypeOfJewelry().equals("Rings")) {
                rq += CustomerCatalogPage.catalogElementsCus.get(x).getQuantity();
                rw += CustomerCatalogPage.catalogElementsCus.get(x).getAbsoluteWeight();
            } else {
                oq += CustomerCatalogPage.catalogElementsCus.get(x).getQuantity();
                ow += CustomerCatalogPage.catalogElementsCus.get(x).getAbsoluteWeight();
            }
        }

        chainsQuan.setText("Quantity: " + cq);
        earRingsQuan.setText("Quantity: " + eq);
        ringsQuan.setText("Quantity: " + rq);
        braceletsQuan.setText("Quantity: "+bq);
        otherQuan.setText("Quantity: "+ oq);
        chainsWeight.setText("Total Weight: " + cw + " gm");
        earRingsWeight.setText("Total Weight: " + ew + " gm");
        ringsWeight.setText("Total Weight: " + rw + " gm");
        braceletsWeight.setText("Total Weight: " + bw + " gm");
        otherWeight.setText("Total Weight: " + ow + " gm");

    }


    public void buildNav() {
        navPanel = new JLabel();
        navPanel.setBounds(-20, 0, 260, 900);
        navPanel.setIcon(new ImageIcon("Images/AdminPanelView5.png"));

        toCatalogPage = new JButton();
        toCustomerDetailsPage = new JButton();
        toProfitPage = new JButton();
        toStockPage = new JButton();
        toCustomerView = new JButton();

        toCatalogPage.setOpaque(false);
        toCatalogPage.setContentAreaFilled(false);
        toCatalogPage.setBorderPainted(false);
        toCatalogPage.setBounds(-5, 55, 247, 62);

        toCustomerDetailsPage.setOpaque(false);
        toCustomerDetailsPage.setContentAreaFilled(false);
        toCustomerDetailsPage.setBorderPainted(false);
        toCustomerDetailsPage.setBounds(-5, 115, 247, 60);

        toProfitPage.setOpaque(false);
        toProfitPage.setContentAreaFilled(false);
        toProfitPage.setBorderPainted(false);
        toProfitPage.setBounds(-5, 173, 247, 59);

        toStockPage.setOpaque(false);
        toStockPage.setContentAreaFilled(false);
        toStockPage.setBorderPainted(false);
        toStockPage.setBounds(-5,0, 247, 61);

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
        } else if (e.getSource() == toProfitPage) {
            window.openAdminProfitPage(this);
        } else if (e.getSource() == toStockPage) {
            window.openAdminStockPage(this);
        } else if (e.getSource() == toCustomerView) {
            window.openCustomerPage(this);
        }
    }
}
