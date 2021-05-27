package com.yinlu.system.generator.model;

import com.baomidou.mybatisplus.annotation.TableField;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * @author dzhao1
 */
@Data
public class MysqlTableInfo {

    /**
     * mysql 默认值def
     */
    @TableField("TABLE_CATALOG")
    private String tableCatalog;
    /**
     * 表所有者
     */
    @TableField("TABLE_SCHEMA")
    private String tableSchema;
    /**
     * 表名
     */
    @TableField("TABLE_NAME")
    private String tableName;
    /**
     * 字段
     */
//    private Column column;
//    @Data
//    private static class Column{
        /**
         * 字段编号
         */
        @TableField("ORDINAL_POSITION")
        private String ordinalPosition;
        /**
         * 字段名
         */
        @TableField("COLUMN_NAME")
        private String columnName;
        /**
         * 数据类型
         */
        @TableField("DATA_TYPE")
        private String dataType;
        /**
         * 字段默认值
         */
        @TableField("COLUMN_DEFAULT")
        private String columnDefault;
        /**
         * 是否允许为空
         */
        @TableField("IS_NULLABLE")
        private String isNullable;
        /**
         * 字段备注
         */
        @TableField("COLUMN_COMMENT")
        private String columnComment;
        /**
         * 键类型
         */
        @TableField("COLUMN_KEY")
        private String columnKey;
//    }
}
