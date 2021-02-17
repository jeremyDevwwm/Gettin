package com.otp.gettin.gettin.Controllers;

import com.otp.gettin.gettin.Services.UserGettinServices;
import com.otp.gettin.gettin.Utils.EncryptionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerFront {

    @Autowired
    UserGettinServices userGettinServices;

    EncryptionClass encryptionClass = new EncryptionClass();

    @GetMapping("/Accueil.html")
        public void showAccueil(Model model){
        model.addAttribute("nickname", encryptionClass.Decrypt(userGettinServices.findConnectedUserGettinByLogin().getUserNickname()));
    }
}
