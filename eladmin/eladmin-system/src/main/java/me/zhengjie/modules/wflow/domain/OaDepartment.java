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
public class OaDepartment extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    /**
    * 部门id
    */
    private Integer id;
    /**
    * 部门名
    */
    private String deptName;
    /**
    * 部门主管
    */
    private String leader;
    /**
    * 父部门id
    */
    private Integer parentId;

}
