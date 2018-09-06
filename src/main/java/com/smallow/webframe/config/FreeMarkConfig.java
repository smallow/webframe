package com.smallow.webframe.config;


import com.smallow.webframe.core.shiro.ShiroExt;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreeMarkConfig {

//    /**
//     * 拿到spring boot中的fm自动化配置
//     */
//    @Autowired
//    private FreeMarkerProperties properties;

    @Autowired
    protected freemarker.template.Configuration configuration;

    @PostConstruct
    public void setSharedVariable() {
        try {
            configuration.setSharedVariable("shiro", new ShiroExt());
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
    }
}
