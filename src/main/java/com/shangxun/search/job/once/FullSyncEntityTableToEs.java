package com.shangxun.search.job.once;

import com.shangxun.search.esdao.EntityTableEsDao;
import com.shangxun.search.model.dto.entityTable.EntityTableEsDTO;
import com.shangxun.search.model.entity.EntityTable;
import com.shangxun.search.service.EntityTableService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全量同步 EntityTable 到 es
 */
// todo 取消注释开启任务
@Component
@Slf4j
public class FullSyncEntityTableToEs implements CommandLineRunner {

    @Resource
    private EntityTableService entityTableService;

    @Resource
    private EntityTableEsDao entityTableEsDao;

    @Override
    public void run(String... args) {
        List<EntityTable> entityTableList = entityTableService.list();
        if (CollectionUtils.isEmpty(entityTableList)) {
            return;
        }
        List<EntityTableEsDTO> entityTableEsDTOList = entityTableList.stream().map(EntityTableEsDTO::objToDto).collect(Collectors.toList());
        final int pageSize = 500;
        int total = entityTableEsDTOList.size();
        log.info("FullSyncEntityTableToEs start, total {}", total);
        for (int i = 0; i < total; i += pageSize) {
            int end = Math.min(i + pageSize, total);
            log.info("sync from {} to {}", i, end);
            entityTableEsDao.saveAll(entityTableEsDTOList.subList(i, end));
        }
        log.info("FullSyncEntityTableToEs end, total {}", total);
    }
}
