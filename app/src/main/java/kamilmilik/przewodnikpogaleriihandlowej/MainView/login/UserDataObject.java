package kamilmilik.przewodnikpogaleriihandlowej.MainView.login;

/**
 * Created by kamil on 20.01.2018.
 */

public class UserDataObject {
    public UserDataObject(String email, String password){
        this.email = email;
        this.password = password;
    }
    private String email;
    private String password;
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
