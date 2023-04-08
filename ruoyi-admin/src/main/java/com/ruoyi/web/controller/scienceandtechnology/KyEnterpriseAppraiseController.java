package com.ruoyi.web.controller.scienceandtechnology;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.web.domain.KyEnterpriseAppraise;
import com.ruoyi.web.service.IKyEnterpriseAppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 企业用户评价Controller
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
@RestController
@RequestMapping("/scienceandtechnology/appraise")
public class KyEnterpriseAppraiseController extends BaseController
{
    @Autowired
    private IKyEnterpriseAppraiseService kyEnterpriseAppraiseService;

    /**
     * 查询企业用户评价列表
     */
    @GetMapping("/list")
    public AjaxResult list(KyEnterpriseAppraise kyEnterpriseAppraise)
    {
        List<KyEnterpriseAppraise> list = kyEnterpriseAppraiseService.selectKyEnterpriseAppraiseList(kyEnterpriseAppraise);
        return success(list);
    }

    /**
     * 获取企业用户评价详细信息
     */
    @GetMapping(value = "/{enterpriseProjectDeclarationId}")
        public AjaxResult getInfo(@PathVariable("enterpriseProjectDeclarationId") Long enterpriseProjectDeclarationId)
    {
        KyEnterpriseAppraise kyEnterpriseAppraise=new KyEnterpriseAppraise();
        kyEnterpriseAppraise.setEnterpriseProjectDeclarationId(enterpriseProjectDeclarationId);
        return success(kyEnterpriseAppraiseService.selectKyEnterpriseAppraiseList(kyEnterpriseAppraise));
    }

    /**
     * 新增企业用户评价
     */
    @Log(title = "企业用户评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KyEnterpriseAppraise kyEnterpriseAppraise)
    {
        kyEnterpriseAppraise.setEnterpriseId(SecurityUtils.getLoginUser().getUser().getEnterpriseId());
        kyEnterpriseAppraise.setAppraiseTime(new Date());
        kyEnterpriseAppraise.setStatus(1l);
        kyEnterpriseAppraise.setSysUserEnterpriseId(SecurityUtils.getUserId());
        kyEnterpriseAppraise.setIrrigationDitch("pc端");
        return toAjax(kyEnterpriseAppraiseService.updateKyEnterpriseAppraise(kyEnterpriseAppraise));
    }


}
