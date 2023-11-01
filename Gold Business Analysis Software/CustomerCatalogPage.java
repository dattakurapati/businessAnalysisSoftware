import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CustomerCatalogPage extends JPanel implements ActionListener {
    ProjectWindow window;
    CustomerPurchaseView purchase;
    JLabel navPanel;
    JButton toStockPage;
    JButton toAdminView;
    JLabel title;
    JPanel panel;
    JScrollPane pane;
    private int i;
    private int x;
    private int y;
    private int xPane = 960;
    private int yPane = 730;

    public static ArrayList<CatalogHolder> catalogElementsCus;

    public CustomerCatalogPage(ProjectWindow w, CustomerPurchaseView p) {
        window = w;
        purchase = p;
        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));

        title = new JLabel("Catalog");
        title.setSize(1460, 70);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Sans", Font.PLAIN, 35));
        title.setForeground(Color.WHITE);

        buildNav();
        // x = 10;
        // y= 10;
        // i = 0;

        catalogElementsCus = new ArrayList<CatalogHolder>();

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(960, yPane));
        panel.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBackground(new Color(20, 33, 61));

        pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setBounds(240, 60, 960, 710);
        pane.setBackground(new Color(20, 33, 61));
        pane.setForeground(new Color(20, 33, 61));

        add(title);
        add(toStockPage);
        add(navPanel);
        add(pane);

        toStockPage.addActionListener(this);

        add(title);
        add(toStockPage);
        add(toAdminView);
        add(navPanel);

        toStockPage.addActionListener(this);
        toAdminView.addActionListener(this);

    }

    public void buildNav() {
        navPanel = new JLabel();
        navPanel.setBounds(-20, 0, 260, 900);
        navPanel.setIcon(new ImageIcon("Images/AdminPanelView7.png"));

        toStockPage = new JButton();
        toAdminView = new JButton();

        toStockPage.setOpaque(false);
        toStockPage.setContentAreaFilled(false);
        toStockPage.setBorderPainted(false);
        toStockPage.setBounds(-5, 0, 247, 62);

        toAdminView.setOpaque(false);
        toAdminView.setContentAreaFilled(false);
        toAdminView.setBorderPainted(false);
        toAdminView.setBounds(10, 670, 210, 63);
    }

    // public void update() {
    //     while(i < AdminCatalogPage.catalogElements.size()) {
    //         ImageIcon image  = AdminCatalogPage.catalogElements.get(i).getImage();
    //         AdminCatalogPage.catalogElements.get(i).setBounds(x, y, 300, 300);
    //         AdminCatalogPage.catalogElements.get(i).setIcon(image);
    //         AdminCatalogPage.catalogElements.get(i).setText("<html><center>" + AdminCatalogPage.catalogElements.get(i).getName() + "<br>Cost: $" + String.format("%.2f", AdminCatalogPage.catalogElements.get(i).getTotalCost()) + "<br>Weight: "+ AdminCatalogPage.catalogElements.get(i).getTotalWeight() + " lbs<br>Unique Id: "+ AdminCatalogPage.catalogElements.get(i).getUniqueID());
    //         AdminCatalogPage.catalogElements.get(i).setVerticalTextPosition(AbstractButton.BOTTOM);
    //         AdminCatalogPage.catalogElements.get(i).setHorizontalTextPosition(AbstractButton.CENTER);
    //         AdminCatalogPage.catalogElements.get(i).setHorizontalAlignment(JButton.CENTER);
    //         AdminCatalogPage.catalogElements.get(i).setFont(new Font("Sans", Font.PLAIN,12));
    //         panel.add(AdminCatalogPage.catalogElements.get(i));
    //         AdminCatalogPage.catalogElements.get(i).setVisible(true);
    //         AdminCatalogPage.catalogElements.get(i).addActionListener(this);
    //         if(x > 910) {
    //             y += 310;
    //             x = 10;
    //         } else {
    //             x += 310;
    //         }

    //         if(y > yPane) {
    //             yPane += 350;
    //             panel.setPreferredSize(new Dimension(xPane, yPane));
    //         }
    //         i++;
    //     }
    // }

    public void reUpdate() {
        int z = 0;
        int xRe = 10;
        int yRe = 10;
        while(z < catalogElementsCus.size()) {
            ImageIcon image  = catalogElementsCus.get(z).getImage();
            catalogElementsCus.get(z).setBounds(xRe, yRe, 300, 300);
            catalogElementsCus.get(z).setIcon(image);
            catalogElementsCus.get(z).setText("<html><center>" + catalogElementsCus.get(z).getName() + "<br>Cost: $" + String.format("%.2f", catalogElementsCus.get(z).getTotalCost()) + "<br>Weight: "+ catalogElementsCus.get(z).getTotalWeight());
            catalogElementsCus.get(z).setVerticalTextPosition(AbstractButton.BOTTOM);
            catalogElementsCus.get(z).setHorizontalTextPosition(AbstractButton.CENTER);
            catalogElementsCus.get(z).setHorizontalAlignment(JButton.CENTER);
            catalogElementsCus.get(z).setFont(new Font("Sans", Font.PLAIN,12));
            panel.add(catalogElementsCus.get(z));
            catalogElementsCus.get(z).setVisible(true);
            catalogElementsCus.get(z).addActionListener(this);
            if(xRe > 910) {
                yRe += 310;
                xRe = 10;
            } else {
                xRe += 310;
            }

            if(y > yPane) {
                yPane += 350;
                panel.setPreferredSize(new Dimension(xPane, yPane));
            }  
            z++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == toStockPage) {
            window.openCustomerPage(this);
        } else if (e.getSource() == toAdminView) {
            window.openAdminPage(this);
        } else {
            for (int n = 0; n < catalogElementsCus.size(); n++) {
                if(e.getSource() == catalogElementsCus.get(n)) {
                    window.whenClickedCustomerPurchaseView(this);
                    CustomerPurchaseView.focus = n;
                    purchase.updateValues(n);
                }
            }
        }
    }
}

