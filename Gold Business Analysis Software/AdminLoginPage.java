import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.Font;

public class AdminLoginPage extends JPanel implements ActionListener {
    ProjectWindow window;
    JLabel loginAdminButton;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField usernameArea;
    JPasswordField passwordArea;
    JButton submitButton;
    JLabel title;
    JLabel incorrectLabel;
    private String password = "1";
    private String username = "1";

    public AdminLoginPage(ProjectWindow w) {
        window = w;
        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(new Color(20, 33, 61));

        loginAdminButton = new JLabel();
        loginAdminButton.setSize(1200, 470);
        loginAdminButton.setHorizontalAlignment(JLabel.CENTER);
        loginAdminButton.setVerticalAlignment(JLabel.BOTTOM);
        loginAdminButton.setIcon(new ImageIcon("Images/ProfilePicture.png"));

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        usernameLabel.setSize(540, 540);
        usernameLabel.setHorizontalAlignment(JLabel.RIGHT);
        usernameLabel.setVerticalAlignment(JLabel.BOTTOM);
        usernameLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        usernameLabel.setForeground(Color.WHITE);

        passwordLabel.setSize(540, 590);
        passwordLabel.setHorizontalAlignment(JLabel.RIGHT);
        passwordLabel.setVerticalAlignment(JLabel.BOTTOM);
        passwordLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        passwordLabel.setForeground(Color.WHITE);

        usernameArea = new JTextField("Enter Username");
        passwordArea = new JPasswordField("Enter Password");

        usernameArea.setEditable(true);
        usernameArea.setBounds(550, 513, 200, 30);
        usernameArea.setFont(new Font("Sans", Font.PLAIN, 20));
        usernameArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameArea.getText().equals("Enter Username")) {
                    usernameArea.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (usernameArea.getText().equals("")) {
                    usernameArea.setText("Enter Username");
                }
            }
        });

        passwordArea.setEditable(true);
        passwordArea.setBounds(550, 563, 200, 30);
        passwordArea.setFont(new Font("Sans", Font.PLAIN, 20));
        passwordArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordArea.getText().equals("Enter Password")) {
                    passwordArea.setText("");
                }
                incorrectLabel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                if (passwordArea.getText().equals("")) {
                    passwordArea.setText("Enter Password");
                }
            }
        });

        submitButton = new JButton("Log In");
        submitButton.setFont(new Font("Sans", Font.PLAIN, 20));
        submitButton.setBounds(525, 650, 150, 50);

        title = new JLabel("Administrator Login");
        //title.setBounds(405, 85, 800, 50);
        title.setSize(1200, 90);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.BOTTOM);
        title.setFont(new Font("Sans", Font.PLAIN, 35));
        title.setForeground(Color.WHITE);

        incorrectLabel = new JLabel("Login failed. Make sure your username and password are correct.");
        incorrectLabel.setSize(1200, 740);
        incorrectLabel.setHorizontalAlignment(JLabel.CENTER);
        incorrectLabel.setVerticalAlignment(JLabel.BOTTOM);
        incorrectLabel.setFont(new Font("Sans", Font.PLAIN, 15));
        incorrectLabel.setForeground(Color.red);


        add(loginAdminButton);
        add(usernameLabel);
        add(usernameArea);
        add(passwordLabel);
        add(passwordArea);
        add(submitButton);
        add(title);
        add(incorrectLabel);

        incorrectLabel.setVisible(false);
        
        submitButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == submitButton) {
            if((String.valueOf(passwordArea.getPassword()).equals(password)) && (usernameArea.getText().equals(username))) {
                passwordArea.setText("Enter Password");
                usernameArea.setText("Enter Username");
                window.whenClickedLogin();
            } else {
                incorrectLabel.setVisible(true);
            }
        }
    }
}
