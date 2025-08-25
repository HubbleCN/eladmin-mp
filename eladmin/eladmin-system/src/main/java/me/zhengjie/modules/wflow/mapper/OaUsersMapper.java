package me.zhengjie.modules.wflow.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.zhengjie.modules.wflow.domain.OaUser;
import me.zhengjie.modules.wflow.domain.vo.OrgTreeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : willian fu
 * @date : 2022/6/27
 */
public interface OaUsersMapper extends BaseMapper<OaUser> {

    @Select("SELECT ou.user_id id, ou.user_name `name`, 'user' AS 'type', ou.avatar " +
            "FROM oa_user_department oud LEFT JOIN oa_user ou ON ou.user_id = oud.user_id " +
            "WHERE oud.dept_id = #{deptId}")
    List<OrgTreeVo> selectUsersByDept(@Param("deptId") Integer deptId);

    @Select("SELECT ou.user_id id, ou.user_name `name`, 'user' AS 'type', ou.avatar " +
            "FROM oa_user ou WHERE  pingyin LIKE '%${py}%' OR py LIKE '%${py}%'")
    List<OrgTreeVo> selectUsersByPy(@Param("py") String py);
}
