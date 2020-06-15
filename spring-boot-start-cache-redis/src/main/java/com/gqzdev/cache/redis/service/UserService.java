package com.gqzdev.cache.redis.service;

import com.gqzdev.cache.redis.entity.User;

 /**
  * @description:  UserService
  * @Author: ganquanzhong
  * @Date:  2020/6/15 10:27
  */

public interface UserService {
    /**
     * 保存或修改用户
     *
     * @param user 用户对象
     * @return 操作结果
     */
    User saveOrUpdate(User user);

    /**
     * 获取用户
     *
     * @param id key值
     * @return 返回结果
     */
    User get(Long id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Long id);
}
