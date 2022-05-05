package bearcation.controller;

import bearcation.model.requests.LoginRequest;
import bearcation.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    AccountService accountService = mock(AccountService.class);
    LoginRequest loginRequest;

    @Before
    public void setUp(){
        //loginRequest = new LoginRequest("Yangzekun_Gao1@Baylor.edu", "123456");
        loginRequest = new LoginRequest("Yangzekun_Gao1@Baylor.edu", "123456", "customer");
    }

    // change the email value before each run in order to create a new account
    @DisplayName("create a new account")
    @Test
    public void createAccountTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/createAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"Yangzekun_Gao1@Baylor.edu\",\"password\":\"123456\",\"firstName\":\"Yangzekun\"," +
                        "\"lastName\":\"Gao\"}"))
                .andExpect(status().isOk());
    }

    @DisplayName("login test")
    @Test
    public void loginTest() throws Exception {

        when(accountService.login(loginRequest)).thenReturn(null);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"Yangzekun_Gao1@Baylor.edu\",\"password\":\"123456\"}"))
                .andExpect(status().isOk());
    }




}
