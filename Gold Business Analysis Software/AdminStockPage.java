import java.awt.*;
import javax.swing.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.awt.event.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdminStockPage extends JPanel implements ActionListener {
    ProjectWindow window;
    AdminCatalogPage catalog;
    CustomerCatalogPage catCus;
    JLabel navPanel;
    JButton toCatalogPage;
    JButton toCustomerDetailsPage;
    JButton toProfitPage;
    JButton toInventoryPage;
    JButton toCustomerView;
    JLabel title;
    public static double goldPrice = 67.00;
    public static double silverPrice = 0.79;
    JLabel goldLabel;
    JLabel goldPriceLabel;
    JLabel silverLabel;
    JLabel silverPriceLabel;
    JTextField goldOverride;
    JLabel goldOverrideLabel;
    JButton goldSubmit;
    JTextField silverOverride;
    JLabel silverOverrideLabel;
    JButton silverSubmit;
    JLabel incorrectGoldLabel;
    JLabel incorrectSilverLabel;
    JButton revertAll;
    
    public AdminStockPage(ProjectWindow w, AdminCatalogPage catalogPage, CustomerCatalogPage c) {
        window = w;
        catalog = catalogPage;
        catCus = c;
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

        //apiRunner();
        //CustomerStockPage.updateStockValues();

        goldLabel = new JLabel("$"+ String.format("%.2f", goldPrice));
        goldLabel.setSize(845, 355);
        goldLabel.setHorizontalAlignment(JLabel.CENTER);
        goldLabel.setVerticalAlignment(JLabel.CENTER);
        goldLabel.setFont(new Font("Sans", Font.PLAIN, 95));
        goldLabel.setForeground(Color.GREEN);

        silverLabel = new JLabel("$"+ String.format("%.2f", silverPrice));
        silverLabel.setSize(790, 1040);
        silverLabel.setHorizontalAlignment(JLabel.CENTER);
        silverLabel.setVerticalAlignment(JLabel.CENTER);
        silverLabel.setFont(new Font("Sans", Font.PLAIN, 95));
        silverLabel.setForeground(Color.GREEN);

        goldOverrideLabel = new JLabel("Enter Gold Price: ");
        goldOverrideLabel.setSize(650, 510);
        goldOverrideLabel.setHorizontalAlignment(JLabel.CENTER);
        goldOverrideLabel.setVerticalAlignment(JLabel.CENTER);
        goldOverrideLabel.setFont(new Font("Sans", Font.PLAIN, 15));
        goldOverrideLabel.setForeground(Color.WHITE);

        goldOverride = new JTextField("Gold Price in USD");
        goldOverride.setEditable(true);
        goldOverride.setBounds(260, 275, 210, 30);
        goldOverride.setFont(new Font("Sans", Font.PLAIN, 15));
        goldOverride.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (goldOverride.getText().equals("Gold Price in USD")) {
                    goldOverride.setText("");
                }
                incorrectGoldLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (goldOverride.getText().equals("")) {
                    goldOverride.setText("Gold Price in USD");
                }
            }
        });

        goldSubmit = new JButton("Change Price");
        goldSubmit.setFont(new Font("Sans", Font.PLAIN, 15));
        goldSubmit.setBounds(257, 315, 140, 30);
        goldSubmit.setHorizontalAlignment(JButton.LEFT);

        incorrectGoldLabel = new JLabel("Make sure there are no symbols or letters");
        incorrectGoldLabel.setBounds(260, 355, 610, 30);
        incorrectGoldLabel.setFont(new Font("Sans", Font.PLAIN, 15));
        incorrectGoldLabel.setForeground(Color.red);

        silverOverrideLabel = new JLabel("Enter Silver Price: ");
        silverOverrideLabel.setSize(650, 1200);
        silverOverrideLabel.setHorizontalAlignment(JLabel.CENTER);
        silverOverrideLabel.setVerticalAlignment(JLabel.CENTER);
        silverOverrideLabel.setFont(new Font("Sans", Font.PLAIN, 15));
        silverOverrideLabel.setForeground(Color.WHITE);

        silverOverride = new JTextField("Silver Price in USD");
        silverOverride.setEditable(true);
        silverOverride.setBounds(260, 625, 210, 30);
        silverOverride.setFont(new Font("Sans", Font.PLAIN, 15));
        silverOverride.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (silverOverride.getText().equals("Silver Price in USD")) {
                    silverOverride.setText("");
                }
                incorrectSilverLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (silverOverride.getText().equals("")) {
                    silverOverride.setText("Silver Price in USD");
                }
            }
        });

        silverSubmit = new JButton("Change Price");
        silverSubmit.setFont(new Font("Sans", Font.PLAIN, 15));
        silverSubmit.setBounds(257, 665, 140, 30);
        silverSubmit.setHorizontalAlignment(JButton.LEFT);

        incorrectSilverLabel = new JLabel("Make sure there are no symbols or letters");
        incorrectSilverLabel.setBounds(260, 700, 610, 30);
        incorrectSilverLabel.setFont(new Font("Sans", Font.PLAIN, 15));
        incorrectSilverLabel.setForeground(Color.red);

        revertAll = new JButton("Revert Prices");
        revertAll.setFont(new Font("Sans", Font.PLAIN, 15));
        revertAll.setBounds(1040, 70, 140, 40);


        add(title);
        add(toCatalogPage);
        add(toCustomerDetailsPage);
        add(toProfitPage);
        add(toInventoryPage);
        add(toCustomerView);
        add(navPanel);
        add(goldLabel);
        add(goldPriceLabel);
        add(silverLabel);
        add(silverPriceLabel);
        add(goldOverride);
        add(goldOverrideLabel);
        add(goldSubmit);
        add(incorrectGoldLabel);
        add(silverOverride);
        add(silverOverrideLabel);
        add(silverSubmit);
        add(incorrectSilverLabel);
        add(revertAll);

        toCatalogPage.addActionListener(this);
        toCustomerDetailsPage.addActionListener(this);
        toProfitPage.addActionListener(this);
        toInventoryPage.addActionListener(this);
        toCustomerView.addActionListener(this);
        goldSubmit.addActionListener(this);
        silverSubmit.addActionListener(this);
        revertAll.addActionListener(this);

        incorrectSilverLabel.setVisible(false);
        incorrectGoldLabel.setVisible(false);
    }

    public static void apiRunner() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://metals-api.com/api/latest?access_key=x5ycz8exd0tx5xt8cjnpdefrcesqqj79ip6927v2vdmx5c2xf3dxvr46ymew&base=USD&symbols=XAG,XAU")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(AdminStockPage::parse).join();
    }

    public static String parse(String responseBody) {
        JSONObject album = new JSONObject(responseBody);
        goldPrice = (1.0/album.getJSONObject("rates").getDouble("XAU"))/28.3495;
        silverPrice = (1.0/album.getJSONObject("rates").getDouble("XAG"))/28.3495;
        return null;
    }

    public void buildNav() {
        navPanel = new JLabel();
        navPanel.setBounds(-20, 0, 260, 900);
        navPanel.setIcon(new ImageIcon("Images/AdminPanelView1.png"));

        toCatalogPage = new JButton();
        toCustomerDetailsPage = new JButton();
        toProfitPage = new JButton();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == toCatalogPage) {
            window.openAdminCatalogPage(this);
        } else if (e.getSource() == toCustomerDetailsPage) {
            window.openAdminCustomerDetailsPage(this);
        } else if (e.getSource() == toProfitPage) {
            window.openAdminProfitPage(this);
        } else if (e.getSource() == toInventoryPage) {
            window.openAdminInventoryPage(this);
        } else if (e.getSource() == toCustomerView) {
            window.openCustomerPage(this);
        } else if (e.getSource() == goldSubmit) {
            try {
                Double newGoldPrice = Double.parseDouble(goldOverride.getText());
                goldPrice = newGoldPrice;
                goldLabel.setText("$"+ String.format("%.2f", goldPrice));
                CustomerStockPage.goldLabel.setText("$"+ String.format("%.2f", goldPrice));
                for(int x = 0; x < AdminCatalogPage.catalogElements.size(); x++) {
                    AdminCatalogPage.catalogElements.get(x).reCalculate();
                    CustomerCatalogPage.catalogElementsCus.get(x).reCalculate();
                }
                catalog.reUpdate();
                catCus.reUpdate();
            } catch (NumberFormatException ex) {
                incorrectGoldLabel.setVisible(true);
            }
        } else if (e.getSource() == silverSubmit) {
            try {
                Double newSilverPrice = Double.parseDouble(silverOverride.getText());
                silverPrice = newSilverPrice;
                silverLabel.setText("$"+ String.format("%.2f", silverPrice));
                CustomerStockPage.silverLabel.setText("$"+ String.format("%.2f", silverPrice));
            } catch (NumberFormatException ex) {
                incorrectSilverLabel.setVisible(true);
            }
        } else if (e.getSource() == revertAll) {
            apiRunner();
            goldLabel.setText("$"+ String.format("%.2f", goldPrice));
            CustomerStockPage.goldLabel.setText("$"+ String.format("%.2f", goldPrice));
            silverLabel.setText("$"+ String.format("%.2f", silverPrice));
            CustomerStockPage.silverLabel.setText("$"+ String.format("%.2f", silverPrice));
        }
    }
}
