package utils;

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
    
    public static User invalidUser(){
    	User user = new User("wrong", "wrong");
    	user.setFname("fn_wrong");
    	user.setLname("ln_wrong");
    	return user;
    }
    public static User gta_user(){
    	User user = new User("wissmeier@googlemail.com", "gta1qay2wsx");
    	user.setFname("gta firstname");
    	user.setLname("gta lastname");
    	return user;
    }
}
