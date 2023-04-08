package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.KyOriginalPolicy;

import java.util.List;

/**
 * 政策管理Service接口
 * 
 * @author ruoyi
 * @date 2023-03-11
 */
public interface IKyOriginalPolicyService 
{
    /**
     * 查询政策管理
     * 
     * @param id 政策管理主键
     * @return 政策管理
     */
    public KyOriginalPolicy selectKyOriginalPolicyById(Long id);

    /**
     * 查询政策管理列表
     * 
     * @param kyOriginalPolicy 政策管理
     * @return 政策管理集合
     */
    public List<KyOriginalPolicy> selectKyOriginalPolicyList(KyOriginalPolicy kyOriginalPolicy);
    /**
     * 修改政策管理
     *
     * @param kyOriginalPolicy 政策管理
     * @return 结果
     */
    public int updateKyOriginalPolicy(KyOriginalPolicy kyOriginalPolicy);

}
