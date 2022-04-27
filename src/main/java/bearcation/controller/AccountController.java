package bearcation.controller;

import bearcation.model.dto.UserDTO;
import bearcation.model.requests.CreateAccountRequest;
import bearcation.model.requests.LoginRequest;
import bearcation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginRequest loginRequest) {
        return accountService.login(loginRequest);
    }

    @PostMapping("/createAccount")
    public UserDTO createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        return accountService.createAccount(createAccountRequest);
    }
}
