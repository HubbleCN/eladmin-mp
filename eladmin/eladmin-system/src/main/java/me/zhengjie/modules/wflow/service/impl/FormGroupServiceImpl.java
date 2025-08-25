package me.zhengjie.modules.wflow.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.zhengjie.modules.wflow.domain.OaFormGroup;
import me.zhengjie.modules.wflow.domain.OaForm;
import me.zhengjie.modules.wflow.domain.vo.FormGroupVo;
import me.zhengjie.modules.wflow.mapper.OaFormGroupsMapper;
import me.zhengjie.modules.wflow.mapper.OaFormsMapper;
import me.zhengjie.modules.wflow.service.FormGroupService;
import me.zhengjie.modules.wflow.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : willian fu
 * @date : 2022/7/4
 */
@Slf4j
@Service
public class FormGroupServiceImpl implements FormGroupService {

    @Autowired
    private OaFormGroupsMapper groupsMapper;

    @Autowired
    private OaFormsMapper formsMapper;

    @Override
    public Object getFormGroups(String token, String name) {
        List<FormGroupVo> formGroupVos = new LinkedList<>();
        groupsMapper.selectList(new QueryWrapper<OaFormGroup>()
                .orderByAsc("sort")).forEach(group -> {
            FormGroupVo formGroupVo = FormGroupVo.builder()
                    .id(group.getGroupId())
                    .name(group.getGroupName())
                    .items(new LinkedList<>())
                    .build();
            formGroupVos.add(formGroupVo);
            formsMapper.selectList(new QueryWrapper<OaForm>()
                    .select("form_id", "form_name", "logo", "settings", "remark", "is_stop", "updated")
                    .eq("is_delete", false)
                    .eq("group_id", group.getGroupId())
                    .orderByAsc("sort")).forEach(from -> {
                formGroupVo.getItems().add(FormGroupVo.Form.builder()
                        .formId(from.getFormId())
                        .formName(from.getFormName())
                        .logo(from.getLogo())
                        .remark(from.getRemark())
                        .isStop(from.getIsStop())
                        .updated(from.getUpdated())
                        .build());
            });
        });
        return R.ok(formGroupVos);
    }

    @Override
    public Object formGroupsSort(List<Integer> groups) {
        return null;
    }

    @Override
    public Object getFormById(String formId) {
        OaForm oaForm = formsMapper.selectById(formId);
        return R.ok(oaForm);
    }

    @Override
    public Object updateFormGroupName(Integer id, String name) {
        groupsMapper.updateById(OaFormGroup.builder().groupId(id).groupName(name).build());
        return R.ok("更新成功");
    }

    @Override
    public Object createFormGroup(String name) {
        groupsMapper.insert(OaFormGroup.builder().sort(1).groupName(name).updated(new Date()).build());
        return R.ok("新增成功");
    }

    @Override
    public Object deleteFormGroup(Integer id) {
        return null;
    }

    @Override
    public Object updateForm(String formId, String type, Integer groupId) {
        OaForm build = OaForm.builder().formId(formId).isStop("stop".equals(type)).groupId(groupId).build();
        formsMapper.updateById(build);
        return R.ok("操作成功");
    }

    @Override
    public Object updateFormDetail(OaForm forms) {
        forms.setSort(null);
        forms.setIsDelete(null);
        forms.setIsStop(null);
        forms.setUpdated(new Date());
        formsMapper.updateById(forms);
        return R.ok("操作成功");
    }

    @Override
    public Object formsSort(Integer groupId, List<String> fromIds) {
        OaForm oaForm = OaForm.builder().groupId(groupId).build();
        for (int i = 0; i < fromIds.size(); i++) {
            oaForm.setFormId(fromIds.get(i));
            oaForm.setSort(i);
            formsMapper.updateById(oaForm);
        }
        return R.ok("更新成功");
    }

    @Override
    public Object getFormGroupList() {
        return groupsMapper.selectList(new QueryWrapper<OaFormGroup>().orderByAsc("sort"));
    }

    @Override
    public Object createForm(OaForm form) {
        Date time = GregorianCalendar.getInstance().getTime();
        OaForm oaForm = OaForm.builder()
                .groupId(form.getGroupId())
                .formId(IdUtil.simpleUUID())
                .formItems(form.getFormItems())
                .formName(form.getFormName())
                .logo(form.getLogo())
                .process(form.getProcess())
                .settings(form.getSettings())
                .sort(0)
                .isStop(false)
                .isDelete(false)
                .created(time)
                .updated(time)
                .build();
        formsMapper.insert(oaForm);
        return R.ok("创建表单成功");
    }
}
