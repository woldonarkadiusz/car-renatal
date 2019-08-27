package com.carrental.service;
import com.carrental.domain.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.time.temporal.ChronoUnit.DAYS;
@Service
@RequiredArgsConstructor
public class AccountService {
    private final BookingRepository bookingRepository;
    public List<AccountSummary> getMoneyFromBookings() {
        return bookingRepository.findAll().stream()
                .map(booking -> {
                    Double amount = booking.getCar().getPricePerDay() * DAYS.between(booking.getBeginningOfRent(),
                            booking.getEndOfRent());
                    Integer id = booking.getId();
                    return new AccountSummary(amount, id);
                })
                .collect(Collectors.toList());
    }

    public Optional<Double> sumMoney(){
        List<Double> sum = getMoneyFromBookings().stream()
                .map(accountSummary -> accountSummary.amount)
                .collect(Collectors.toList());
        Optional<Double> suma = sum.stream()
                .reduce((a, b) -> a + b);
        return suma;
    }

    @Data
    @AllArgsConstructor
    public static class AccountSummary {
        private Double amount;
        private Integer bookingId;
    }
}