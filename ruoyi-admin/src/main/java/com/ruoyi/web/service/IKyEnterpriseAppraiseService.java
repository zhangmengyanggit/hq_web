package com.ruoyi.web.service;

import com.ruoyi.web.domain.KyEnterpriseAppraise;

import java.util.List;

/**
 * 企业用户评价Service接口
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
public interface IKyEnterpriseAppraiseService 
{
    /**
     * 查询企业用户评价
     * 
     * @param id 企业用户评价主键
     * @return 企业用户评价
     */
    public KyEnterpriseAppraise selectKyEnterpriseAppraiseById(Long id);

    /**
     * 查询企业用户评价列表
     * 
     * @param kyEnterpriseAppraise 企业用户评价
     * @return 企业用户评价集合
     */
    public List<KyEnterpriseAppraise> selectKyEnterpriseAppraiseList(KyEnterpriseAppraise kyEnterpriseAppraise);

    /**
     * 新增企业用户评价
     * 
     * @param kyEnterpriseAppraise 企业用户评价
     * @return 结果
     */
    public int insertKyEnterpriseAppraise(KyEnterpriseAppraise kyEnterpriseAppraise);

    /**
     * 修改企业用户评价
     * 
     * @param kyEnterpriseAppraise 企业用户评价
     * @return 结果
     */
    public int updateKyEnterpriseAppraise(KyEnterpriseAppraise kyEnterpriseAppraise);
}
