package com.shangxun.search.esdao;

import com.shangxun.search.model.dto.entityTable.EntityTableEsDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * EntityTable ES 操作
 */
public interface EntityTableEsDao extends ElasticsearchRepository<EntityTableEsDTO, String> {
    List<EntityTableEsDTO> findByCodeName(String codeName);
}
