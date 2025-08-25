package me.zhengjie.modules.wflow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.zhengjie.modules.wflow.domain.OaDepartment;
import me.zhengjie.modules.wflow.domain.vo.OrgTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : willian fu
 * @date : 2022/6/27
 */
public interface OaDepartmentsMapper extends BaseMapper<OaDepartment> {

    @Select("SELECT id, dept_name `name`, 'dept' AS 'type' FROM oa_department WHERE parent_id=#{deptId}")
    List<OrgTreeVo> selectByDept(@Param("deptId") Integer deptId);
}
