package me.zhengjie.modules.wflow.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.zhengjie.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OaRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 685445053985109974L;

    @TableId(type = IdType.AUTO)
    private Integer roleId;
    /**
    * 标签ID
    */
    private String roleName;
    /**
    * 创建时间
    */
    private Date credted;


}
