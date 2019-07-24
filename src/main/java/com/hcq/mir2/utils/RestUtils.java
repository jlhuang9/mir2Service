package com.hcq.mir2.utils;


import com.hcq.mir2.dto.RestDto;

public class RestUtils {

    public static final int DEFAULT_RET_OK = 1;
    public static final int DEFAULT_RET_ERROR = 0;
    public static final String NULL_VALUE = "";


    public static RestDto OK(String msg) {
        return OK(null, msg);
    }


    public static <T> RestDto<T> OK(T data) {
        return OK(data, NULL_VALUE);
    }

    public static <T> RestDto<T> OK(T data, String message) {
        return new RestDto<>(DEFAULT_RET_OK, data, message);
    }

    public static <T> RestDto<T> ERROR(String message) {
        return ERROR(DEFAULT_RET_ERROR, message);
    }

    public static <T> RestDto<T> ERROR(int ret, String message) {
        return new RestDto<>(ret, null, message);
    }
}
