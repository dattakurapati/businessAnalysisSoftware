import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.*;

public class CustomerPurchaseView extends JPanel implements ActionListener {
    ProjectWindow window;
    JLabel backButton;
    AdminInventoryPage inventory;
    AdminProfitPage profit;
    AdminCustomerDetailsPage customer;
    JLabel enterName;
    ImageIcon display;
    JLabel showImage;
    JLabel allGemsWeightLabel;
    JLabel totalWeightLabel;
    JLabel costOfGemsLabel;
    JLabel makingChargesLabel;
    JLabel kdmLabel;
    JLabel cashDiscountLabel;
    JLabel typeOfJewelryLabel;
    JLabel allGemsWeightInput;
    JLabel totalWeightInput;
    JLabel costOfGemsInput;
    JLabel makingChargesInput;
    JLabel kdmInput;
    JTextField cashDiscountInput;
    JLabel typeOfJewelryInput;
    JLabel incorrectLabel;
    JLabel totalPriceLabel;
    JLabel totalPriceInput;
    JLabel finalPriceLabel;
    JLabel finalPriceInput;
    JLabel buyerNameLabel;
    JTextField buyerNameInput;
    JLabel emailLabel;
    JTextField emailInput;
    JLabel shippingLabel;
    JTextField shippingInput;
    JLabel save;
    JButton applyDiscount;
    String filename;
    double finalPrice;
    public static int focus;
    
    public CustomerPurchaseView(ProjectWindow w, AdminInventoryPage inven, AdminProfitPage pro, AdminCustomerDetailsPage cus) {
        window = w;
        inventory = inven;
        profit = pro;
        customer = cus;
        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));

        finalPrice = 0;

        
        backButton = new JLabel();
        backButton.setBounds(20, 20, 50, 50);
        backButton.setIcon(new ImageIcon("Images/BackButton.png"));
        backButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                incorrectLabel.setVisible(false);
                emailInput.setText("Enter Email");
                shippingInput.setText("Enter Shipping Address");
                buyerNameInput.setText("Enter Name");
                cashDiscountInput.setText("Enter Cash Discount");
                showImage.setIcon(null);
                allGemsWeightInput.setText("");
                costOfGemsInput.setText("");
                totalPriceInput.setText("");
                totalWeightInput.setText("");
                makingChargesInput.setText("");
                kdmInput.setText("");
                typeOfJewelryInput.setText("");
                finalPriceInput.setText("");
                window.whenClickedBackCustomer();
            }
        });

        enterName = new JLabel("Product Name");
        enterName.setBounds(200, 10, 800, 70);
        enterName.setHorizontalAlignment(JLabel.CENTER);
        enterName.setFont(new Font("Sans", Font.PLAIN, 35));
        enterName.setForeground(Color.white);
        
        showImage = new JLabel();
        showImage.setBounds(20, 95, 560, 660);
        showImage.setVisible(false);

        typeOfJewelryLabel = new JLabel("Type of Jewelry: ");
        typeOfJewelryLabel.setBounds(680, 95, 200, 40);
        typeOfJewelryLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        typeOfJewelryLabel.setForeground(Color.WHITE);

        typeOfJewelryInput = new JLabel();
        typeOfJewelryInput.setBounds(825, 95, 340,40);
        typeOfJewelryInput.setFont(new Font("Sans", Font.PLAIN, 17));
        typeOfJewelryInput.setForeground(Color.white);


        totalWeightLabel = new JLabel("Total Weight: ");
        totalWeightLabel.setBounds(680, 145, 200, 40);
        totalWeightLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        totalWeightLabel.setForeground(Color.WHITE);

        totalWeightInput = new JLabel();
        totalWeightInput.setBounds(825, 145, 340, 40);
        totalWeightInput.setFont(new Font("Sans", Font.PLAIN, 17));
        totalWeightInput.setForeground(Color.white);

        allGemsWeightLabel = new JLabel("Weight of Gems: ");
        allGemsWeightLabel.setBounds(680, 195, 150, 40);
        allGemsWeightLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        allGemsWeightLabel.setForeground(Color.WHITE);

        allGemsWeightInput = new JLabel();
        allGemsWeightInput.setBounds(825, 195, 340, 40);
        allGemsWeightInput.setFont(new Font("Sans", Font.PLAIN, 17));
        allGemsWeightInput.setForeground(Color.white);

        costOfGemsLabel = new JLabel("Cost of Gems: ");
        costOfGemsLabel.setBounds(680, 245, 200, 40);
        costOfGemsLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        costOfGemsLabel.setForeground(Color.WHITE);

        costOfGemsInput = new JLabel();
        costOfGemsInput.setBounds(825, 245, 340, 40);
        costOfGemsInput.setFont(new Font("Sans", Font.PLAIN, 17));
        costOfGemsInput.setForeground(Color.white);

        makingChargesLabel = new JLabel("Making Charges: ");
        makingChargesLabel.setBounds(680, 295, 200, 40);
        makingChargesLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        makingChargesLabel.setForeground(Color.WHITE);

        makingChargesInput = new JLabel();
        makingChargesInput.setBounds(825, 295, 340, 40);
        makingChargesInput.setFont(new Font("Sans", Font.PLAIN, 17));
        makingChargesInput.setForeground(Color.white);

        kdmLabel = new JLabel("KDM: ");
        kdmLabel.setBounds(680, 345, 200, 40);
        kdmLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        kdmLabel.setForeground(Color.WHITE);

        kdmInput = new JLabel("");
        kdmInput.setBounds(825, 345, 340, 40);
        kdmInput.setFont(new Font("Sans", Font.PLAIN, 17));
        kdmInput.setForeground(Color.white);

        totalPriceLabel = new JLabel("Total Price: ");
        totalPriceLabel.setBounds(680, 395, 200, 40);
        totalPriceLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        totalPriceLabel.setForeground(Color.WHITE);

        totalPriceInput = new JLabel("");
        totalPriceInput.setBounds(825, 395, 340, 40);
        totalPriceInput.setFont(new Font("Sans", Font.PLAIN, 17));
        totalPriceInput.setForeground(Color.white);

        cashDiscountLabel = new JLabel("Cash Discount: ");
        cashDiscountLabel.setBounds(680, 445, 200, 40);
        cashDiscountLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        cashDiscountLabel.setForeground(Color.WHITE);

        cashDiscountInput = new JTextField("Enter Cash Discount");
        cashDiscountInput.setBounds(825, 451, 300, 30);
        cashDiscountInput.setFont(new Font("Sans", Font.PLAIN, 15));
        cashDiscountInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cashDiscountInput.getText().equals("Enter Cash Discount")) {
                    cashDiscountInput.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (cashDiscountInput.getText().equals("")) {
                    cashDiscountInput.setText("Enter Cash Discount");
                }
            }
        });

        applyDiscount = new JButton("-");
        applyDiscount.setBounds(1125, 451, 40, 30);
        applyDiscount.setFont(new Font("Sans", Font.PLAIN, 15));

        finalPriceLabel = new JLabel("Final Price: ");
        finalPriceLabel.setBounds(680, 495, 200, 40);
        finalPriceLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        finalPriceLabel.setForeground(Color.WHITE);

        finalPriceInput = new JLabel("");
        finalPriceInput.setBounds(825, 495, 340, 40);
        finalPriceInput.setFont(new Font("Sans", Font.PLAIN, 17));
        finalPriceInput.setForeground(Color.white);

        buyerNameLabel = new JLabel("Name: ");
        buyerNameLabel.setBounds(680, 545, 200, 40);
        buyerNameLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        buyerNameLabel.setForeground(Color.WHITE);
        buyerNameInput = new JTextField("Enter Name");
        buyerNameInput.setBounds(825, 551, 340, 30);
        buyerNameInput.setFont(new Font("Sans", Font.PLAIN, 15));
        buyerNameInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (buyerNameInput.getText().equals("Enter Name")) {
                    buyerNameInput.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (buyerNameInput.getText().equals("")) {
                    buyerNameInput.setText("Enter Name");
                }
            }
        });

        emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(680, 595, 200, 40);
        emailLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        emailLabel.setForeground(Color.WHITE);
        emailInput = new JTextField("Enter Email");
        emailInput.setBounds(825, 601, 340, 30);
        emailInput.setFont(new Font("Sans", Font.PLAIN, 15));
        emailInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailInput.getText().equals("Enter Email")) {
                    emailInput.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (emailInput.getText().equals("")) {
                    emailInput.setText("Enter Email");
                }
            }
        });
        
        shippingLabel = new JLabel("Address: ");
        shippingLabel.setBounds(680, 645, 200, 40);
        shippingLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        shippingLabel.setForeground(Color.WHITE);
        shippingInput = new JTextField("Enter Shipping Address");
        shippingInput.setBounds(825, 651, 340, 30);
        shippingInput.setFont(new Font("Sans", Font.PLAIN, 15));
        shippingInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (shippingInput.getText().equals("Enter Shipping Address")) {
                    shippingInput.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (shippingInput.getText().equals("")) {
                    shippingInput.setText("Enter Shipping Address");
                }
            }
        });

        incorrectLabel = new JLabel("<html>Make sure no symbols and file type is .png or .jpeg</html>");
        incorrectLabel.setBounds(680, 755, 500, 60);
        incorrectLabel.setFont(new Font("Sans", Font.PLAIN, 15));
        incorrectLabel.setForeground(Color.red);
        incorrectLabel.setVisible(false);

        save = new JLabel();
        save.setBounds(847, 700, 150, 45);
        save.setIcon(new ImageIcon("Images/SaveButton.png"));
        save.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                try {
                    if(emailInput.getText().equals("Enter Email") && shippingInput.getText().equals("Enter Shipping Address") && buyerNameInput.getText().equals("Enter Name")){
                        throw new Exception("error");
                    }
                    CustomerCatalogPage.catalogElementsCus.get(focus).setFinal(finalPrice);
                    CustomerCatalogPage.catalogElementsCus.get(focus).setQuantity();
                    AdminCustomerDetailsPage.customers.add(new CustomerInformation(buyerNameInput.getText()));
                    inventory.update();
                    profit.update();
                    customer.update();
                    incorrectLabel.setVisible(false);
                    emailInput.setText("Enter Email");
                    shippingInput.setText("Enter Shipping Address");
                    buyerNameInput.setText("Enter Name");
                    cashDiscountInput.setText("Enter Cash Discount");
                    showImage.setIcon(null);
                    allGemsWeightInput.setText("");
                    costOfGemsInput.setText("");
                    totalPriceInput.setText("");
                    totalWeightInput.setText("");
                    makingChargesInput.setText("");
                    kdmInput.setText("");
                    typeOfJewelryInput.setText("");
                    finalPriceInput.setText("");
                    window.whenClickedBackCustomer();
                } catch (Exception ex){
                    System.out.println(ex);
                    incorrectLabel.setVisible(true);
                }
            }
        });

        add(backButton);
        add(enterName);
        add(showImage);
        add(allGemsWeightLabel);
        add(totalWeightLabel);
        add(costOfGemsLabel);
        add(makingChargesLabel);
        add(kdmLabel);
        add(cashDiscountLabel);
        add(typeOfJewelryLabel);
        add(allGemsWeightInput);
        add(totalWeightInput);
        add(costOfGemsInput);
        add(makingChargesInput);
        add(kdmInput);
        add(cashDiscountInput);
        add(typeOfJewelryInput);
        add(incorrectLabel);
        add(finalPriceLabel);
        add(finalPriceInput);
        add(totalPriceLabel);
        add(totalPriceInput);
        add(buyerNameInput);
        add(buyerNameLabel);
        add(emailInput);
        add(emailLabel);
        add(applyDiscount);
        add(shippingInput);
        add(shippingLabel);
        add(save);

        applyDiscount.addActionListener(this);
    }

    public void updateValues(int n) {
        enterName.setText(CustomerCatalogPage.catalogElementsCus.get(n).getName());
        ImageIcon image = new ImageIcon(CustomerCatalogPage.catalogElementsCus.get(n).getImagePath());
        Image iiImage1 = image.getImage();
        Image iiImage = iiImage1.getScaledInstance(560, 745, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(iiImage);
        showImage.setIcon(image);
        showImage.setVisible(true);
        allGemsWeightInput.setText(""+CustomerCatalogPage.catalogElementsCus.get(n).getGemWeight());
        costOfGemsInput.setText(String.format("%.2f", CustomerCatalogPage.catalogElementsCus.get(n).getGemCost()));
        totalPriceInput.setText(String.format("%.2f", CustomerCatalogPage.catalogElementsCus.get(n).getTotalCost()));
        totalWeightInput.setText(""+CustomerCatalogPage.catalogElementsCus.get(n).getTotalWeight());
        makingChargesInput.setText(String.format("%.2f", CustomerCatalogPage.catalogElementsCus.get(n).getTotalCost()));
        kdmInput.setText(String.format("%.2f", CustomerCatalogPage.catalogElementsCus.get(n).getKDM()));
        typeOfJewelryInput.setText(""+CustomerCatalogPage.catalogElementsCus.get(n).getTypeOfJewelry());
        finalPrice = CustomerCatalogPage.catalogElementsCus.get(n).getTotalCost();

    }

    public void setFinalPriceInput(double discount) {
        finalPriceInput.setText(String.format("%.2f", finalPrice - discount));
        finalPrice = finalPrice - discount;
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == applyDiscount) {
            if(cashDiscountInput.getText().equals("") || cashDiscountInput.getText().equals("0")) {
                setFinalPriceInput(0);
            } else {
                try {
                    Double cashDiscount = Double.parseDouble(cashDiscountInput.getText());
                    setFinalPriceInput(cashDiscount);
                } catch (Exception ey) {
                    incorrectLabel.setVisible(true);
                }
            }
        }
    }
}
