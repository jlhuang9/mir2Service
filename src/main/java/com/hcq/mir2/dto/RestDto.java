package com.hcq.mir2.dto;



import com.hcq.mir2.entries.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: salary-calc
 * @description:
 * @author: huangcq
 * @create: 2018-12-30 14:26
 **/
@Data
@AllArgsConstructor
public class RestDto<T> extends BaseBean {

    private int ret;
    private T data;
    private String msg;

}
