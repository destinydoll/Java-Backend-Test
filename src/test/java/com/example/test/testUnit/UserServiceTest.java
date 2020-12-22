/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.testUnit;

import com.example.test.DTO.User;
import com.example.test.Respiritory.UserRespiritory;
import com.example.test.Service.UserServiceImpl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {

    @InjectMocks
    @Spy
    UserServiceImpl userService;

    @Mock
    UserRespiritory repository;

    @Mock
    private PasswordEncoder passwordEncoder;

//    @Mock
//    private User mockUser;
    @Test
    private void generateReferenceCodeFromDateAndPhoneTest() {
        try {
            Date dateTest = new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2020");
            String phone = "0968881111";
            String refCode = userService.generateReferenceCodeFromDateAndPhone(dateTest, phone);
            assertEquals("202001101111", refCode);
        } catch (ParseException ex) {
            Logger.getLogger(UserServiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    private void generateMemberTypeFromSalaryTest() {

        int salaryPlat = 50001;
        String memtypePlat = userService.generateMemberTypeFromSalary(salaryPlat);
        assertEquals("Platinum", memtypePlat);

        int salaryGold = 50000;
        String memtypeGold = userService.generateMemberTypeFromSalary(salaryGold);
        assertEquals("Gold", memtypeGold);

        int salarySilver = 30000;
        String memtypeSilver = userService.generateMemberTypeFromSalary(salarySilver);
        assertEquals("Silver", memtypeSilver);

        int reject = 15000;
        String memtypeReject = userService.generateMemberTypeFromSalary(reject);
        assertEquals("", memtypeReject);
    }

    @Test
    public void RegisterUserTest() {
        User mockRegister = new User(new Long(1), "testUser", "testpwd", "testEmail", 50000, "testPhone");
        when(repository.save(mockRegister)).thenReturn(mockRegister);

        Boolean isSaved = userService.RegisterUser(mockRegister);
        verify(repository, times(1)).save(mockRegister);
        assertEquals(true, isSaved);
    }
//

    @Test
    public void findUserByUsernameTest() {
        User mockReturnUser = new User(new Long(1), "testUser", "testpwd", "testEmail", 50000, "testPhone");

        when(userService.findUserByUsername("testUser")).thenReturn(mockReturnUser);
        User findUserByUsername = userService.findUserByUsername("testUser");
        assertEquals(mockReturnUser.getUserName(), findUserByUsername.getUserName());

    }

//    @Test
//    public void FindAllUserTest() {
//        ArrayList<User> testlist = new ArrayList<User>();
//        testlist.add(mockUser);
//        when(userService.FindAllUser()).thenReturn(testlist);
//    }
}
