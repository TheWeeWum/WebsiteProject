package com.universe.app;

import com.universe.data_access.FileUserDataAccessObject;
import com.universe.interface_adapter.login.LoginController;
import com.universe.interface_adapter.login.LoginPresenter;
import com.universe.use_case.login.LoginInputBoundary;
import com.universe.use_case.login.LoginInteractor;
import com.universe.use_case.login.LoginOutputBoundary;
import com.universe.view.User.LoginServlet;

import java.io.IOException;

public class LoginSetup {
    public static LoginController setup(LoginServlet loginServlet) throws IOException {
        FileUserDataAccessObject userDataAccessObject = DataAccessBuilder.getFileUserDataAccessObject();

        LoginOutputBoundary presenter = new LoginPresenter(loginServlet);
        LoginInputBoundary interactor = new LoginInteractor(presenter, userDataAccessObject);

        return new LoginController(interactor);
    }
}
