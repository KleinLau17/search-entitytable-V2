package com.shangxun.search.model.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shangxun.search.model.entity.EntityTable;
import com.shangxun.search.model.entity.Post;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 帖子视图
 */
@Data
public class EntityTableVO implements Serializable {

    private final static Gson GSON = new Gson();

    /**
     * UUID
     */
    private String uuid;

    /**
     * 主体
     */
    private String entityCode;

    /**
     * 主体名称
     */
    private String codeName;

    /**
     * 主体类型子主体
     */
    private String entityType;

    /**
     * 主体类型名称
     */
    private String typeName;

    /**
     * 实体编号
     */
    private String entityNo;

    /**
     * 实体名称
     */
    private String entityName;

    /**
     * 状态
     */
    private String status;

    /**
     * 属性0
     */
    private String field0;

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
     * 属性4
     */
    private String field4;

    /**
     * 属性5
     */
    private String field5;

    /**
     * 属性6
     */
    private String field6;

    /**
     * 属性7
     */
    private String field7;

    /**
     * 属性8
     */
    private String field8;

    /**
     * 属性9
     */
    private String field9;

    /**
     * 数据属性0
     */
    private Double number0;

    /**
     * 数据属性1
     */
    private Double number1;

    /**
     * 数据属性2
     */
    private Double number2;

    /**
     * 数据属性3
     */
    private Double number3;

    /**
     * 数据属性4
     */
    private Double number4;

    /**
     * 数据属性5
     */
    private Double number5;

    /**
     * 日期1
     */
    private Date date1;

    /**
     * 日期2
     */
    private Date date2;

    /**
     * 日期3
     */
    private Date date3;

    /**
     * 日期4
     */
    private Date date4;

    /**
     * 时间1
     */
    private Date datetime1;

    /**
     * 时间2
     */
    private Date datetime2;

    /**
     * 附件
     */
    private String accessory;

    /**
     * 附件1
     */
    private String accessory1;

    /**
     * 附件2
     */
    private String accessory2;

    /**
     * 附件3
     */
    private String accessory3;

    /**
     * 附件4
     */
    private String accessory4;

    /**
     * 附件5
     */
    private String accessory5;

    /**
     * 备注
     */
    private String remark;

    /**
     * 备注1
     */
    private String remark1;

    /**
     * 备注2
     */
    private String remark2;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 机构ID
     */
    private String companyId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 包装类转对象
     *
     * @param entityTableVO
     * @return
     */
    public static EntityTable voToObj(EntityTableVO entityTableVO) {
        if (entityTableVO == null) {
            return null;
        }
        EntityTable entityTable = new EntityTable();
        BeanUtils.copyProperties(entityTableVO, entityTable);
        return entityTable;
    }

    /**
     * 对象转包装类
     *
     * @param entityTable
     * @return
     */
    public static EntityTableVO objToVo(EntityTable entityTable) {
        if (entityTable == null) {
            return null;
        }
        EntityTableVO entityTableVO = new EntityTableVO();
        BeanUtils.copyProperties(entityTable, entityTableVO);
        return entityTableVO;
    }
}
