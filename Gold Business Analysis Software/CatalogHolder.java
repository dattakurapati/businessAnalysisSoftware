import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CatalogHolder extends JButton {
    private ImageIcon image;
    private double gemsWeight;
    private double total;
    private double costGems;
    private double cost;
    private String typeOfJewelry;
    private String uniqueID;
    private String name;
    private Double quantity;
    private String imagePath;
    private double kdm;
    private double makingCharges;
    private double finalPrice;
    private double finalProfit;
    private double absoluteWeight;
    private int sold;

    public CatalogHolder(String imagePathInput, double allGemsWeight, double totalWeight, 
    double costOfGems, String type, String n, double quantityInput) {

        gemsWeight = allGemsWeight;
        total = totalWeight;
        costGems = costOfGems;
        typeOfJewelry = type;
        name = n;
        quantity = quantityInput;
        imagePath = imagePathInput;
        finalPrice = 0;
        finalProfit = 0;
        image = new ImageIcon(imagePath);
        Image iiImage1 = image.getImage();
        Image iiImage = iiImage1.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(iiImage);

        double netWeight = total - gemsWeight;
        double plusKDM = (netWeight * 0.15) + netWeight;
        double totalNetWeightCost = plusKDM * AdminStockPage.goldPrice;
        kdm = totalNetWeightCost;
        double finalPriceWithoutDiscount = totalNetWeightCost + (totalNetWeightCost * 0.08) + costGems;
        makingCharges = totalNetWeightCost * 0.08;

        cost = finalPriceWithoutDiscount;

        uniqueID = "";

        absoluteWeight = quantity * total;

        Character toAdd;

        sold = 0;

        for(int i = 0; i < 10; i++) {
            int random = (int)(Math.random() * 75) + 48;
            toAdd = (char) random;
            while(true) {
                if(Character.isDigit(toAdd) || Character.isLetter(toAdd) ) {
                    break;
                } else {
                    random = (int)(Math.random() * 75) + 48;
                    toAdd = (char) random;  
                }
            }
            uniqueID += toAdd;
        }

        // Code for Selling Price and Profit Calculations:
        // double netWeight = totalWeight - weightOfGems;
        // double plusKDM = (netWeight * 0.15) + netWeight;
        // double totalNetWeightCost = plusKDM * AdminStockPage.goldPrice;
        // double finalPriceWithoutDiscount = totalNetWeightCost + (totalNetWeightCost * 0.08) + costOfGems;
        // System.out.println(netWeight);
        // System.out.println(plusKDM);
        // System.out.println(totalNetWeightCost);
        // System.out.println(finalPriceWithoutDiscount);
        // double profit = ((netWeight * 0.07) * AdminStockPage.goldPrice) + (totalNetWeightCost * 0.08 * 0.9) + (0.6 * costOfGems) - (finalPriceWithoutDiscount * 0.02);
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public double getMakingCharges() {
        return makingCharges;
    }

    public double getKDM() {
        return kdm;
    }

    public String getImagePath() {
        return imagePath;
    }

    public double getGemWeight() {
        return gemsWeight;
    }

    public double getTotalCost() {
        return cost;
    }

    public double getTotalWeight() {
        return total;
    }

    public ImageIcon getImage() {
        return image;
    }

    public double getGemCost() {
        return costGems;
    }

    public String getName() {
        return name;
    }

    public String getTypeOfJewelry() {
        return typeOfJewelry;
    }

    public void setGemsWeight(double weightgem) {
        gemsWeight = weightgem;
    }

    public void setTotalWeight(double totalWeight) {
        total = totalWeight;
    }

    public void setQuantity() {
        quantity--;
        absoluteWeight -= total;
        sold++;
    }

    public int getSold() {
        return sold;
    }

    public double getAbsoluteWeight() {
        return absoluteWeight;
    }


    public void setCostOfGems(double costg) {
        costGems = costg;
    }

    public void setName(String n) {
        name = n;
    }

    public void setType(String ty) {
        typeOfJewelry = ty;
    }
    
    public double getQuantity() {
        return quantity;
    }

    public void setImagePath(String im) {
        imagePath = im;
    }

    public void setFinal(double fin) {
        finalPrice = fin;
        profitCalc();
    }

    public void profitCalc() {
        double profit = (((total - gemsWeight) * 0.07) * AdminStockPage.goldPrice) + (kdm * 0.08 * 0.9) + (0.6 * costGems) - (finalPrice * 0.02);
        finalProfit += profit;
    }

    public double getProfit() {
        return finalProfit;
    }

    public void reCalculate() {
        double netWeight = total - gemsWeight;
        double plusKDM = (netWeight * 0.15) + netWeight;
        double totalNetWeightCost = plusKDM * AdminStockPage.goldPrice;
        double finalPriceWithoutDiscount = totalNetWeightCost + (totalNetWeightCost * 0.08) + costGems;

        cost = finalPriceWithoutDiscount;
    }
}