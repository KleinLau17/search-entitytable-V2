package com.shangxun.search.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shangxun.search.model.dto.entityTable.EntityTableQueryRequest;
import com.shangxun.search.model.entity.EntityTable;
import com.shangxun.search.model.vo.EntityTableVO;
import com.shangxun.search.service.EntityTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Entity 服务实现
 */
@Service
@Slf4j
public class EntityTableDataSource implements DataSource<EntityTableVO> {

    @Resource
    private EntityTableService entityTableService;

    @Override
    public Page<EntityTableVO> doSearch(String searchText, long pageNum, long pageSize) {
        EntityTableQueryRequest entityTableQueryRequest = new EntityTableQueryRequest();
        entityTableQueryRequest.setSearchText(searchText);
        entityTableQueryRequest.setCurrent(pageNum);
        entityTableQueryRequest.setPageSize(pageSize);
        ServletRequestAttributes servletRequestAttributes =  (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Page<EntityTable> entityTablePage = entityTableService.searchFromEs(entityTableQueryRequest);
        return entityTableService.getEntityTableVOPage(entityTablePage, request);
    }
}




