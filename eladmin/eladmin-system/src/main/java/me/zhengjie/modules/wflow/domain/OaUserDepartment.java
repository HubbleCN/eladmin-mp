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
public class OaUserDepartment extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -45475579271153023L;

    @TableId(type = IdType.AUTO)

    private Integer id;
    /**
    * 用户ID
    */
    private String userId;
    /**
    * 部门ID
    */
    private Integer deptId;

}
