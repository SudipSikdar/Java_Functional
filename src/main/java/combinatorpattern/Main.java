package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "x@x.com",
                "+012345678",
                LocalDate.of(2000,4,21)
        );


        //System.out.println(new ValidationService().isValid(customer));

        // Using combonator pattern

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if(result != SUCCESS){
            throw new IllegalStateException(result.name());
        }

    }
}
