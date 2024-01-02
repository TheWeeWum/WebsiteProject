package com.universe.interface_adapter.login;

import com.universe.use_case.login.LoginOutputBoundary;
import com.universe.use_case.login.LoginOutputData;
import com.universe.view.User.LoginServlet;
import com.universe.view.User.SignupServlet;

import javax.servlet.ServletException;
import java.io.IOException;

public class LoginPresenter implements LoginOutputBoundary {
    LoginServlet loginServlet;
    public LoginPresenter(LoginServlet loginServlet) {
        this.loginServlet = loginServlet;
    }

    @Override
    public void prepareFailView(String error) throws ServletException, IOException {
        loginServlet.signInFailed(error);
    }

    @Override
    public void prepareSuccessView(LoginOutputData outputData) throws IOException {
        loginServlet.sendToProfileScreen(outputData);
    }
}
