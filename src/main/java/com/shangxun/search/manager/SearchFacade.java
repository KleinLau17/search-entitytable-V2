package com.shangxun.search.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shangxun.search.common.ErrorCode;
import com.shangxun.search.datasource.DataSource;
import com.shangxun.search.datasource.DataSourceRegistry;
import com.shangxun.search.datasource.EntityTableDataSource;
import com.shangxun.search.exception.BusinessException;
import com.shangxun.search.exception.ThrowUtils;
import com.shangxun.search.model.dto.entityTable.EntityTableQueryRequest;
import com.shangxun.search.model.dto.post.PostQueryRequest;
import com.shangxun.search.model.dto.search.SearchRequest;
import com.shangxun.search.model.enums.SearchTypeEnum;
import com.shangxun.search.model.vo.EntityTableVO;
import com.shangxun.search.model.vo.PostVO;
import com.shangxun.search.model.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

/**
 * 搜索门面
 */
@Component
@Slf4j
public class SearchFacade {

    @Resource
    private EntityTableDataSource entityTableDataSource;

    @Resource
    private DataSourceRegistry dataSourceRegistry;

    public SearchVO searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        String type = searchRequest.getType();
        SearchTypeEnum searchTypeEnum = SearchTypeEnum.getEnumByValue(type);
        ThrowUtils.throwIf(StringUtils.isBlank(type), ErrorCode.PARAMS_ERROR);
        String searchText = searchRequest.getSearchText();
        long current = searchRequest.getCurrent();
        long pageSize = searchRequest.getPageSize();
        // 搜索出所有数据
        if (searchTypeEnum == null) {

            CompletableFuture<Page<EntityTableVO>> entityTableTask = CompletableFuture.supplyAsync(() -> {
                EntityTableQueryRequest entityTableQueryRequest = new EntityTableQueryRequest();
                entityTableQueryRequest.setSearchText(searchText);
                Page<EntityTableVO> entityTableVOPage = entityTableDataSource.doSearch(searchText, current, pageSize);
                return entityTableVOPage;
            });

            CompletableFuture.allOf(entityTableTask).join();
            try {
                Page<EntityTableVO> entityTableVOPage = entityTableTask.get();
                SearchVO searchVO = new SearchVO();
                searchVO.setEntityTableList(entityTableVOPage.getRecords());
                return searchVO;
            } catch (Exception e) {
                log.error("查询异常", e);
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "查询异常");
            }
        } else {
            SearchVO searchVO = new SearchVO();
            DataSource<?> dataSource = dataSourceRegistry.getDataSourceByType(type);
            Page<?> page = dataSource.doSearch(searchText, current, pageSize);
            searchVO.setDataList(page.getRecords());
            return searchVO;
        }
    }
}
