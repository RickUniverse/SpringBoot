package org.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lijichen
 * @date 2020/12/30 - 16:19
 */

/**
 * 这两个注解表示: 这个类的所有方法返回的数据直接写给浏览器, (如果是对象则转为JSON字符串数据)
 *      @ResponseBody
 *      @Controller
 *  @RestController: 是上面两个注解的简化版
 */
/*@ResponseBody
@Controller*/
@RestController
public class TestController {


    @ResponseBody
    @RequestMapping("/testSpringBoot")
    public Object testSpringBoot() {
        return new Date();
    }
}
