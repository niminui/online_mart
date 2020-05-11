package com.nmh.online_mart.dto;

import lombok.Data;

/**
 * @author niminui
 * @date 2020/4/27 15:31
 */
@Data
public class OrderJsonDTO {
    private Long id;
    private String name;
    private Float price;
    private Long count;
    private Float total;

}
