package com.biyao.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author: hxs
 * @Description:将obj转换成json格式
 */
public class ObjToJson<T> {
    public String getJson(T message){
        String json=null;
        ObjectMapper objectMapper=new ObjectMapper();
        try {
             json=objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
