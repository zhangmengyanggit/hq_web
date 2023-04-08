package com.ruoyi.web.controller.scienceandtechnology;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.web.service.IKyEnterpriseProjectDeclarationService;
import com.ruoyi.web.vo.KyEnterpriseProjectDeclarationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 企业申请项目Controller
 * 
 * @author ruoyi
 * @date 2023-03-16
 */
@RestController
@RequestMapping("/scienceandtechnology/enterpriseprojectdeclaration")
public class KyEnterpriseProjectDeclarationController extends BaseController
{
    @Autowired
    private IKyEnterpriseProjectDeclarationService kyEnterpriseProjectDeclarationService;

    /**
     * 查询企业申请项目列表
     */
    @GetMapping("/list")
    public TableDataInfo list(KyEnterpriseProjectDeclarationVo kyEnterpriseProjectDeclarationVo)
    {
        startPage();
        kyEnterpriseProjectDeclarationVo.setEnterpriseId(SecurityUtils.getLoginUser().getUser().getEnterpriseId());
        List<KyEnterpriseProjectDeclarationVo> list = kyEnterpriseProjectDeclarationService.selectKyEnterpriseProjectDeclarationList(kyEnterpriseProjectDeclarationVo);
        return getDataTable(list);
    }


    /**
     * 获取企业申请项目详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(kyEnterpriseProjectDeclarationService.selectKyEnterpriseProjectDeclarationById(id));
    }


    /**
     * 企业申请项目
     */
    @Log(title = "企业申请项目", businessType = BusinessType.UPDATE)
	@PostMapping("/applyFor")
    public AjaxResult batchAudit(@RequestBody KyEnterpriseProjectDeclarationVo enterpriseProjectDeclaration)
    {
        return toAjax(kyEnterpriseProjectDeclarationService.applyForKyEnterpriseProjectDeclaration(enterpriseProjectDeclaration));
    }


}
