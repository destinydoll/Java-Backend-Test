package com.example.test.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.test.DTO.User;
import com.example.test.Respiritory.UserRespiritory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRespiritory repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateReferenceCodeFromDateAndPhone(Date RegisteredDate, String phone) {
        DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
        String lastFourDigits = phone.substring(phone.length() - 4);
        String strDate = dateFormat.format(RegisteredDate);
        String refCode = String.format("%s%s", strDate, lastFourDigits);
        return refCode;
    }

    public String generateMemberTypeFromSalary(int salary) {
        String memberType = "";
        if (salary > 50000) {
            memberType = "Platinum";
        } else if (salary > 30000) {
            memberType = "Gold";
        } else if (salary > 15000) {
            memberType = "Silver";
        }
        return memberType;
    }

    @Override
    public Boolean RegisterUser(User user) {
        user.setMemberType(generateMemberTypeFromSalary(user.getSalary()));
        // set date
        Date today = new Date();
        String refcode = generateReferenceCodeFromDateAndPhone(today, user.getPhone());

        user.setRegisterDate(today);
        user.setRefcode(refcode);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userSaved = repository.save(user);
        Boolean isSaved;
        isSaved = userSaved != null;
        return isSaved;
    }

    @Override
    public User findUserByUsername(String userName) {
        User matched = repository.findByUserName(userName);
        return matched;
    }

    @Override
    public boolean hasMatchedUsername(String username) {
        User matched = repository.findByUserName(username);
        return matched != null;
    }

    @Override
    public List<User> FindAllUser() {
        List<User> list = repository.findAll();
        return list;
    }

}
