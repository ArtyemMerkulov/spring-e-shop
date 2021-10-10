package com.geekbrains.backend;

import com.geekbrains.backend.dto.CartDto;
import com.geekbrains.backend.dto.RoleDto;
import com.geekbrains.backend.dto.UserDto;
import com.geekbrains.backend.facade.RoleFacade;
import com.geekbrains.backend.facade.UserFacade;
import com.geekbrains.frontend.commons.MyNavbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashSet;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AppContext {

    private RoleFacade roleFacade;
    private UserFacade userFacade;
    private MyNavbar myNavbar;

    private UserDto user;
    private CartDto cart;

    public AppContext() {
    }

    /**
     * Заглушка
     */
    @PostConstruct
    public void initContext() {
        cart = new CartDto();

        myNavbar = new MyNavbar();
        myNavbar.initNavbar();
        myNavbar.changeCartItemsCount(cart.getTotalCount());

        createPlugRoleAndUser();
        this.user = userFacade.findByEmail("app@app.app");
    }

    private void createPlugRoleAndUser() {
        RoleDto plugRole = roleFacade.findByTitle("plugRole");

        if (plugRole == null) {
            plugRole = new RoleDto();
            plugRole.setTitle("plugRole");

            roleFacade.save(plugRole);
        }

        UserDto plugUser = userFacade.findByEmail("app@app.app");
        if (plugUser == null) {
            plugUser = new UserDto();

            plugUser.setRoles(new HashSet<>(roleFacade.findAll()));
            plugUser.setEmail("app@app.app");
            plugUser.setPassword("appPassword");
            plugUser.setFirstName("appFirstName");
            plugUser.setLastName("appLastName");
            plugUser.setPatronymic("appPatronymic");
            plugUser.setPhone("appPhone");
            plugUser.setAddress("appAddress");
            plugUser.setBalance(BigDecimal.ZERO);
            plugUser.setActive(false);

            userFacade.save(plugUser);
        }
    }

    @Autowired
    public void setRoleFacade(RoleFacade roleFacade) {
        this.roleFacade = roleFacade;
    }

    @Autowired
    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
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

}
