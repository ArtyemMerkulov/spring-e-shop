package com.geekbrains.backend;

import com.geekbrains.backend.dto.CartDto;
import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.frontend.commons.MyNavbar;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserContext {

    private MyNavbar myNavbar;

    private UserDto user;
    private CartDto cart;

    @PostConstruct
    public void initContext() {
        cart = new CartDto();

        myNavbar = new MyNavbar();
        myNavbar.initNavbar();
        myNavbar.changeCartItemsCount(cart.getTotalCount());
    }

    public MyNavbar getMyNavbar() {
        return myNavbar;
    }

    public UserDto getUser() {
        return user;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

}
