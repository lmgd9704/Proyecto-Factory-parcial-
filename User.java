public class User {

    private String userId;
    private String username;

    public User(String id, String name) {
        this.userId = id;
        this.username = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
