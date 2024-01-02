package com.universe.app;

import com.universe.data_access.FileUserDataAccessObject;
import com.universe.entity.user.CommonUserFactory;
import com.universe.entity.user.LoggedInUser;
import com.universe.entity.user.UserFactory;
import com.universe.interface_adapter.signup.SignupController;
import com.universe.interface_adapter.signup.SignupPresenter;
import com.universe.use_case.signup.SignupInputBoundary;
import com.universe.use_case.signup.SignupInteractor;
import com.universe.use_case.signup.SignupOutputBoundary;
import com.universe.use_case.signup.SignupUserDataAccessInterface;
import com.universe.view.User.SignupServlet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

public class SignupSetup {
    public static SignupController setup(SignupServlet signupServlet) throws IOException {
        UserFactory userFactory = new CommonUserFactory();
        FileUserDataAccessObject userDataAccessObject = DataAccessBuilder.getFileUserDataAccessObject();

        SignupOutputBoundary presenter = new SignupPresenter(signupServlet);
        SignupInputBoundary interactor = new SignupInteractor(presenter, userFactory, userDataAccessObject);

        return new SignupController(interactor);
    }

}
