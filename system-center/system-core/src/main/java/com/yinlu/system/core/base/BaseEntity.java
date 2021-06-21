package com.yinlu.system.core.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author dzhao1
 */
@Data
public class BaseEntity implements Serializable {
  private static final long   serialVersionUID = 1L;
  @TableId(value = "id",type = IdType.AUTO)
  private Long id;
  /**
   * 创建时间
   */
  @TableField(value = "create_at")
  private LocalDateTime createAt;

  /**
   * 创建者
   */
  @TableField(value = "create_by")
  private String createBy;

  /**
   * 更新时间
   */
  @TableField(value = "modified_at")
  private LocalDateTime modifiedAt;

  /**
   * 更新者
   */
  @TableField(value = "modified_by")
  private String modifiedBy;

}
