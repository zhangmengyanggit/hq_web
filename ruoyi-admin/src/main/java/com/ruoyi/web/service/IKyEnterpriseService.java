package com.ruoyi.web.service;

import com.ruoyi.web.domain.KyEnterprise;

import java.util.List;

/**
 * 企业Service接口
 * 
 * @author ruoyi
 * @date 2023-03-08
 */
public interface IKyEnterpriseService 
{

    /**
     * 修改企业
     * 
     * @param kyEnterprise 企业
     * @return 结果
     */
    public int updateKyEnterprise(KyEnterprise kyEnterprise);

    /**
     * 查询企业
     *
     * @param id 企业主键
     * @return 企业
     */
    public KyEnterprise selectKyEnterpriseById(Long id);


    Long selectKyEnterpriseCount(KyEnterprise kyEnterprise);
}
