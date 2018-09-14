package com.smallow.webframe.modular.group.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.smallow.webframe.common.controller.BaseController;
import com.smallow.webframe.modular.group.mapper.ClubGroupMapper;
import com.smallow.webframe.modular.group.model.ClubGroup;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/group")
public class GroupController extends BaseController {
    private static String PREFIX = "club/group";

    @Autowired
    private ClubGroupMapper clubGroupMapper;

    @GetMapping("")
    public String index() {
        return PREFIX + "/group";
    }


    @RequestMapping("/add")
    public String groupAdd() {
        return PREFIX + "/group_add";
    }

    @PostMapping("/list")
    @ResponseBody
    public Object list(Integer page,
                       Integer pageSize,
                       Integer state,
                       String masterPhone,
                       String name,
                       String masterName) {
        Map<String, Object> returnData = new HashMap<>();
        PageHelper.startPage(page, pageSize);
        Example example = new Example(ClubGroup.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name))
            criteria.andLike("name", "%" + name + "%");
        if (!StringUtils.isEmpty(masterPhone))
            criteria.andEqualTo("masterPhone", masterPhone);
        if (!StringUtils.isEmpty(masterName))
            criteria.andLike("masterName", "%" + masterName + "%");
        if (state != null)
            criteria.andEqualTo("state", state);
        List<ClubGroup> list = clubGroupMapper.selectByExample(example);
        returnData.put("content", list);
        returnData.put("currentPage", page);
        returnData.put("pageSize", pageSize);
        returnData.put("totalPage", ((Page<ClubGroup>) list).getPages());
        returnData.put("totalElements", ((Page<ClubGroup>) list).getTotal());
        return returnData;
    }

    @PostMapping("/save")
    @ResponseBody
    public Object save(@Valid ClubGroup form,
                       BindingResult bindingResult,
                       Map<String, Object> map) {
        ClubGroup group = new ClubGroup();
        try {
            if (form.getId() != null) {
                group = clubGroupMapper.selectByPrimaryKey(form.getId());
            }
            BeanUtils.copyProperties(form, group);

            clubGroupMapper.updateByPrimaryKeySelective(group);
        } catch (Exception e) {
            map.put("msg", e.getMessage());

            return new ModelAndView("common/error", map);
        }
       // map.put("url",  CommonUtil.getContextPath()+"/admin/group/list");
        return new ModelAndView("common/success", map);

    }
}
