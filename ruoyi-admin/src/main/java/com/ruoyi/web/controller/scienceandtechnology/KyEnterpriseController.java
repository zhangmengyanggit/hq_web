package com.ruoyi.web.controller.scienceandtechnology;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.domain.KyEnterprise;
import com.ruoyi.web.service.IKyEnterpriseService;
import com.ruoyi.web.service.ISysUserEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 企业Controller
 * 
 * @author ruoyi
 * @date 2023-03-08
 */
@RestController
@RequestMapping("scienceandtechnology/enterprise")
public class KyEnterpriseController extends BaseController
{
    @Autowired
    private IKyEnterpriseService kyEnterpriseService;
    @Autowired
    private ISysUserEnterpriseService iSysUserEnterpriseService;




    /**
     * 获取企业详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(kyEnterpriseService.selectKyEnterpriseById(id));
    }


    /**
     * 修改企业
     */

    @Log(title = "企业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KyEnterprise kyEnterprise)
    {
        //根据企业id查询企业信息
        KyEnterprise enterpriseOrld=    kyEnterpriseService.selectKyEnterpriseById(kyEnterprise.getId());
        KyEnterprise kyEnterpriseCheck=null;
        if(enterpriseOrld!=null&&!kyEnterprise.getName().equals(enterpriseOrld.getName())){
            //判断企业名称是否已存在
            kyEnterpriseCheck =new KyEnterprise();
            kyEnterpriseCheck.setName(kyEnterprise.getName());
            Long count=  kyEnterpriseService.selectKyEnterpriseCount(kyEnterpriseCheck);
            if(count>0){
                return  AjaxResult.error("企业名称已存在");
            }
        }

        if(enterpriseOrld!=null&&!kyEnterprise.getSocialUnifiedCreditCodeNumber().equals(enterpriseOrld.getSocialUnifiedCreditCodeNumber())){
            //判断社会统一信用代码号唯一性
            kyEnterpriseCheck =new KyEnterprise();
            kyEnterpriseCheck.setSocialUnifiedCreditCodeNumber(kyEnterprise.getSocialUnifiedCreditCodeNumber());
            Long countSocialUnifiedCreditCodeNumber=  kyEnterpriseService.selectKyEnterpriseCount(kyEnterpriseCheck);
            if(countSocialUnifiedCreditCodeNumber>0){
                return  AjaxResult.error("统一社会信用代码已存在");
            }
        }
        //企业联系人电话更改则更新前端用户登录名称
        iSysUserEnterpriseService.updateSysUserEnterpriseByEnterprise(enterpriseOrld,kyEnterprise);
        return toAjax(kyEnterpriseService.updateKyEnterprise(kyEnterprise));
    }

}
