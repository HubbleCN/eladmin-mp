package me.zhengjie.modules.wflow.service.impl;

import lombok.RequiredArgsConstructor;
import me.zhengjie.modules.wflow.domain.vo.OrgTreeVo;
import me.zhengjie.modules.wflow.mapper.OaDepartmentsMapper;
import me.zhengjie.modules.wflow.mapper.OaUsersMapper;
import me.zhengjie.modules.wflow.service.OrgUserAndDeptService;
import me.zhengjie.modules.wflow.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : willian fu
 * @version : 1.0
 */
@Service
@RequiredArgsConstructor
public class OrgUserAndDeptServiceImpl implements OrgUserAndDeptService {

    @Autowired
    private final OaDepartmentsMapper departsMapper;

    @Autowired
    private final OaUsersMapper usersMapper;

    /**
     * 查询组织架构树
     *
     * @param deptId    部门id
     * @param isDept    只查询部门架构
     * @param showLeave 是否显示离职员工
     * @return 组织架构树数据
     */
    @Override
    public Object getOrgTreeData(Integer deptId, Boolean isDept, Boolean showLeave) {
        //查询所有部门及员工
        List<OrgTreeVo> orgs = new LinkedList<>();
        orgs.addAll(departsMapper.selectByDept(deptId));
        if (!isDept){
            usersMapper.selectUsersByDept(deptId).forEach(us -> orgs.add(us));
        }
        return R.ok(orgs);
    }

    /**
     * 模糊搜索用户
     *
     * @param userName 用户名/拼音/首字母
     * @return 匹配到的用户
     */
    @Override
    public Object getOrgTreeUser(String userName) {
        return R.ok(usersMapper.selectUsersByPy(userName));
    }
}
