package com.shangxun.search.model.dto.entityTable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.shangxun.search.model.entity.EntityTable;
import com.shangxun.search.model.entity.Post;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * EntityTable ES 包装类
 **/

// todo 取消注释开启 ES（须先配置 ES）
@Document(indexName = "entity_table")
@Data
public class EntityTableEsDTO implements Serializable {

    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /**
     * UUID
     */
    @Id
    private String uuid;

    /**
     * 主体名称
     */
    private String codeName;

    /**
     * 主体类型名称
     */
    private String typeName;

    /**
     * 属性1
     */
    private String field1;

    /**
     * 属性2
     */
    private String field2;

    /**
     * 属性3
     */
    private String field3;

    /**
     * 创建时间
     */
    @Field(index = false, store = true, type = FieldType.Date, format = {}, pattern = DATE_TIME_PATTERN)
    private Date createTime;

    /**
     * 更新时间
     */
    @Field(index = false, store = true, type = FieldType.Date, format = {}, pattern = DATE_TIME_PATTERN)
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    private static final Gson GSON = new Gson();

    /**
     * 对象转包装类
     *
     * @param entityTable
     * @return
     */
    public static EntityTableEsDTO objToDto(EntityTable entityTable) {
        if (entityTable == null) {
            return null;
        }
        EntityTableEsDTO entityTableEsDTO = new EntityTableEsDTO();
        BeanUtils.copyProperties(entityTable, entityTableEsDTO);
        return entityTableEsDTO;
    }

    /**
     * 包装类转对象
     *
     * @param entityTableEsDTO
     * @return
     */
    public static EntityTable dtoToObj(EntityTableEsDTO entityTableEsDTO) {
        if (entityTableEsDTO == null) {
            return null;
        }
        EntityTable entityTable = new EntityTable();
        BeanUtils.copyProperties(entityTableEsDTO, entityTable);
        return entityTable;
    }
}
