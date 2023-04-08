package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.web.domain.KyEnterprise;
import com.ruoyi.web.domain.KyEnterpriseProjectDeclaration;
import com.ruoyi.web.domain.KyOriginalPolicy;
import com.ruoyi.web.domain.KyProjectDeclaration;
import com.ruoyi.web.mapper.KyOriginalPolicyMapper;
import com.ruoyi.web.service.IKyEnterpriseProjectDeclarationService;
import com.ruoyi.web.service.IKyEnterpriseService;
import com.ruoyi.web.service.IKyOriginalPolicyService;
import com.ruoyi.web.service.IKyProjectDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 政策管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
@Service
public class KyOriginalPolicyServiceImpl implements IKyOriginalPolicyService
{
    @Autowired
    private KyOriginalPolicyMapper kyOriginalPolicyMapper;

    /**
     * 查询政策管理
     * 
     * @param id 政策管理主键
     * @return 政策管理
     */
    @Override
    public KyOriginalPolicy selectKyOriginalPolicyById(Long id)
    {
        return kyOriginalPolicyMapper.selectKyOriginalPolicyById(id);
    }

    /**
     * 查询政策管理列表
     * 
     * @param kyOriginalPolicy 政策管理
     * @return 政策管理
     */
    @Override
    public List<KyOriginalPolicy> selectKyOriginalPolicyList(KyOriginalPolicy kyOriginalPolicy)
    {
        return kyOriginalPolicyMapper.selectKyOriginalPolicyList(kyOriginalPolicy);
    }

    @Override
    public int updateKyOriginalPolicy(KyOriginalPolicy kyOriginalPolicy) {
        return kyOriginalPolicyMapper.updateKyOriginalPolicy(kyOriginalPolicy);
    }
}
