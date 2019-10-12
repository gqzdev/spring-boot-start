package com.gqz.springbootcache.service;

import com.gqz.springbootcache.bean.Employee;
import com.gqz.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName: EmployeeService
 * @author: ganquanzhong
 * @date: 2019/10/10 15:28
 */

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
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        return employeeMapper.getEmpById(id);
    }

}
