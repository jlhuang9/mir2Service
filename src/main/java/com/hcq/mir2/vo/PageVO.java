package com.hcq.mir2.vo;

import lombok.Data;

@Data
public class PageVO extends BaseVO {

    private int pageIndex = 1;
    private int pageSize = 20;

}
