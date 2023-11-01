import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.*;

public class EditData extends JPanel implements ActionListener {
    CustomerCatalogPage catCus;
    AdminCatalogPage catalog;
    ProjectWindow window;
    AdminInventoryPage inventory;
    JLabel backButton;
    JTextField enterName;
    JButton getPicture;
    ImageIcon display;
    JLabel showImage;
    JLabel allGemsWeightLabel;
    JLabel totalWeightLabel;
    JLabel costOfGemsLabel;
    JLabel typeOfJewelryLabel;
    JLabel quantityLabel;
    JTextField allGemsWeightInput;
    JTextField totalWeightInput;
    JTextField costOfGemsInput;
    JTextField quantityInput;
    JComboBox<String> typeInput;
    JLabel incorrectLabel;
    JLabel save;
    JLabel remove;
    public static int focus;
    String filename;
    
    public EditData(ProjectWindow w, AdminCatalogPage catalogPage, CustomerCatalogPage c, AdminInventoryPage inven) {
        window = w;
        catalog = catalogPage;
        catCus = c;
        inventory = inven;
        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));

        backButton = new JLabel();
        backButton.setBounds(20, 20, 50, 50);
        backButton.setIcon(new ImageIcon("Images/BackButton.png"));
        backButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                allGemsWeightInput.setText("Enter Total Weight of All Gems");
                totalWeightInput.setText("Enter Total Weight");
                costOfGemsInput.setText("Enter Total Cost of All Gems");
                quantityInput.setText("Enter Quantity");
                enterName.setText("Enter Product Name");
                showImage.setIcon(null);
                window.whenClickedBackEdit();
            }
        });

        enterName = new JTextField("Enter Product Name");
        enterName.setEditable(true);
        enterName.setBounds(200, 10, 800, 70);
        enterName.setHorizontalAlignment(JLabel.CENTER);
        enterName.setFont(new Font("Sans", Font.PLAIN, 35));
        enterName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (enterName.getText().equals("Enter Product Name")) {
                    enterName.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (enterName.getText().equals("")) {
                    enterName.setText("Enter Product Name");
                }
            }
        });


        getPicture = new JButton("Add/Change Image");
        getPicture.setBounds(20, 95, 560, 40);
        
        showImage = new JLabel();
        showImage.setBounds(20, 145, 560, 610);
        showImage.setVisible(false);

        typeOfJewelryLabel = new JLabel("Type of Jewelry: ");
        typeOfJewelryLabel.setBounds(680, 95, 200, 40);
        typeOfJewelryLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        typeOfJewelryLabel.setForeground(Color.WHITE);

        quantityLabel = new JLabel("Quantity: ");
        quantityLabel.setBounds(680, 145, 200, 40);
        quantityLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        quantityLabel.setForeground(Color.WHITE);

        totalWeightLabel = new JLabel("Total Weight: ");
        totalWeightLabel.setBounds(680, 195, 200, 40);
        totalWeightLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        totalWeightLabel.setForeground(Color.WHITE);

        allGemsWeightLabel = new JLabel("Weight of Gems: ");
        allGemsWeightLabel.setBounds(680, 245, 150, 40);
        allGemsWeightLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        allGemsWeightLabel.setForeground(Color.WHITE);

        costOfGemsLabel = new JLabel("Cost of Gems: ");
        costOfGemsLabel.setBounds(680, 295, 200, 40);
        costOfGemsLabel.setFont(new Font("Sans", Font.PLAIN, 17));
        costOfGemsLabel.setForeground(Color.WHITE);

        String[] types = {"Chains", "Bracelets", "Rings", "Ear Rings", "Other"};
        typeInput = new JComboBox<>(types);
        typeInput.setBounds(825, 101, 340, 30);
        typeInput.setFont(new Font("Sans", Font.PLAIN, 15));

        quantityInput = new JTextField("Enter Quantity");
        quantityInput.setEditable(true);
        quantityInput.setBounds(825, 151, 340, 35);
        quantityInput.setFont(new Font("Sans", Font.PLAIN, 15));
        quantityInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (quantityInput.getText().equals("Enter Quantity")) {
                    quantityInput.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (quantityInput.getText().equals("")) {
                    quantityInput.setText("Enter Quantity");
                }
            }
        });

        totalWeightInput = new JTextField("Enter Total Weight");
        totalWeightInput.setEditable(true);
        totalWeightInput.setBounds(825, 201, 340, 30);
        totalWeightInput.setFont(new Font("Sans", Font.PLAIN, 15));
        totalWeightInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (totalWeightInput.getText().equals("Enter Total Weight")) {
                    totalWeightInput.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (totalWeightInput.getText().equals("")) {
                    totalWeightInput.setText("Enter Total Weight");
                }
            }
        });

        allGemsWeightInput = new JTextField("Enter Total Weight of All Gems");
        allGemsWeightInput.setEditable(true);
        allGemsWeightInput.setBounds(825, 251, 340, 30);
        allGemsWeightInput.setFont(new Font("Sans", Font.PLAIN, 15));
        allGemsWeightInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (allGemsWeightInput.getText().equals("Enter Total Weight of All Gems")) {
                    allGemsWeightInput.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (allGemsWeightInput.getText().equals("")) {
                    allGemsWeightInput.setText("Enter Total Weight of All Gems");
                }
            }
        });


        costOfGemsInput = new JTextField("Enter Total Cost of All Gems");
        costOfGemsInput.setEditable(true);
        costOfGemsInput.setBounds(825, 301, 340, 30);
        costOfGemsInput.setFont(new Font("Sans", Font.PLAIN, 15));
        costOfGemsInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (costOfGemsInput.getText().equals("Enter Total Cost of All Gems")) {
                    costOfGemsInput.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (costOfGemsInput.getText().equals("")) {
                    costOfGemsInput.setText("Enter Total Cost of All Gems");
                }
            }
        });

        incorrectLabel = new JLabel("<html>Make sure there are no symbols or letters in input.<br>Make sure uploaded file is either .png or .jpeg.</html>");
        incorrectLabel.setBounds(680, 351, 500, 60);
        incorrectLabel.setFont(new Font("Sans", Font.PLAIN, 15));
        incorrectLabel.setForeground(Color.red);
        incorrectLabel.setVisible(false);

        save = new JLabel();
        save.setBounds(687, 700, 150, 45);
        save.setIcon(new ImageIcon("Images/SaveButton.png"));
        save.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Double weightOfGems = Double.parseDouble(allGemsWeightInput.getText());
                    Double totalWeight = Double.parseDouble(totalWeightInput.getText());
                    Double costOfGems = Double.parseDouble(costOfGemsInput.getText());
                    // Double makingChargesNumber = Double.parseDouble(makingCharges.getText());
                    // Double kdmNumber = Double.parseDouble(kdm.getText());
                    // Double cashDiscountNumber = Double.parseDouble(cashDiscount.getText());
                    Double quantityNumber = Double.parseDouble(quantityInput.getText());
                    
                    if(!(filename.substring(filename.length()-4, filename.length()).equals(".png")) && 
                    !(filename.substring(filename.length()-5, filename.length()).equals(".jpeg"))){
                        throw new Exception("error");
                    } else {
                        incorrectLabel.setVisible(false);
                    }

                    if(enterName.getText().equals("Enter Product Name")){
                        throw new Exception("error");
                    }

                    AdminCatalogPage.catalogElements.get(focus).setVisible(false);
                    AdminCatalogPage.catalogElements.remove(focus);
                    AdminCatalogPage.catalogElements.add(focus, new CatalogHolder(filename, weightOfGems, totalWeight, 
                    costOfGems, (String) typeInput.getSelectedItem(), enterName.getText(), quantityNumber));
                    CustomerCatalogPage.catalogElementsCus.get(focus).setVisible(false);
                    CustomerCatalogPage.catalogElementsCus.remove(focus);
                    CustomerCatalogPage.catalogElementsCus.add(focus, new CatalogHolder(filename, weightOfGems, 
                    totalWeight, costOfGems, (String) typeInput.getSelectedItem(), enterName.getText(), quantityNumber));
                    
                    catalog.reUpdate();
                    catCus.reUpdate();
                    inventory.update();

                    allGemsWeightInput.setText("Enter Total Weight of All Gems");
                    totalWeightInput.setText("Enter Total Weight");
                    costOfGemsInput.setText("Enter Total Cost of All Gems");
                    quantityInput.setText("Enter Quantity");
                    showImage.setIcon(null);
                    incorrectLabel.setVisible(false);
                    enterName.setText("Enter Product Name");
                    window.whenClickedBackEdit();
                    
                } catch (Exception ex){
                    incorrectLabel.setVisible(true);
                }
            }
        });

        remove = new JLabel();
        remove.setBounds(857, 700, 150, 45);
        remove.setIcon(new ImageIcon("Images/RemoveButton.png"));
        remove.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    AdminCatalogPage.catalogElements.get(focus).setVisible(false);
                    AdminCatalogPage.catalogElements.remove(focus);
                    CustomerCatalogPage.catalogElementsCus.get(focus).setVisible(false);
                    CustomerCatalogPage.catalogElementsCus.remove(focus);
                    catalog.reUpdate();
                    catCus.reUpdate();
                    inventory.update();
                    allGemsWeightInput.setText("Enter Total Weight of All Gems");
                    totalWeightInput.setText("Enter Total Weight");
                    costOfGemsInput.setText("Enter Total Cost of All Gems");
                    quantityInput.setText("Enter Quantity");
                    showImage.setIcon(null);
                    incorrectLabel.setVisible(false);
                    enterName.setText("Enter Product Name");
                    window.whenClickedBackEdit();
                } catch (Exception ex){
                    incorrectLabel.setVisible(true);
                }
            }
        });
        
        add(backButton);
        add(enterName);
        add(getPicture);
        add(showImage);
        add(allGemsWeightLabel);
        add(totalWeightLabel);
        add(costOfGemsLabel);
        add(typeOfJewelryLabel);
        add(quantityLabel);
        add(allGemsWeightInput);
        add(totalWeightInput);
        add(costOfGemsInput);
        add(quantityInput);
        add(incorrectLabel);
        add(save);
        add(typeInput);
        add(remove);
        
        getPicture.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == getPicture) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            final File f = chooser.getSelectedFile();
            filename = f.getAbsolutePath();

            SwingWorker sw = new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    Thread.sleep(100);
                    display = new ImageIcon(f.getAbsolutePath());

                    Image displayImage1 = display.getImage();
                    Image displayImage = displayImage1.getScaledInstance(560, 715, java.awt.Image.SCALE_SMOOTH);
                    display = new ImageIcon(displayImage);

                    return null;
                }

                @Override
                protected void done() { 
                    super.done();
                    showImage.setVisible(true);
                    showImage.setIcon(display);
                }
            };
            sw.execute();
        }
    }
}