import javax.swing.JLabel;

public class CustomerInformation extends JLabel {
    private String name;
    public CustomerInformation(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }
}
