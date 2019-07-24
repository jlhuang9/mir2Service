package com.hcq.mir2.controller;

import com.hcq.mir2.dto.RestDto;
import com.hcq.mir2.service.Mir2Service;
import com.hcq.mir2.utils.RestUtils;
import com.hcq.mir2.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("url")
public class UrlController {

    @Autowired
    private Mir2Service mir2Service;


    @PostMapping("getAll")
    public RestDto getAll() {
        return RestUtils.OK(mir2Service.getAll());
    }

    @PostMapping("getByPage")

    public RestDto getByPage(@RequestBody PageVO pageVO) {
        return RestUtils.OK(mir2Service.getByPage(pageVO.getPageIndex()));
    }

}
