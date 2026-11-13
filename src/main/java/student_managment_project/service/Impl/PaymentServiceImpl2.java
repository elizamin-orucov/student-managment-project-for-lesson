package student_managment_project.service.Impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import student_managment_project.service.PaymentService;

@Primary
@Service("cardPayment")
public class PaymentServiceImpl2 implements PaymentService {
    @Override
    public String pay(Double amount) {
        return "Impl 2 klass\ncard payment";
    }
}
