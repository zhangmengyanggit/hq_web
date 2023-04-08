package com.ruoyi.web.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.KyInterpretationPolicy;
import com.ruoyi.web.domain.KyOriginalPolicy;
import com.ruoyi.web.mapper.KyInterpretationPolicyMapper;
import com.ruoyi.web.service.IKyInterpretationPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 政策解读Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-13
 */
@Service
public class KyInterpretationPolicyServiceImpl implements IKyInterpretationPolicyService
{
    @Autowired
    private KyInterpretationPolicyMapper kyInterpretationPolicyMapper;

    /**
     * 查询政策解读
     * 
     * @param id 政策解读主键
     * @return 政策解读
     */
    @Override
    public KyInterpretationPolicy selectKyInterpretationPolicyById(Long id)
    {
        return kyInterpretationPolicyMapper.selectKyInterpretationPolicyById(id);
    }

    /**
     * 查询政策解读列表
     * 
     * @param kyInterpretationPolicy 政策解读
     * @return 政策解读
     */
    @Override
    public List<KyOriginalPolicy> selectKyInterpretationPolicyList(KyOriginalPolicy kyInterpretationPolicy)
    {
        return kyInterpretationPolicyMapper.selectKyInterpretationPolicyList(kyInterpretationPolicy);
    }



    @Override
    public KyInterpretationPolicy selectKyInterpretationPolicyByOriginalpolicyId(Long originalpolicyId) {
        return kyInterpretationPolicyMapper.selectKyInterpretationPolicyByOriginalpolicyId(originalpolicyId);
    }
}
