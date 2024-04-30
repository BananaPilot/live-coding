package com.pasqualehorse.livecoding.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties("app.user-mapper")
public class UserMapperProperties {


    private Boolean showPassword = false;

    public Boolean getShowPassword() {
        return showPassword;
    }

    public void setShowPassword(Boolean showPassword) {
        this.showPassword = showPassword;
    }
}
