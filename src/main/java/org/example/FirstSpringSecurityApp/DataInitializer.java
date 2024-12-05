//package org.example.FirstSpringSecurityApp;
//
//import org.example.FirstSpringSecurityApp.services.PasswordEncryptionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final PasswordEncryptionService passwordEncryptionService;
//
//    @Autowired
//    public DataInitializer(PasswordEncryptionService passwordEncryptionService) {
//        this.passwordEncryptionService = passwordEncryptionService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        passwordEncryptionService.encryptPasswords();
//    }
//}
