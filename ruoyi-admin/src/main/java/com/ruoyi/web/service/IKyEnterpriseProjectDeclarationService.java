package com.ruoyi.web.service;

import com.ruoyi.web.domain.KyEnterpriseProjectDeclaration;
import com.ruoyi.web.vo.KyEnterpriseProjectDeclarationVo;

import java.util.List;
import java.util.Map;

/**
 * 企业申请项目Service接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface IKyEnterpriseProjectDeclarationService 
{
    /**
     * 查询企业申请项目
     * 
     * @param id 企业申请项目主键
     * @return 企业申请项目
     */
    public KyEnterpriseProjectDeclarationVo selectKyEnterpriseProjectDeclarationById(Long id);

    /**
     * 查询企业申请项目列表
     * 
     * @param kyEnterpriseProjectDeclaration 企业申请项目
     * @return 企业申请项目集合
     */
    public List<KyEnterpriseProjectDeclarationVo> selectKyEnterpriseProjectDeclarationList(KyEnterpriseProjectDeclarationVo kyEnterpriseProjectDeclaration);





    Long selectKyEnterpriseProjectDeclarationCountByParams(Map<String, Object> paramsMap);

    /**
     * 企业申请项目
     *
     * @param enterpriseProjectDeclaration  政策项目属性
     * @return 结果
     */
    public  int applyForKyEnterpriseProjectDeclaration(KyEnterpriseProjectDeclarationVo enterpriseProjectDeclaration);

    int updateKyEnterpriseProjectDeclaration(KyEnterpriseProjectDeclaration enterpriseProjectDeclaration);
}
