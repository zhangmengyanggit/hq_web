package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.KyEnterprise;

import java.util.List;

/**
 * 企业Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-08
 */
public interface KyEnterpriseMapper 
{
    /**
     * 查询企业
     * 
     * @param id 企业主键
     * @return 企业
     */
    public KyEnterprise selectKyEnterpriseById(Long id);

    /**
     * 修改企业
     * 
     * @param kyEnterprise 企业
     * @return 结果
     */
    public int updateKyEnterprise(KyEnterprise kyEnterprise);


    Long selectKyEnterpriseCount(KyEnterprise kyEnterprise);

    List<KyEnterprise> selectByUserEnterpriseName(String userName);
}
