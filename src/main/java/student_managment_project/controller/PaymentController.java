package student_managment_project.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student_managment_project.service.PaymentService;

@RestController
@RequestMapping("/api/public/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(
            @Qualifier("cashPayment") PaymentService paymentService
    ) {
        this.paymentService = paymentService;
    }

    @GetMapping("/pay")
    public ResponseEntity<String> pay(){

        String response = paymentService.pay(5.5);

        return ResponseEntity.ok(response);
    }
}
