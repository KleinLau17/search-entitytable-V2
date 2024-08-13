package com.shangxun.search.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用主体表
 * @TableName entity_table
 */
@TableName(value ="entity_table")
@Data
public class EntityTable implements Serializable {
    /**
     * UUID
     */
    @TableId
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EntityTable other = (EntityTable) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getEntityCode() == null ? other.getEntityCode() == null : this.getEntityCode().equals(other.getEntityCode()))
            && (this.getCodeName() == null ? other.getCodeName() == null : this.getCodeName().equals(other.getCodeName()))
            && (this.getEntityType() == null ? other.getEntityType() == null : this.getEntityType().equals(other.getEntityType()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getEntityNo() == null ? other.getEntityNo() == null : this.getEntityNo().equals(other.getEntityNo()))
            && (this.getEntityName() == null ? other.getEntityName() == null : this.getEntityName().equals(other.getEntityName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getField0() == null ? other.getField0() == null : this.getField0().equals(other.getField0()))
            && (this.getField1() == null ? other.getField1() == null : this.getField1().equals(other.getField1()))
            && (this.getField2() == null ? other.getField2() == null : this.getField2().equals(other.getField2()))
            && (this.getField3() == null ? other.getField3() == null : this.getField3().equals(other.getField3()))
            && (this.getField4() == null ? other.getField4() == null : this.getField4().equals(other.getField4()))
            && (this.getField5() == null ? other.getField5() == null : this.getField5().equals(other.getField5()))
            && (this.getField6() == null ? other.getField6() == null : this.getField6().equals(other.getField6()))
            && (this.getField7() == null ? other.getField7() == null : this.getField7().equals(other.getField7()))
            && (this.getField8() == null ? other.getField8() == null : this.getField8().equals(other.getField8()))
            && (this.getField9() == null ? other.getField9() == null : this.getField9().equals(other.getField9()))
            && (this.getNumber0() == null ? other.getNumber0() == null : this.getNumber0().equals(other.getNumber0()))
            && (this.getNumber1() == null ? other.getNumber1() == null : this.getNumber1().equals(other.getNumber1()))
            && (this.getNumber2() == null ? other.getNumber2() == null : this.getNumber2().equals(other.getNumber2()))
            && (this.getNumber3() == null ? other.getNumber3() == null : this.getNumber3().equals(other.getNumber3()))
            && (this.getNumber4() == null ? other.getNumber4() == null : this.getNumber4().equals(other.getNumber4()))
            && (this.getNumber5() == null ? other.getNumber5() == null : this.getNumber5().equals(other.getNumber5()))
            && (this.getDate1() == null ? other.getDate1() == null : this.getDate1().equals(other.getDate1()))
            && (this.getDate2() == null ? other.getDate2() == null : this.getDate2().equals(other.getDate2()))
            && (this.getDate3() == null ? other.getDate3() == null : this.getDate3().equals(other.getDate3()))
            && (this.getDate4() == null ? other.getDate4() == null : this.getDate4().equals(other.getDate4()))
            && (this.getDatetime1() == null ? other.getDatetime1() == null : this.getDatetime1().equals(other.getDatetime1()))
            && (this.getDatetime2() == null ? other.getDatetime2() == null : this.getDatetime2().equals(other.getDatetime2()))
            && (this.getAccessory() == null ? other.getAccessory() == null : this.getAccessory().equals(other.getAccessory()))
            && (this.getAccessory1() == null ? other.getAccessory1() == null : this.getAccessory1().equals(other.getAccessory1()))
            && (this.getAccessory2() == null ? other.getAccessory2() == null : this.getAccessory2().equals(other.getAccessory2()))
            && (this.getAccessory3() == null ? other.getAccessory3() == null : this.getAccessory3().equals(other.getAccessory3()))
            && (this.getAccessory4() == null ? other.getAccessory4() == null : this.getAccessory4().equals(other.getAccessory4()))
            && (this.getAccessory5() == null ? other.getAccessory5() == null : this.getAccessory5().equals(other.getAccessory5()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRemark1() == null ? other.getRemark1() == null : this.getRemark1().equals(other.getRemark1()))
            && (this.getRemark2() == null ? other.getRemark2() == null : this.getRemark2().equals(other.getRemark2()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getEntityCode() == null) ? 0 : getEntityCode().hashCode());
        result = prime * result + ((getCodeName() == null) ? 0 : getCodeName().hashCode());
        result = prime * result + ((getEntityType() == null) ? 0 : getEntityType().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getEntityNo() == null) ? 0 : getEntityNo().hashCode());
        result = prime * result + ((getEntityName() == null) ? 0 : getEntityName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getField0() == null) ? 0 : getField0().hashCode());
        result = prime * result + ((getField1() == null) ? 0 : getField1().hashCode());
        result = prime * result + ((getField2() == null) ? 0 : getField2().hashCode());
        result = prime * result + ((getField3() == null) ? 0 : getField3().hashCode());
        result = prime * result + ((getField4() == null) ? 0 : getField4().hashCode());
        result = prime * result + ((getField5() == null) ? 0 : getField5().hashCode());
        result = prime * result + ((getField6() == null) ? 0 : getField6().hashCode());
        result = prime * result + ((getField7() == null) ? 0 : getField7().hashCode());
        result = prime * result + ((getField8() == null) ? 0 : getField8().hashCode());
        result = prime * result + ((getField9() == null) ? 0 : getField9().hashCode());
        result = prime * result + ((getNumber0() == null) ? 0 : getNumber0().hashCode());
        result = prime * result + ((getNumber1() == null) ? 0 : getNumber1().hashCode());
        result = prime * result + ((getNumber2() == null) ? 0 : getNumber2().hashCode());
        result = prime * result + ((getNumber3() == null) ? 0 : getNumber3().hashCode());
        result = prime * result + ((getNumber4() == null) ? 0 : getNumber4().hashCode());
        result = prime * result + ((getNumber5() == null) ? 0 : getNumber5().hashCode());
        result = prime * result + ((getDate1() == null) ? 0 : getDate1().hashCode());
        result = prime * result + ((getDate2() == null) ? 0 : getDate2().hashCode());
        result = prime * result + ((getDate3() == null) ? 0 : getDate3().hashCode());
        result = prime * result + ((getDate4() == null) ? 0 : getDate4().hashCode());
        result = prime * result + ((getDatetime1() == null) ? 0 : getDatetime1().hashCode());
        result = prime * result + ((getDatetime2() == null) ? 0 : getDatetime2().hashCode());
        result = prime * result + ((getAccessory() == null) ? 0 : getAccessory().hashCode());
        result = prime * result + ((getAccessory1() == null) ? 0 : getAccessory1().hashCode());
        result = prime * result + ((getAccessory2() == null) ? 0 : getAccessory2().hashCode());
        result = prime * result + ((getAccessory3() == null) ? 0 : getAccessory3().hashCode());
        result = prime * result + ((getAccessory4() == null) ? 0 : getAccessory4().hashCode());
        result = prime * result + ((getAccessory5() == null) ? 0 : getAccessory5().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRemark1() == null) ? 0 : getRemark1().hashCode());
        result = prime * result + ((getRemark2() == null) ? 0 : getRemark2().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", entityCode=").append(entityCode);
        sb.append(", codeName=").append(codeName);
        sb.append(", entityType=").append(entityType);
        sb.append(", typeName=").append(typeName);
        sb.append(", entityNo=").append(entityNo);
        sb.append(", entityName=").append(entityName);
        sb.append(", status=").append(status);
        sb.append(", field0=").append(field0);
        sb.append(", field1=").append(field1);
        sb.append(", field2=").append(field2);
        sb.append(", field3=").append(field3);
        sb.append(", field4=").append(field4);
        sb.append(", field5=").append(field5);
        sb.append(", field6=").append(field6);
        sb.append(", field7=").append(field7);
        sb.append(", field8=").append(field8);
        sb.append(", field9=").append(field9);
        sb.append(", number0=").append(number0);
        sb.append(", number1=").append(number1);
        sb.append(", number2=").append(number2);
        sb.append(", number3=").append(number3);
        sb.append(", number4=").append(number4);
        sb.append(", number5=").append(number5);
        sb.append(", date1=").append(date1);
        sb.append(", date2=").append(date2);
        sb.append(", date3=").append(date3);
        sb.append(", date4=").append(date4);
        sb.append(", datetime1=").append(datetime1);
        sb.append(", datetime2=").append(datetime2);
        sb.append(", accessory=").append(accessory);
        sb.append(", accessory1=").append(accessory1);
        sb.append(", accessory2=").append(accessory2);
        sb.append(", accessory3=").append(accessory3);
        sb.append(", accessory4=").append(accessory4);
        sb.append(", accessory5=").append(accessory5);
        sb.append(", remark=").append(remark);
        sb.append(", remark1=").append(remark1);
        sb.append(", remark2=").append(remark2);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
