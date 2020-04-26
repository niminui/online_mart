package com.nmh.online_mart.model;

import lombok.Data;

/**
 * @author niminui
 * @date 2020/4/25 23:06
 */
@Data
public class CartItem {
    private Long count;
    private Long id;
    private String name;
    private Float price;
}
