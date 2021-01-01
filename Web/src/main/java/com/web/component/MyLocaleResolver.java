package com.web.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.spring5.context.SpringContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author lijichen
 * @date 2021/1/1 - 15:28
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String localeStr = httpServletRequest.getParameter("locale");

        Locale locale = Locale.getDefault();
        String[] locales = {locale.getLanguage(),
                            locale.getCountry()};

        if (localeStr != null
                && !"".equals(localeStr)
                && !localeStr.isEmpty()) {
            locales = localeStr.split("_");
        } else {
            String headerLocale = httpServletRequest.getHeader("Accept-Language");
            // 获取请求头中的默认地区信息
            String localeH = headerLocale.substring(0, headerLocale.indexOf(","));
            locales = localeH.split("-");
        }

        return new Locale(locales[0],locales[1]);
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
