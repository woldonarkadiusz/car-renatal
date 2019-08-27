package com.carrental.controller;
import com.carrental.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    public final AccountService accountService;

    @GetMapping("/list")
    public String showMoney(Model model){
        List<AccountService.AccountSummary> accounts = accountService.getMoneyFromBookings();
        Optional<Double> sumOfMoney = accountService.sumMoney();
        model.addAttribute("accounts", accounts);
        model.addAttribute("sumOfMoney" , sumOfMoney);
        return "account/list";
    }
}