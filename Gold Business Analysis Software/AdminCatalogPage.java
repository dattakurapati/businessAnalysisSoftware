import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AdminCatalogPage extends JPanel implements ActionListener{
    ProjectWindow window;
    JLabel navPanel;
    JButton toStockPage;
    JButton toCustomerDetailsPage;
    JButton toProfitPage;
    JButton toInventoryPage;
    JButton toCustomerView;
    JLabel title;
    JButton addButton;
    JScrollPane pane;
    JPanel panel;
    private int i;
    private int x;
    private int y;
    private int xPane = 960;
    private int yPane = 730;

    public static ArrayList<CatalogHolder> catalogElements;

    public AdminCatalogPage(ProjectWindow w) {
        window = w;
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
        x = 10;
        y= 10;
        i = 0;

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(960, yPane));
        panel.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBackground(new Color(20, 33, 61));

        pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setBounds(240, 60, 960, 710);
        pane.setBackground(new Color(20, 33, 61));
        pane.setForeground(new Color(20, 33, 61));

        addButton = new JButton("Add");
        addButton.setBounds(1070,12,100,50);
        addButton.setFont(new Font("Sans", Font.PLAIN,15));

        catalogElements = new ArrayList<CatalogHolder>();

        add(title);
        add(toStockPage);
        add(toCustomerDetailsPage);
        add(toProfitPage);
        add(toInventoryPage);
        add(toCustomerView);
        add(addButton);
        add(navPanel);
        add(pane);

        toStockPage.addActionListener(this);
        toCustomerDetailsPage.addActionListener(this);
        toProfitPage.addActionListener(this);
        toInventoryPage.addActionListener(this);
        toCustomerView.addActionListener(this);
        addButton.addActionListener(this);
    }

    public void buildNav() {
        navPanel = new JLabel();
        navPanel.setBounds(-20, 0, 260, 900);
        navPanel.setIcon(new ImageIcon("Images/AdminPanelView2.png"));

        toStockPage = new JButton();
        toCustomerDetailsPage = new JButton();
        toProfitPage = new JButton();
        toInventoryPage = new JButton();
        toCustomerView = new JButton();

        toStockPage.setOpaque(false);
        toStockPage.setContentAreaFilled(false);
        toStockPage.setBorderPainted(false);
        toStockPage.setBounds(-5, 0, 247, 62);

        toCustomerDetailsPage.setOpaque(false);
        toCustomerDetailsPage.setContentAreaFilled(false);
        toCustomerDetailsPage.setBorderPainted(false);
        toCustomerDetailsPage.setBounds(-5, 115, 247, 60);

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
        while(i < catalogElements.size()) {
            ImageIcon image  = catalogElements.get(i).getImage();
            catalogElements.get(i).setBounds(x, y, 300, 300);
            catalogElements.get(i).setIcon(image);
            catalogElements.get(i).setText("<html><center>" + catalogElements.get(i).getName() + "<br>Cost: $" + String.format("%.2f", catalogElements.get(i).getTotalCost()) + "<br>Weight: "+ catalogElements.get(i).getTotalWeight() + " gm<br>Unique Id: "+ catalogElements.get(i).getUniqueID());
            catalogElements.get(i).setVerticalTextPosition(AbstractButton.BOTTOM);
            catalogElements.get(i).setHorizontalTextPosition(AbstractButton.CENTER);
            catalogElements.get(i).setHorizontalAlignment(JButton.CENTER);
            catalogElements.get(i).setFont(new Font("Sans", Font.PLAIN,12));
            panel.add(catalogElements.get(i));
            catalogElements.get(i).setVisible(true);
            catalogElements.get(i).addActionListener(this);
            if(x > 910) {
                y += 310;
                x = 10;
            } else {
                x += 310;
            }

            if(y > yPane) {
                yPane += 350;
                panel.setPreferredSize(new Dimension(xPane, yPane));
            }
            i++;
        }
    }

    public void reUpdate() {
        int z = 0;
        int xRe = 10;
        int yRe = 10;
        while(z < catalogElements.size()) {
            ImageIcon image  = catalogElements.get(z).getImage();
            catalogElements.get(z).setBounds(xRe, yRe, 300, 300);
            catalogElements.get(z).setIcon(image);
            catalogElements.get(z).setText("<html><center>" + catalogElements.get(z).getName() 
            + "<br>Cost: $" + String.format("%.2f", catalogElements.get(z).getTotalCost()) 
            + "<br>Weight: "+ catalogElements.get(z).getTotalWeight() + " gm<br>Unique Id: "+ catalogElements.get(z)
            .getUniqueID());
            catalogElements.get(z).setVerticalTextPosition(AbstractButton.BOTTOM);
            catalogElements.get(z).setHorizontalTextPosition(AbstractButton.CENTER);
            catalogElements.get(z).setHorizontalAlignment(JButton.CENTER);
            catalogElements.get(z).setFont(new Font("Sans", Font.PLAIN,12));
            panel.add(catalogElements.get(z));
            catalogElements.get(z).setVisible(true);
            catalogElements.get(z).addActionListener(this);
            if(xRe >= 630) {
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
        if(e.getSource() == toStockPage) {
            window.openAdminStockPage(this);
        } else if (e.getSource() == toCustomerDetailsPage) {
            window.openAdminCustomerDetailsPage(this);
        } else if (e.getSource() == toProfitPage) {
            window.openAdminProfitPage(this);
        } else if (e.getSource() == toInventoryPage) {
            window.openAdminInventoryPage(this);
        } else if (e.getSource() == toCustomerView) {
            window.openCustomerPage(this);
        } else if (e.getSource() ==  addButton) {
            window.openAddCatalogPage(this);
        } else {
            for (int n = 0; n < catalogElements.size(); n++) {
                if(e.getSource() == catalogElements.get(n)) {
                    window.openEditCatalogPage(this);
                    EditData.focus = n;
                }
            }
        }
    }
}