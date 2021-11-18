package com.cblSurveyPortal.model.dummy;

import com.cblSurveyPortal.enums.Authority;
import java.util.List;


public class User {

    private static final long serialVersionUID = 7954325925563724664L;

    private String username;
    private boolean isEnabled;
    private List<Authority> authorities;


    public boolean isEnabled() {
        return isEnabled;
    }

    public void setAuthorities(final List<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setEnabled(final boolean enabled) {
        isEnabled = enabled;
    }

    public boolean hasAuthority(Authority authority) {
        return authorities.contains(authority);
    }
}