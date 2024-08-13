package com.shangxun.search.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shangxun.search.model.dto.entityTable.EntityTableQueryRequest;
import com.shangxun.search.model.dto.post.PostQueryRequest;
import com.shangxun.search.model.entity.EntityTable;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shangxun.search.model.entity.Post;
import com.shangxun.search.model.vo.EntityTableVO;
import com.shangxun.search.model.vo.PostVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 刘志楷
* @description 针对表【entity_table(通用主体表)】的数据库操作Service
* @createDate 2024-08-01 10:05:36
*/
public interface EntityTableService extends IService<EntityTable> {

    List<EntityTable> searchByKeywords(String[] keywords);

    /**
     * 分页获取帖子封装
     *
     * @param entityTablePage
     * @param request
     * @return
     */
    Page<EntityTableVO> getEntityTableVOPage(Page<EntityTable> entityTablePage, HttpServletRequest request);

    /**
     * 从 ES 查询
     * @param entitytableQueryRequest
     * @return
     */
    Page<EntityTable> searchFromEs(EntityTableQueryRequest entitytableQueryRequest);
}
