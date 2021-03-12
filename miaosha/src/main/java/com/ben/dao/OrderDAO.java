package com.ben.dao;

import com.ben.entity.Order;

public interface OrderDAO {
    //创建订单方法
    void createOrder(Order order);
}
