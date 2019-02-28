package com.cloud.microblog.gateway.auth;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthPathResource  implements ApplicationContextAware {

    @Autowired
    ChatAppPath chatAppPath;

    private Map<String , AbsAppPath>  pathMap = new HashMap();


    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        pathMap.put(chatAppPath.getName(),chatAppPath);
    }


    public Map<String, AbsAppPath> getPathMap() {
        return pathMap;
    }
}