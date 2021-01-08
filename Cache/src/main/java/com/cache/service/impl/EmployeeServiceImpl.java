package com.cache.service.impl;

import com.cache.mapper.EmployeeMapper;
import com.cache.pojo.Employee;
import com.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/8 - 15:06
 */
@CacheConfig(cacheNames = "emp", cacheManager = "jsonCacheManager")// 抽取缓存的公共配置
//@CacheConfig(cacheNames = "emp", cacheManager = "jdkCacheManager")// jdkCacheManager设置了primary注解所以默认就是jdkcachemanager
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /*
        @Cacheable:开启缓存，笔记中有老师对参数的详细解析
            cacheNames: 指定缓存的名字
            key:指定获取该方法的返回值所用的key，
                key = "#root.methodName + '(' + #id + ')'  会使用当前方法名
                    例如: queryEmployeeById(1) : 获取值
     */
//    @Cacheable(cacheNames = {"emp"},key = "#root.methodName + '(' + #id + ')'")
    /*
        condition = "#a0 > 1" ，如果判断条件成立就缓存
        unless = "#a0 == 0 and #root.methodName = 'queryEmployeeById'"  如果判断条件成立就不缓存

        #a0  表示方法的第一个参数 #a1 表示第二个参数
     */
//    @Cacheable(cacheNames = {"emp"},keyGenerator = "myKeyGenerator",condition = "#a0 > 1",
//            unless = "#a0 == 0 and #root.methodName = 'queryEmployeeById'" )// 使用自己的key主键生成策略
    @Cacheable(value = "emp") // 默认的key是参数
    @Override
    public Employee queryEmployeeById(Integer id) {
        System.out.println("查询的id是"+id);
        return employeeMapper.selectOneByEmployeeId(id);
    }

    /*
        因为默认是使用参数，如果想要同步更新缓存则需要,指定query性质的方法所定义的key：key = "#result.id"
            result，@Cacheable注解不可用
     */
    @Override
    @CachePut(/*cacheNames = "emp", */key = "#result.id" /*key = "#employee.id"*/)
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /*
        beforeInvocation = true : 是否在方法执行之前清楚缓存， 默认值是false
        allEntries = true  : 是否清楚所有缓存
     */
    @CacheEvict(/*cacheNames = "emp",*/beforeInvocation = true,allEntries = true)
    @Override
    public Object deleteEmployee(Integer id) {
//        employeeMapper.deleteEmployee(id);
        return "success";
    }

    /*
        复杂缓存操作
     */

    @Caching(
            cacheable = {
                    @Cacheable(key = "#lastName"), // 将lastName作为key缓存
            },
            put = {
                    /*
                        !!!! result 只能用在@CachPut和@CacheEvict 上， 因为他们支持在方法执行后获取结果
                     */
                    @CachePut(key = "#result.id"), // 无论如何执行方法，然后将id作为key进行缓存
                    @CachePut(key = "#result.email") // 将email作为key缓存
            }
    )
    @Override
    public Employee queryEmployeeByLastName(String lastName) {
        return employeeMapper.selectEmployeeByLastName(lastName);
    }
}
