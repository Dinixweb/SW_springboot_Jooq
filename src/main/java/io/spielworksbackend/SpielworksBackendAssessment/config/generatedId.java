package io.spielworksbackend.SpielworksBackendAssessment.config;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class generatedId {

    public String generatedId(){
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 2) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
