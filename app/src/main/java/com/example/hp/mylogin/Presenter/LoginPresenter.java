package com.example.hp.mylogin.Presenter;

import com.example.hp.mylogin.Model.User;
import com.example.hp.mylogin.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;

    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        if (loginCode == 0)
            loginView.onLoginError("You must Enter your Email");
        else if (loginCode == 1)
            loginView.onLoginError("You must Enter valid Email");
        else if (loginCode == 2)
            loginView.onLoginError("Password Length must be greater than 6");
        else
            loginView.onLoginSuccess("Login Success");


    }
}
