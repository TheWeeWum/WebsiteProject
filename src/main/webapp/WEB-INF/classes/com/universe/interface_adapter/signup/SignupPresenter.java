package com.universe.interface_adapter.signup;

import com.universe.use_case.signup.SignupOutputBoundary;
import com.universe.use_case.signup.SignupOutputData;
import com.universe.view.User.SignupServlet;

import javax.servlet.ServletException;
import java.io.IOException;

public class SignupPresenter implements SignupOutputBoundary {
    SignupServlet signupServlet;

    public SignupPresenter(SignupServlet signupServlet) {

        this.signupServlet = signupServlet;
    }


    public void prepareFailView(String error) {
        System.out.println("SignupPresenter.prepareFailView: error = " + error); //for testing purposes
        try {
            signupServlet.signupFailed(error);
        } catch (IOException | ServletException e) {
            System.out.println("Error in sending user to SignUp Screen");
        }
    }
    public void prepareSuccessView(SignupOutputData outputData) {
        try {
            signupServlet.sendToProfileScreen(outputData);
        } catch (IOException e) {
            System.out.println("Error in sending user to ProfileScreen");
        }
    }
}
