package in.hangang.annotation;

import javax.validation.groups.Default;

/**
 * Utility classes to distinct CRUD validations.<br>
 * <br>
 * Used with the
 * {@link org.springframework.validation.annotation.Validated @Validated}
 * Spring annotation.
 */
public final class ValidationGroups {

    private ValidationGroups() { }

    // Standard groups
    public interface Create extends Default {};
    public interface Update extends Default {};
    public interface signUp extends  Default{};
    public interface logIn extends Default{}
    public interface sendEmail extends Default{}
    public interface configEmail extends Default{}
    public interface findPassword extends Default{};
    // Admin groups
    public interface CreateAdmin extends Default {};
    public interface UpdateAdmin extends Default {};
}