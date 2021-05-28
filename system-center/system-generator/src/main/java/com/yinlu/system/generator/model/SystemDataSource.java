package com.yinlu.system.generator.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author dzhao1
 * @TableName system_data_source
 */
@TableName(value ="system_data_source")
@Data
public class SystemDataSource implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数据源名称
     */
    @TableField(value = "source_name")
    private String sourceName;

    /**
     * 数据库登入名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 数据库登入凭证
     */
    @TableField(value = "password")
    private String password;

    /**
     * 数据库连接地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 数据库连接驱动
     */
    @TableField(value = "driver")
    private String driver;

    /**
     * 创建时间
     */
    @TableField(value = "create_at",fill = FieldFill.INSERT)
    private LocalDateTime createAt;

    /**
     * 更新时间
     */
    @TableField(value = "modified_at",fill = FieldFill.UPDATE)
    private LocalDateTime modifiedAt;
    /**
     * 是否默认数据源
     */
    @TableField("primary")
    private Boolean primary;
    @TableField("data_type")
    private String dataType;

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
        SystemDataSource other = (SystemDataSource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSourceName() == null ? other.getSourceName() == null : this.getSourceName().equals(other.getSourceName()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getDriver() == null ? other.getDriver() == null : this.getDriver().equals(other.getDriver()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getModifiedAt() == null ? other.getModifiedAt() == null : this.getModifiedAt().equals(other.getModifiedAt())
            && (this.getPrimary() == null ? other.getPrimary() == null : this.getPrimary().equals(other.getPrimary()))
            && (this.getDataType() == null ? other.getDataType() == null : this.getDataType().equals(other.getDataType())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSourceName() == null) ? 0 : getSourceName().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getDriver() == null) ? 0 : getDriver().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getModifiedAt() == null) ? 0 : getModifiedAt().hashCode());
        result = prime * result + ((getPrimary()==null) ? 0 : getPrimary().hashCode());
        result = prime * result + ((getDataType()==null) ? 0 : getDataType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sourceName=").append(sourceName);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", url=").append(url);
        sb.append(", driver=").append(driver);
        sb.append(", createAt=").append(createAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(",dataType=").append(dataType);
        sb.append(",Primary").append(primary);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}