package com.shangxun.search.job.cycle;

import com.shangxun.search.esdao.EntityTableEsDao;
import com.shangxun.search.mapper.EntityTableMapper;
import com.shangxun.search.model.dto.entityTable.EntityTableEsDTO;
import com.shangxun.search.model.entity.EntityTable;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 增量同步 EntityTable 到 es
 */
// todo 取消注释开启任务
@Component
@Slf4j
public class IncSyncEntityTableToEs {

    @Resource
    private EntityTableMapper entityTableMapper;

    @Resource
    private EntityTableEsDao entityTableEsDao;

    /**
     * 每分钟执行一次
     */
    @Scheduled(fixedRate = 60 * 1000)
    public void run() {
        // 查询近 5 分钟内的数据
        Date fiveMinutesAgoDate = new Date(new Date().getTime() - 5 * 60 * 1000L);
        List<EntityTable> entityTableList = entityTableMapper.listEntityTable(fiveMinutesAgoDate);
        if (CollectionUtils.isEmpty(entityTableList)) {
            log.info("no inc EntityTable");
            return;
        }
        List<EntityTableEsDTO> entityTableEsDTOList = entityTableList.stream()
                .map(EntityTableEsDTO::objToDto)
                .collect(Collectors.toList());
        final int pageSize = 500;
        int total = entityTableEsDTOList.size();
        log.info("IncSyncEntityTableToEs start, total {}", total);
        for (int i = 0; i < total; i += pageSize) {
            int end = Math.min(i + pageSize, total);
            log.info("sync from {} to {}", i, end);
            entityTableEsDao.saveAll(entityTableEsDTOList.subList(i, end));
        }
        log.info("IncSyncEntityTableToEs end, total {}", total);
    }
}
