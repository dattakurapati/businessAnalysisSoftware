import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;


public class UserSelectionPage extends JPanel implements ActionListener {
    ProjectWindow window;
    JButton button1;
    JButton button2;
    ImageIcon userImage;
    JLabel selectAdminButton;
    JLabel selectUserButton;
    JLabel title;
    JLabel adminTitle;
    JLabel customerTitle;

    public UserSelectionPage(ProjectWindow w) {
        window = w;
        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));

        selectAdminButton = new JLabel();
        selectAdminButton.setBounds(200, 170, 360, 360);
        selectAdminButton.setIcon(new ImageIcon("Images/ProfilePicture.png"));
        customerTitle = new JLabel("Customer");
        customerTitle.setBounds(345, 515, 250, 50);
        customerTitle.setFont(new Font("Sans", Font.PLAIN, 17));
        customerTitle.setForeground(Color.WHITE);
        selectAdminButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        selectAdminButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                window.whenClickedCustomer();
            }
        });

        selectUserButton = new JLabel();
        selectUserButton.setBounds(640, 170, 360, 360);
        selectUserButton.setIcon(new ImageIcon("Images/ProfilePicture.png"));
        adminTitle = new JLabel("Administrator");
        adminTitle.setBounds(775, 515, 250, 50);
        adminTitle.setFont(new Font("Sans", Font.PLAIN, 17));
        adminTitle.setForeground(Color.WHITE);
        selectUserButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                window.whenClickedAdmin();
            }
        });

        title = new JLabel("H&H Gems and Jewelers");
        title.setBounds(405, 85, 800, 50);
        title.setFont(new Font("Sans", Font.PLAIN, 35));
        title.setForeground(Color.WHITE);

        add(selectAdminButton);
        add(selectUserButton);
        add(adminTitle);
        add(customerTitle);
        add(title);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == button1) {
            window.openCustomerPage(this);
        } else if (e.getSource() == button2) {
            window.openAdminPage(this);;
        }
   }
}
