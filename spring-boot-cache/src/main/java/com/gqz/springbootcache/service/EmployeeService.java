package com.gqz.springbootcache.service;

import com.gqz.springbootcache.bean.Employee;
import com.gqz.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @ClassName: EmployeeService
 * @author: ganquanzhong
 * @date: 2019/10/10 15:28
 */

@CacheConfig(cacheNames = "emp")  //抽取缓存的公共配置
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法
     *    CacheManager管理多个Cache组件，
     *  对缓存的真正CURD操作在Cache组件中，每一个缓存组件都有自己唯一的名字
     *      几个属性
     *
     *          value :指定缓存组件的名字；
     *          cacheNames :指定缓存组件的名字；
     *              value/cacheNames:都是指定cache组件的名字的，
     *                      将方法的返回结果放入到哪个缓存中，是数组的方式，可以指定多个缓存；
     *          key: 缓存数据使用的key；可以用它来指定。
     *               默认是使用方法参数的值，  1-方法的返回值
     *               编写SpEL表达式；  #id;参数id的值  #a0 #p0 #root.args[0]
     *               key = "#root.methodName+'['+#id+']'"
     *               也可以自己写KenGenerator的生成策略 new KeyGenerator()
     *
     *
     *
     *          keyGenerator: key的生成器
     *              可以自己指定key的生成器的组件id
     *              key/keyGenerator；二者选一使用
     *          cacheManager： 指定缓存管理器；
     *          cacheResolver： cacheResolver指定获取解析器；
     *          condition：指定符合条件的情况下才缓存；
     *                  SpEL表达式：  condition="#id>0"
     *          unless：否定缓存；当unless指定条件为true，方法的返回值不会被缓存；
     *                  可以获取到结果进行判断是否缓存 unless = "#result==null"
     *          sync：是否适用异步模式
     *
     * @author ganquanzhong
     * @date   2019/10/10 15:59
     */
    @Cacheable(/*cacheNames = {"emp"}*//*,keyGenerator = "myKeyGenerator",condition = "#a0>1",unless = "#a0==2"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        return employeeMapper.getEmpById(id);
    }

    /**
     * @CachePut:既调用方法，又更新缓存数据
     *      运行时机
     *          1.先调用目标方法
     *          2.将目标方法的返回结果缓存起来
     * 只有CachePut有result返回结果，@Cacheable是先查看缓存的
     * 修改了数据，并且将修改后的数据保存在缓存中（要求使用相同的key策略）
     */
    @CachePut(/*value = "emp",*/key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("Update Emp"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * 清除缓存   @CacheEvict
     *      key：指定要删除的缓存
     *      allEntries = true: 指定清除这个缓存中的所有数据
     *      beforeInvocation = false： 缓存方法的禽畜是否在方法执行之前
     *          默认代表缓存清除操作是在方法执行之后执行；如果方法中出现异常，则缓存不会清除
     */
    @CacheEvict(value= "emp",key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("delete Employee"+id);
        //employeeMapper.deleteEmpById(id);

    }

    /**
     * @Caching  复杂的缓存注解
     *
     */
    @Caching(
            cacheable = {
                    @Cacheable(value= "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),//CachePut 表明此方法必调用
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
