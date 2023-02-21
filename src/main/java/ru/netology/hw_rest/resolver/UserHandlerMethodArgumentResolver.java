package ru.netology.hw_rest.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.hw_rest.annotation.ValidUser;
import ru.netology.hw_rest.exceptions.InvalidCredentials;
import ru.netology.hw_rest.model.User;

import java.util.Objects;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String user = Objects.requireNonNull(webRequest.getParameter("user")).trim();
        String password = Objects.requireNonNull(webRequest.getParameter("password")).trim();

        if (isNotSet(user)) throw new InvalidCredentials("The data is incorrect");
        if (isNotSet(password)) throw new InvalidCredentials("The data is incorrect");

        return new User(user, password);
    }

    private boolean isNotSet(String value) {
        if (value == null || value.replaceAll("\\s", "").length() == 0) return true;
        return value.length() <= 2 || value.length() > 20;
    }
}
