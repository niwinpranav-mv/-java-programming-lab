package deliveryapp;

public class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validateLogin(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
}
