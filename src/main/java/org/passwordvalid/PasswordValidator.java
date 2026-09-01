package org.passwordvalid;

// InvalidPasswordException problem
class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("This password must have numbers and main letter");
    }
}

// Small password error
class SmallPassword extends  Exception{
    public SmallPassword() {
        super("This password have lenght < 8");
    }
}

// main class
public class PasswordValidator {
    private static int totalValidations = 0;

    public static int getTotalValidations() {
        return totalValidations;
    }

    // main object
    public Boolean validate(String password) throws  SmallPassword, InvalidPasswordException{
        totalValidations += 1;
        checkLength(password);
        checkComplexity(password);
        return true;
    }

    // checking len password
    private void checkLength(String password) throws SmallPassword{
        if (password.length() < 8) {
            throw new SmallPassword();
        }
    }

    // check complexity
    private void checkComplexity(String password) throws InvalidPasswordException {
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");

        if (!hasDigit || !hasUpper || !hasLower) {
            throw new InvalidPasswordException();
        }
    }

    // starter
    public static void main(String[] args) {
        PasswordValidator pas = new PasswordValidator();

        try {
            System.out.println(pas.validate(""));  // <= enter yore password
            System.out.println("Validations count: " + getTotalValidations());
        }
        catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }
        catch (SmallPassword e) {
            System.out.println(e.getMessage());
        }
    }
}
