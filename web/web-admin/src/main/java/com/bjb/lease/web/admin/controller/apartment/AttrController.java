package com.bjb.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bjb.lease.common.result.Result;
import com.bjb.lease.model.entity.AttrKey;
import com.bjb.lease.model.entity.AttrValue;
import com.bjb.lease.web.admin.service.AttrKeyService;
import com.bjb.lease.web.admin.service.AttrValueService;
import com.bjb.lease.web.admin.vo.attr.AttrKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "房间属性管理")
@RestController
@RequestMapping("/admin/attr")
public class AttrController
{
    @Autowired
    private AttrKeyService attrKeyservice;

    @Autowired
    private AttrValueService attrValueService;

    @Operation(summary = "新增或更新属性名称")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateAttrKey(@RequestBody AttrKey attrKey)
    {
        attrKeyservice.saveOrUpdate(attrKey);
        return Result.ok();
    }

    @Operation(summary = "新增或更新属性值")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateAttrValue(@RequestBody AttrValue attrValue)
    {
        attrValueService.saveOrUpdate(attrValue);
        return Result.ok();
    }


    @Operation(summary = "查询全部属性名称和属性值列表")
    @GetMapping("list")
    public Result<List<AttrKeyVo>> listAttrInfo()
    {
        List<AttrKeyVo> list = attrKeyservice.listAttrInfo();
        return Result.ok(list);
    }

    @Operation(summary = "根据id删除属性名称")
    @DeleteMapping("key/deleteById")
    public Result removeAttrKeyById(@RequestParam Long attrKeyId)
    {
        attrKeyservice.removeById(attrKeyId);   //删除属性名称
        LambdaQueryWrapper<AttrValue> querywrapper = new LambdaQueryWrapper<>();
        querywrapper.eq(AttrValue::getAttrKeyId, attrKeyId);
        attrValueService.remove(querywrapper);
        return Result.ok();
    }

    @Operation(summary = "根据id删除属性值")
    @DeleteMapping("value/deleteById")
    public Result removeAttrValueById(@RequestParam Long id)
    {
        attrValueService.removeById(id);
        return Result.ok();
    }

}
