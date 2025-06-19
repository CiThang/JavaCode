package Yelp_Model;

public class YelpPrimaryKey {

    private static YelpPrimaryKey instance;
    private String taikhoan;
    private String gmail;

    // Private constructor để ngăn việc tạo đối tượng từ bên ngoài lớp
    public YelpPrimaryKey() {
        // Không cần thực hiện gì trong constructor này
    }

    // Phương thức getInstance() để trả về đối tượng duy nhất của lớp
    public static synchronized YelpPrimaryKey getInstance() {
        if (instance == null) {
            // Tạo đối tượng chỉ một lần khi instance là null
            instance = new YelpPrimaryKey();
        }
        return instance;
    }

    // Getter và setter cho taikhoan
    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    // Getter và setter cho gmail
    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
