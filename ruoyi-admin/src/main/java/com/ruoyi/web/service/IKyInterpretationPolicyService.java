package com.ruoyi.web.service;

import com.ruoyi.web.domain.KyInterpretationPolicy;
import com.ruoyi.web.domain.KyOriginalPolicy;

import java.util.List;

/**
 * 政策解读Service接口
 * 
 * @author ruoyi
 * @date 2023-03-13
 */
public interface IKyInterpretationPolicyService 
{
    /**
     * 查询政策解读
     * 
     * @param id 政策解读主键
     * @return 政策解读
     */
    public KyInterpretationPolicy selectKyInterpretationPolicyById(Long id);

    /**
     * 查询政策解读列表
     * 
     * @param KyOriginalPolicy 政策解读
     * @return 政策解读集合
     */
    public List<KyOriginalPolicy> selectKyInterpretationPolicyList(KyOriginalPolicy originalPolicy);



    KyInterpretationPolicy selectKyInterpretationPolicyByOriginalpolicyId(Long id);
}
