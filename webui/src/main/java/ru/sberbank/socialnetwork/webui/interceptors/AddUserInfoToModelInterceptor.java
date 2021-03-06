package ru.sberbank.socialnetwork.webui.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.sberbank.socialnetwork.webui.models.UserInfo;
import ru.sberbank.socialnetwork.webui.services.UserInfoService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AddUserInfoToModelInterceptor implements HandlerInterceptor {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object o, ModelAndView modelAndView) throws Exception {
        Object userIdAttribute = request.getSession().getAttribute("userId");
        if (modelAndView == null || userIdAttribute == null) {
            return;
        }
        String userId = userIdAttribute.toString();
        UserInfo user = userInfoService.getUser(userId);
        modelAndView.addObject("user", user);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object o, Exception e) throws Exception {

    }
}
