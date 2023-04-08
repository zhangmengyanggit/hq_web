package com.ruoyi.web.controller.scienceandtechnology;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.OfficialSealUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.sign.Md5Utils;
import com.ruoyi.web.domain.KyInterpretationPolicy;
import com.ruoyi.web.domain.KyOriginalPolicy;
import com.ruoyi.web.service.IKyInterpretationPolicyService;
import com.ruoyi.web.service.IKyOriginalPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 政策管理Controller
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
@RestController
@RequestMapping("/scienceandtechnology/originalpolicy")
public class KyOriginalPolicyController extends BaseController
{
    @Autowired
    private IKyOriginalPolicyService kyOriginalPolicyService;
    @Autowired
    private IKyInterpretationPolicyService iKyInterpretationPolicyService;
    /**
     * 查询政策管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(KyOriginalPolicy kyOriginalPolicy)
    {
        startPage();
        kyOriginalPolicy.setPublishStatus(2l);
        List<KyOriginalPolicy> list = kyOriginalPolicyService.selectKyOriginalPolicyList(kyOriginalPolicy);
        return getDataTable(list);
    }
    /**
     * 查询政策解读管理列表
     */
    @GetMapping("/interpretationPolicyList")
    public TableDataInfo listInterpretationPolicy(KyOriginalPolicy kyOriginalPolicy)
    {
        startPage();
        kyOriginalPolicy.setPublishStatus(2l);
        List<KyOriginalPolicy> list = iKyInterpretationPolicyService.selectKyInterpretationPolicyList(kyOriginalPolicy);
        return getDataTable(list);
    }
    /**
     * 获取政策管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(kyOriginalPolicyService.selectKyOriginalPolicyById(id));
    }



    /**
     * 获取政策解读信息
     */
    @GetMapping(value = "/getInterpretationPolicy/{id}")
    public AjaxResult getInterpretationPolicy(@PathVariable("id") Long id)
    {
        KyInterpretationPolicy interpretationPolicy=  iKyInterpretationPolicyService.selectKyInterpretationPolicyByOriginalpolicyId(id);
        if(interpretationPolicy==null){
            interpretationPolicy=new KyInterpretationPolicy();
        }
        return success(interpretationPolicy);
    }




}
