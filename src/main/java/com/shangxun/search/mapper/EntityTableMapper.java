package com.shangxun.search.mapper;

import com.shangxun.search.model.entity.EntityTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shangxun.search.model.entity.Post;

import java.util.Date;
import java.util.List;

/**
* @author 刘志楷
* @description 针对表【entity_table(通用主体表)】的数据库操作Mapper
*/
public interface EntityTableMapper extends BaseMapper<EntityTable> {
    /**
     * 查询帖子列表（包括已被删除的数据）
     */
    List<EntityTable> listEntityTable(Date minUpdateTime);
}




