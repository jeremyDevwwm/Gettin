package com.otp.gettin.gettin.Services;

import com.otp.gettin.gettin.Entities.UserGettin;
import com.otp.gettin.gettin.Repositories.UserGettinRepository;
import com.otp.gettin.gettin.Utils.EncryptionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserGettinServices implements UserDetailsService {

    @Autowired
    UserGettinRepository userGettinRepository;

    @Autowired
    GroupGettinServices groupGettinServices;

    @Autowired
    PasswordEncoder passwordEncoder;

    EncryptionClass encryptionClass;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserGettin user = userGettinRepository.findByUserLogin(s);


        if(user == null){
            System.out.println("Ca ne voit rien");
            throw new UsernameNotFoundException("Ce login n'existe pas" + s);
        } else{
            System.out.println("Connect OK");
            return new User(user.getUserLogin(), user.getUserPassword(), new ArrayList<>());

        }
    }


    public UserGettin saveUserGettin(UserGettin userGettin){
        UserGettin templateUserGettin = new UserGettin();
        encryptionClass = new EncryptionClass();

        templateUserGettin.setUserNickname(encryptionClass.Encrypt(userGettin.getUserNickname()));
        templateUserGettin.setUserMail(encryptionClass.Encrypt(userGettin.getUserMail()));
        templateUserGettin.setUserLogin(userGettin.getUserLogin());
        templateUserGettin.setUserPassword(passwordEncoder.encode(userGettin.getUserPassword()));
        templateUserGettin.setUserRole(1);
        templateUserGettin.setGroupGettin(groupGettinServices.findSingleGroupGettin(5));
        return userGettinRepository.save(templateUserGettin);

    }

    public UserGettin findConnectedUserGettinByLogin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userGettinRepository.findByUserLogin(authentication.getName());
    }
}
