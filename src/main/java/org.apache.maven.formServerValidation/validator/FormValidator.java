package org.apache.maven.formServerValidation.validator;

import org.apache.maven.formServerValidation.AppProperties;
import org.apache.maven.formServerValidation.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import static org.springframework.util.StringUtils.isEmpty;

public class FormValidator implements Validator {
    private AppProperties appProperties;

    @Override
    public boolean supports(final Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(final Object object, final Errors errors) {
        User user = (User) object;
        if (isEmpty(user.getFirstName())) {
            errors.rejectValue("firstName", "submit.error.firstName.required");
        }
        if (user.getFirstName().length() < 2 || user.getFirstName().length() > 20) {
            errors.rejectValue("firstName", "submit.error.firstName.length");
        }
        if (!Pattern.matches(appProperties.getOnlyLettersRegEx(), user.getFirstName())) {
            errors.rejectValue("firstName", "submit.error.firstName.regex");
        }
        if (isEmpty(user.getLastName())) {
            errors.rejectValue("lastName", "submit.error.lastName.required");
        }
        if (user.getLastName().length() < 2 || user.getLastName().length() > 20) {
            errors.rejectValue("lastName", "submit.error.lastName.length");
        }
        if (!Pattern.matches(appProperties.getOnlyLettersRegEx(), user.getLastName())) {
            errors.rejectValue("lastName", "submit.error.lastName.regex");
        }
        if (isEmpty(user.getBirthDate())) {
            errors.rejectValue("birthDate", "submit.error.birthDate.required");
        }
        if (!isDateValid(user.getBirthDate())) {
            errors.rejectValue("birthDate", "submit.error.birthDate.invalid");
        }
        if (!Pattern.matches(appProperties.getEmailRegEx(), user.getEmail())) {
            errors.rejectValue("email", "submit.error.email.regex");
        }
        if (isEmpty(user.getUsername())) {
            errors.rejectValue("username", "submit.error.username.required");
        }
        if (user.getUsername().length() < 5 || user.getUsername().length() > 12) {
            errors.rejectValue("username", "submit.error.username.length");
        }
        if (!Pattern.matches(appProperties.getOnlyLatinLettersRegEx(), user.getUsername())) {
            errors.rejectValue("username", "submit.error.username.regex");
        }
        if (isEmpty(user.getPassword())) {
            errors.rejectValue("password", "submit.error.password.required");
        }
        if (user.getPassword().length() < 8 || user.getUsername().length() > 16) {
            errors.rejectValue("password", "submit.error.password.length");
        }
        if (!Pattern.matches(appProperties.getStrongPasswordRegEx(), user.getPassword())) {
            errors.rejectValue("password", "submit.error.password.weakPassword");
        }
    }

    public boolean isDateValid(String input) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("1870-01-01");
            Date endDate = new Date();
            Date inputDate = sdf.parse(input);
            return isWithinRange(inputDate, startDate, endDate);
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean isWithinRange(Date inputDate, Date startDate, Date endDate) {
        return inputDate.getTime() >= startDate.getTime() &&
                inputDate.getTime() <= endDate.getTime();
    }

    public void setAppProperties(AppProperties appProperties) {
        this.appProperties = appProperties;
    }
}
