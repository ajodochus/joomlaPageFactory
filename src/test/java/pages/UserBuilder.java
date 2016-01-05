package pages;


public class UserBuilder {
    public static User admin() {
        User user = new User("admin", "admin");       
        user.setFname("Bernd");
        user.setLname("Wissmeier");
        return user;
    }

    public static User randomUser() {
        String uuid = Utils.getUUID();
        User user = new User("User_" + uuid, "admin");
        user.setFname("Hans" + uuid);
        user.setLname("Fritz" + uuid);
        return user;
    }
}
