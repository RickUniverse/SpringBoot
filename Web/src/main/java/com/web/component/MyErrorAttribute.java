package com.web.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Set;

/**
 * @author lijichen
 * @date 2021/1/4 - 21:14
 */
@Component// 加上之后容器中就没有SpringBoot默认的ErrorAttribute了
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("company","公司！");
        
        // 异常处理器携带的数据‘
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        Map<String, Object> ext2 = (Map<String, Object>) webRequest.getAttribute("ext",1);

        errorAttributes.put("ext",ext);//在这里打断点可以看到

        Set<ErrorAttributeOptions.Include> includes = options.getIncludes();

        return errorAttributes;
    }
}
