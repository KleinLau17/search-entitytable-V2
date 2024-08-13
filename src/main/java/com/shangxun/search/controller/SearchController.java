package com.shangxun.search.controller;

import com.shangxun.search.common.BaseResponse;
import com.shangxun.search.common.ResultUtils;
import com.shangxun.search.manager.SearchFacade;
import com.shangxun.search.model.dto.search.SearchRequest;
import com.shangxun.search.model.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 搜索接口
 */
@RequestMapping("/search")
@Slf4j
@RestController
public class SearchController {

    @Resource
    private SearchFacade searchFacade;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacade.searchAll(searchRequest, request));
    }

}
