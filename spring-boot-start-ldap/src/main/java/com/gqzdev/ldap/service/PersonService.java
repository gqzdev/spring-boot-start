package com.gqzdev.ldap.service;

import com.gqzdev.ldap.api.Result;
import com.gqzdev.ldap.entity.Person;
import com.gqzdev.ldap.request.LoginRequest;
import com.gqzdev.ldap.api.Result;
import com.gqzdev.ldap.entity.Person;
import com.gqzdev.ldap.request.LoginRequest;

/**
 * PersonService
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/8/26 1:05
 */
public interface PersonService {

    /**
     * 登录
     *
     * @param request {@link LoginRequest}
     * @return {@link Result}
     */
    Result login(LoginRequest request);

    /**
     * 查询全部
     *
     * @return {@link Result}
     */
    Result listAllPerson();

    /**
     * 保存
     *
     * @param person {@link Person}
     */
    void save(Person person);

    /**
     * 删除
     *
     * @param person {@link Person}
     */
    void delete(Person person);

}
