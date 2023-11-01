import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProjectWindow extends JFrame {
    private UserSelectionPage user;
    private AdminLoginPage adminLogin;
    private AdminStockPage adminStockPage;
    private AdminCatalogPage adminCatalogPage;
    private AdminProfitPage adminProfitPage;
    private AdminInventoryPage adminInventoryPage;
    private AdminCustomerDetailsPage adminCustomerDetailsPage;
    private CustomerStockPage customerStockPage;
    private CustomerCatalogPage customerCatalogPage;
    private AddToCatalog addToCatalogPage;
    private CustomerPurchaseView customerPurchaseViewPage;
    public static EditData editData;

    public ProjectWindow() {
        setSize(1200, 800);
        setTitle("IB Computer Science SL IA");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        user = new UserSelectionPage(this);
        adminLogin = new AdminLoginPage(this);
        adminCatalogPage = new AdminCatalogPage(this);
        adminProfitPage = new AdminProfitPage(this);
        adminCustomerDetailsPage = new AdminCustomerDetailsPage(this);
        adminInventoryPage = new AdminInventoryPage(this);
        customerStockPage = new CustomerStockPage(this);
        customerPurchaseViewPage = new CustomerPurchaseView(this, adminInventoryPage, adminProfitPage, adminCustomerDetailsPage);
        customerCatalogPage = new CustomerCatalogPage(this, customerPurchaseViewPage);
        adminStockPage = new AdminStockPage(this, adminCatalogPage, customerCatalogPage);
        addToCatalogPage = new AddToCatalog(this, adminCatalogPage, customerCatalogPage, adminInventoryPage);
        editData = new EditData(this, adminCatalogPage, customerCatalogPage, adminInventoryPage);


        add(user);
        add(adminLogin);
        add(adminStockPage);
        add(adminCatalogPage);
        add(adminProfitPage);
        add(adminCustomerDetailsPage);
        add(adminInventoryPage);
        add(customerStockPage);
        add(customerCatalogPage);
        add(addToCatalogPage);
        add(editData);
        add(customerPurchaseViewPage);
        
        adminLogin.setVisible(false);
        adminStockPage.setVisible(false);
        adminCatalogPage.setVisible(false);
        adminProfitPage.setVisible(false);
        adminInventoryPage.setVisible(false);
        adminCustomerDetailsPage.setVisible(false);
        customerStockPage.setVisible(false);
        customerCatalogPage.setVisible(false);
        addToCatalogPage.setVisible(false);
        editData.setVisible(false);
        customerPurchaseViewPage.setVisible(false);

        setVisible(true);
    }

    public void whenClickedBack() {
        addToCatalogPage.setVisible(false);
        adminCatalogPage.setVisible(true);
    }

    public void whenClickedBackCustomer() {
        customerPurchaseViewPage.setVisible(false);
        customerCatalogPage.setVisible(true);
    }

    public void whenClickedCustomerPurchaseView(JPanel obj) {
        obj.setVisible(false);
        customerPurchaseViewPage.setVisible(true);
    }

    public void whenClickedBackEdit() {
        editData.setVisible(false);
        adminCatalogPage.setVisible(true);
    }

    public void whenClickedAdmin() {
        user.setVisible(false);
        adminLogin.setVisible(true);
    }

    public void whenClickedCustomer() {
        user.setVisible(false);
        customerStockPage.setVisible(true);
    }

    public void whenClickedLogin() {
        adminLogin.setVisible(false);
        adminStockPage.setVisible(true);
    }
    public void openAdminCatalogPage(JPanel obj) {
        obj.setVisible(false);
        adminCatalogPage.setVisible(true);
        adminCatalogPage.validate();
    }

    public void openAdminCatalogPage2(JPanel obj) {
        obj.setVisible(false);
        obj.invalidate();
        addToCatalogPage.validate();
        adminCatalogPage.setVisible(true);
        addToCatalogPage.validate();
        
    }

    public void openAdminProfitPage(JPanel obj) {
        obj.setVisible(false);
        adminProfitPage.setVisible(true);
    }
    public void openAdminCustomerDetailsPage(JPanel obj) {
        obj.setVisible(false);
        adminCustomerDetailsPage.setVisible(true);
    }
    public void openAdminInventoryPage(JPanel obj) {
        obj.setVisible(false);
        adminInventoryPage.setVisible(true);
    }
    public void openAdminStockPage(JPanel obj) {
        obj.setVisible(false);
        adminStockPage.setVisible(true);
    }
    public void openCustomerPage(JPanel obj) {
        obj.setVisible(false);
        customerStockPage.setVisible(true);
    }
    public void openCustomerCatalogPage(JPanel obj) {
        obj.setVisible(false);
        customerCatalogPage.setVisible(true);
    }
    public void openAdminPage(JPanel obj) {
        obj.setVisible(false);
        adminLogin.setVisible(true);
    }
    public void openAddCatalogPage(JPanel obj) {
        obj.setVisible(false);
        addToCatalogPage.setVisible(true);
    }
    public void openEditCatalogPage(JPanel obj) {
        obj.setVisible(false);
        editData.setVisible(true);
    }
}
