package student_managment_project.service.Impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import student_managment_project.service.PaymentService;

@Service("cashPayment")
public class PaymentServiceImpl1 implements PaymentService {
    @Override
    public String pay(Double amount) {
        return "Impl 1 klass\ncash payment";
    }
}
