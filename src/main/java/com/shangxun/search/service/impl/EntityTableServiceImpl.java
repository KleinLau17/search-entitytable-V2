package com.shangxun.search.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shangxun.search.constant.CommonConstant;
import com.shangxun.search.model.dto.entityTable.EntityTableEsDTO;
import com.shangxun.search.model.dto.entityTable.EntityTableQueryRequest;
import com.shangxun.search.model.dto.post.PostEsDTO;
import com.shangxun.search.model.entity.EntityTable;
import com.shangxun.search.model.entity.Post;
import com.shangxun.search.model.vo.EntityTableVO;
import com.shangxun.search.model.vo.PostVO;
import com.shangxun.search.service.EntityTableService;
import com.shangxun.search.mapper.EntityTableMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 刘志楷
* @description 针对表【entity_table(通用主体表)】的数据库操作Service实现
* @createDate 2024-08-01 10:05:36
*/
@Service
@Slf4j
public class EntityTableServiceImpl extends ServiceImpl<EntityTableMapper, EntityTable>
    implements EntityTableService {

    @Resource
    private EntityTableMapper entityTableMapper;

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public List<EntityTable> searchByKeywords(String[] keywords) {
        QueryWrapper<EntityTable> query = new QueryWrapper<>();
        for (String keyword : keywords) {
            query.or().like("code_name", "%" + keyword + "%")
                   .or().like("type_name", "%" + keyword + "%")
                    .or().like("field1", "%" + keyword + "%")
                    .or().like("field2", "%" + keyword + "%")
                    .or().like("field3", "%" + keyword + "%");
        }
        List<EntityTable> resultList = entityTableMapper.selectList(query);
        // 使用LinkedHashSet去重
        LinkedHashSet<EntityTable> resultSet = new LinkedHashSet<>(resultList);

        return new ArrayList<>(resultSet);
    }

    @Override
    public Page<EntityTableVO> getEntityTableVOPage(Page<EntityTable> entityTablePage, HttpServletRequest request) {
        List<EntityTable> entityTableList = entityTablePage.getRecords();
        Page<EntityTableVO> entityTableVOPage = new Page<>(entityTablePage.getCurrent(), entityTablePage.getSize(), entityTablePage.getTotal());
        if (CollectionUtils.isEmpty(entityTableList)) {
            return entityTableVOPage;
        }
        // 填充信息
        List<EntityTableVO> entityTableVOList = entityTableList.stream().map(entityTable -> {
            EntityTableVO entityTableVO = EntityTableVO.objToVo(entityTable);
            return entityTableVO;
        }).collect(Collectors.toList());
        entityTableVOPage.setRecords(entityTableVOList);
        return entityTableVOPage;
    }

    @Override
    public Page<EntityTable> searchFromEs(EntityTableQueryRequest entitytableQueryRequest) {
        String uuid = entitytableQueryRequest.getUuid();
        String searchText = entitytableQueryRequest.getSearchText();
        String codeName = entitytableQueryRequest.getCodeName();
        String typeName = entitytableQueryRequest.getTypeName();
        String field1 = entitytableQueryRequest.getField1();
        String field2 = entitytableQueryRequest.getField2();
        String field3 = entitytableQueryRequest.getField3();
        // es 起始页为 0
        long current = entitytableQueryRequest.getCurrent() - 1;
        long pageSize = entitytableQueryRequest.getPageSize();
        String sortField = entitytableQueryRequest.getSortField();
        String sortOrder = entitytableQueryRequest.getSortOrder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        // 过滤
        if (uuid != null) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("uuid", uuid));
        }
        // 按关键词检索
        if (StringUtils.isNotBlank(searchText)) {
            boolQueryBuilder.should(QueryBuilders.matchQuery("codeName", searchText));
            boolQueryBuilder.should(QueryBuilders.matchQuery("typeName", searchText));
            boolQueryBuilder.should(QueryBuilders.matchQuery("field1", searchText));
            boolQueryBuilder.should(QueryBuilders.matchQuery("field2", searchText));
            boolQueryBuilder.should(QueryBuilders.matchQuery("field3", searchText));
            boolQueryBuilder.minimumShouldMatch(1);
        }
        // 按 codeName 检索
        if (StringUtils.isNotBlank(codeName)) {
            boolQueryBuilder.should(QueryBuilders.matchQuery("codeName", codeName));
            boolQueryBuilder.minimumShouldMatch(1);
        }
        // 按 typeName 检索
        if (StringUtils.isNotBlank(typeName)) {
            boolQueryBuilder.should(QueryBuilders.matchQuery("typeName", typeName));
            boolQueryBuilder.minimumShouldMatch(1);
        }
        // 按 field1 检索
        if (StringUtils.isNotBlank(field1)) {
            boolQueryBuilder.should(QueryBuilders.matchQuery("field1", field1));
            boolQueryBuilder.minimumShouldMatch(1);
        }
        // 按 field2 检索
        if (StringUtils.isNotBlank(field2)) {
            boolQueryBuilder.should(QueryBuilders.matchQuery("field2", field2));
            boolQueryBuilder.minimumShouldMatch(1);
        }
        // 按 field3 检索
        if (StringUtils.isNotBlank(field3)) {
            boolQueryBuilder.should(QueryBuilders.matchQuery("field3", field3));
            boolQueryBuilder.minimumShouldMatch(1);
        }
        // 排序
        SortBuilder<?> sortBuilder = SortBuilders.scoreSort();
        if (StringUtils.isNotBlank(sortField)) {
            sortBuilder = SortBuilders.fieldSort(sortField);
            sortBuilder.order(CommonConstant.SORT_ORDER_ASC.equals(sortOrder) ? SortOrder.ASC : SortOrder.DESC);
        }
        // 分页
        PageRequest pageRequest = PageRequest.of((int) current, (int) pageSize);
        // 构造查询
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(boolQueryBuilder)
                .withPageable(pageRequest).withSort(sortBuilder).build();
        SearchHits<EntityTableEsDTO> searchHits = elasticsearchRestTemplate.search(searchQuery, EntityTableEsDTO.class);
        Page<EntityTable> page = new Page<>();
        page.setTotal(searchHits.getTotalHits());
        List<EntityTable> resourceList = new ArrayList<>();
        // 查出结果后，从 db 获取最新动态数据
        if (searchHits.hasSearchHits()) {
            List<SearchHit<EntityTableEsDTO>> searchHitList = searchHits.getSearchHits();
            List<String> entityTableUuidList = searchHitList.stream().map(searchHit -> searchHit.getContent().getUuid())
                    .collect(Collectors.toList());
            // 从数据库中取出更完整的数据
            List<EntityTable> entityTableList = baseMapper.selectBatchIds(entityTableUuidList);
            if (entityTableList != null) {
                Map<String, List<EntityTable>> uuidEntityTableMap = entityTableList.stream().collect(Collectors.groupingBy(EntityTable::getUuid));
                entityTableUuidList.forEach(entityTableUuid -> {
                    if (uuidEntityTableMap.containsKey(entityTableUuid)) {
                        resourceList.add(uuidEntityTableMap.get(entityTableUuid).get(0));
                    } else {
                        // 从 es 清空 db 已物理删除的数据
                        String delete = elasticsearchRestTemplate.delete(String.valueOf(entityTableUuid), EntityTableEsDTO.class);
                        log.info("delete post {}", delete);
                    }
                });
            }
        }
        page.setRecords(resourceList);
        return page;
    }
}




