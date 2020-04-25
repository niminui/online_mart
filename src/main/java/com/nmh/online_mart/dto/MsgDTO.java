package com.nmh.online_mart.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niminui
 * @date 2020/4/20 21:40
 */
@Data
public class MsgDTO {

    private int code; //状态码：100为成功，200为失败
    private String msg;
    private Map<String,Object> extend = new HashMap<>();

    public static MsgDTO success() {
        MsgDTO result = new MsgDTO();
        result.setCode(100);
        result.setMsg("处理成功！");
        return result;
    }

    public static MsgDTO fail() {
        MsgDTO result = new MsgDTO();
        result.setCode(200);
        result.setMsg("处理失败");
        return result;
    }

    public MsgDTO add(String key,Object value) {
        this.getExtend().put(key,value);
        return this;
    }

}
