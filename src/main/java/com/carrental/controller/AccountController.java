package com.carrental.controller;
import com.carrental.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    public final AccountService accountService;

    @GetMapping("/list")
    public String showMoney(Model model){
        List<AccountService.AccountSummary> accounts = accountService.getMoneyFromBookings();
        model.addAttribute("accounts", accounts);
        return "account/list";
    }
}