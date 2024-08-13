package com.shangxun.search.model.dto.entityTable;

import com.shangxun.search.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

/**
 * 查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EntityTableQueryRequest extends PageRequest implements Serializable {

    /**
     * UUID
     */
    private String uuid;

    /**
     * 搜索词
     */
    private String searchText;

    //--------------------------

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

    private static final long serialVersionUID = 1L;
}
