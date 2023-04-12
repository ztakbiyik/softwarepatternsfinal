package newpackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Configuration
@EnableAutoConfiguration
@ComponentScan

@Component
public class UserFormValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;

        // Check if username already exists
        if (userService.findByUsername(userForm.getUsername()) != null) {
            errors.rejectValue("username", "userForm.username", "Username already exists");
        }

        // Check if email already exists
        if (userService.findByEmail(userForm.getEmail()) != null) {
            errors.rejectValue("email", "userForm.email", "Email already exists");
        }

        // Check if password and confirm password match
        if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "userForm.confirmPassword", "Password and confirm password do not match");
        }
    }
}
