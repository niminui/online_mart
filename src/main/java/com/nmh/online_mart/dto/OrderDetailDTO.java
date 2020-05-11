package com.nmh.online_mart.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author niminui
 * @date 2020/5/11 12:05
 */
@Data
public class OrderDetailDTO {
    private List<OrderJsonDTO> productionList;
    private Long gmtCreate;
    private Float totalPrice;
    private String status;
    private String destination;

}
