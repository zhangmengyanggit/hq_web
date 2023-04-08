package com.ruoyi.web.service.impl;

import com.ruoyi.web.domain.KyEnterpriseAppraise;
import com.ruoyi.web.mapper.KyEnterpriseAppraiseMapper;
import com.ruoyi.web.service.IKyEnterpriseAppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 企业用户评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-29
 */
@Service
public class KyEnterpriseAppraiseServiceImpl implements IKyEnterpriseAppraiseService
{
    @Autowired
    private KyEnterpriseAppraiseMapper kyEnterpriseAppraiseMapper;

    /**
     * 查询企业用户评价
     * 
     * @param id 企业用户评价主键
     * @return 企业用户评价
     */
    @Override
    public KyEnterpriseAppraise selectKyEnterpriseAppraiseById(Long id)
    {
        return kyEnterpriseAppraiseMapper.selectKyEnterpriseAppraiseById(id);
    }

    /**
     * 查询企业用户评价列表
     * 
     * @param kyEnterpriseAppraise 企业用户评价
     * @return 企业用户评价
     */
    @Override
    public List<KyEnterpriseAppraise> selectKyEnterpriseAppraiseList(KyEnterpriseAppraise kyEnterpriseAppraise)
    {
        return kyEnterpriseAppraiseMapper.selectKyEnterpriseAppraiseList(kyEnterpriseAppraise);
    }

    /**
     * 新增企业用户评价
     * 
     * @param kyEnterpriseAppraise 企业用户评价
     * @return 结果
     */
    @Override
    public int insertKyEnterpriseAppraise(KyEnterpriseAppraise kyEnterpriseAppraise)
    {
        return kyEnterpriseAppraiseMapper.insertKyEnterpriseAppraise(kyEnterpriseAppraise);
    }

    /**
     * 修改企业用户评价
     * 
     * @param kyEnterpriseAppraise 企业用户评价
     * @return 结果
     */
    @Override
    public int updateKyEnterpriseAppraise(KyEnterpriseAppraise kyEnterpriseAppraise)
    {
        return kyEnterpriseAppraiseMapper.updateKyEnterpriseAppraise(kyEnterpriseAppraise);
    }
}
