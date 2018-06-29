package com.company.web;

import com.company.web.controller.UserController;
import com.company.web.entity.User;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class WebApplicationTests {

    /**
     * Tests the situation when the sender don't has enough money to send.
     */
    @Test(expected = java.lang.Exception.class)
    public void testTransferInsufficientMoney() throws Exception {
        UserController uc = new UserController();
        User user1 = new User();
        User user2 = new User();
        user1.setUsername("Cauwin");
        user2.setUsername("Ivona");
        user1.setBalance(4000);
        user2.setBalance(6000);

        uc.transferMoney(user1, user2, 5000);
        assertEquals(user1.getBalance(), 4000);
        assertEquals(user2.getBalance(), 6000);

    }
    /**
     * Tests the situation when the sender has enough money to send.
     */
    @Test
    public void testTransferSufficientMoney() throws Exception {
        UserController uc = new UserController();
        User user1 = new User();
        User user2 = new User();
        user1.setBalance(5000);
        user2.setBalance(6000);

        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());

        uc.transferMoney(user1, user2, 5000);
        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());
        assertEquals(user1.getBalance(), 0);
        assertEquals(user2.getBalance(), 11000);

    }

}