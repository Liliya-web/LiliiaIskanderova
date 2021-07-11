package ru.training.at.hw7.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.at.hw7.entities.User;

public class LoginForm extends Form<User> {
    TextField name;
    TextField password;
    Button loginButton;
}
