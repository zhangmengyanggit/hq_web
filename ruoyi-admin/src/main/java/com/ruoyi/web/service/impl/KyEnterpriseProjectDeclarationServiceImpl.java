package com.ruoyi.web.service.impl;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.web.domain.KyEnterpriseAppraise;
import com.ruoyi.web.domain.KyEnterpriseProjectDeclaration;
import com.ruoyi.web.mapper.KyEnterpriseProjectDeclarationMapper;
import com.ruoyi.web.service.IKyEnterpriseAppraiseService;
import com.ruoyi.web.service.IKyEnterpriseProjectDeclarationService;
import com.ruoyi.web.service.IKyProjectDeclarationService;
import com.ruoyi.web.vo.KyEnterpriseProjectDeclarationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 企业申请项目Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class KyEnterpriseProjectDeclarationServiceImpl implements IKyEnterpriseProjectDeclarationService {
    @Autowired
    private KyEnterpriseProjectDeclarationMapper kyEnterpriseProjectDeclarationMapper;
    @Autowired
    private IKyProjectDeclarationService projectDeclarationService;
    @Autowired
    private IKyEnterpriseAppraiseService enterpriseAppraiseService;
    @Autowired
    private ServerConfig serverConfig;
    /**
     * 查询企业申请项目
     *
     * @param id 企业申请项目主键
     * @return 企业申请项目
     */
    @Override
    public KyEnterpriseProjectDeclarationVo selectKyEnterpriseProjectDeclarationById(Long id) {
        KyEnterpriseProjectDeclarationVo enterpriseProjectDeclarationVo= kyEnterpriseProjectDeclarationMapper.selectKyEnterpriseProjectDeclarationById(id);
        if(StringUtils.isNotEmpty(enterpriseProjectDeclarationVo.getMeansUrl())){
            String[] urlArr = enterpriseProjectDeclarationVo.getMeansUrl().split(",");
            StringBuffer sb=new StringBuffer();
            for (String url : urlArr) {
                String   urlNeed = RuoYiConfig.getAdminProfile() + url;
                if(sb.length()==0){
                    sb.append(urlNeed);
                }else{
                    sb.append(",").append(urlNeed);
                }
            }
            if(sb.length()>0){
                enterpriseProjectDeclarationVo.setMeansUrl(sb.toString());
            }
        }
        //处理身份证和营业执照文件保存路径
        if(StringUtils.isNotEmpty(enterpriseProjectDeclarationVo.getIdentityCardUrl())){
            if(RuoYiConfig.isDemoEnabled()){
                enterpriseProjectDeclarationVo.setIdentityCardUrl(serverConfig.getUrl()+"/prod-api" +enterpriseProjectDeclarationVo.getIdentityCardUrl());
            }else{
                enterpriseProjectDeclarationVo.setIdentityCardUrl(serverConfig.getUrl() +enterpriseProjectDeclarationVo.getIdentityCardUrl());
            }
        }
        if(StringUtils.isNotEmpty(enterpriseProjectDeclarationVo.getBusinessLicenseUrl())){
            if(RuoYiConfig.isDemoEnabled()){
                enterpriseProjectDeclarationVo.setBusinessLicenseUrl(serverConfig.getUrl() +"/prod-api"+enterpriseProjectDeclarationVo.getBusinessLicenseUrl());
            }else{
                enterpriseProjectDeclarationVo.setBusinessLicenseUrl(serverConfig.getUrl() +enterpriseProjectDeclarationVo.getBusinessLicenseUrl());
            }
        }
        return enterpriseProjectDeclarationVo;
    }

    /**
     * 查询企业申请项目列表
     *
     * @param kyEnterpriseProjectDeclaration 企业申请项目
     * @return 企业申请项目
     */
    @Override
    public List<KyEnterpriseProjectDeclarationVo> selectKyEnterpriseProjectDeclarationList(KyEnterpriseProjectDeclarationVo kyEnterpriseProjectDeclaration) {
        return kyEnterpriseProjectDeclarationMapper.selectKyEnterpriseProjectDeclarationList(kyEnterpriseProjectDeclaration);
    }


    @Override
    public Long selectKyEnterpriseProjectDeclarationCountByParams(Map<String, Object> paramsMap) {
        return kyEnterpriseProjectDeclarationMapper.selectKyEnterpriseProjectDeclarationCountByParams(paramsMap);
    }

    /**
     * 申请项目
     *
     * @param enterpriseProjectDeclarationVo 企业申请项目属性
     * @return int
     */
    @Override
    @Transactional
    public int applyForKyEnterpriseProjectDeclaration(KyEnterpriseProjectDeclarationVo enterpriseProjectDeclarationVo) {
        int returnInt = 0;
        //更新企业申请项目表
        KyEnterpriseProjectDeclaration enterpriseProjectDeclaration=new KyEnterpriseProjectDeclaration();
        enterpriseProjectDeclaration.setAuditStatus(1l);
        enterpriseProjectDeclaration.setId(enterpriseProjectDeclarationVo.getId());
        enterpriseProjectDeclaration.setDeclaredFileUrl(enterpriseProjectDeclarationVo.getDeclaredFileUrl());
        enterpriseProjectDeclaration.setIdentityCardUrl(enterpriseProjectDeclarationVo.getIdentityCardUrl());
        enterpriseProjectDeclaration.setBusinessLicenseUrl(enterpriseProjectDeclarationVo.getBusinessLicenseUrl());
        returnInt = kyEnterpriseProjectDeclarationMapper.updateKyEnterpriseProjectDeclaration(enterpriseProjectDeclaration);
        if (returnInt == 0) {
            return returnInt;
        }
        /**
         * 插入评价数据（评价环节既审核状态）
         * */

        KyEnterpriseAppraise kyEnterpriseAppraise=new KyEnterpriseAppraise();
        kyEnterpriseAppraise.setEnterpriseId(enterpriseProjectDeclarationVo.getEnterpriseId());
        kyEnterpriseAppraise.setIrrigationDitch("pc端");
        kyEnterpriseAppraise.setSysUserEnterpriseId(SecurityUtils.getUserId());
        kyEnterpriseAppraise.setEnterpriseProjectDeclarationId(enterpriseProjectDeclarationVo.getId());
        kyEnterpriseAppraise.setReplyDepartment(enterpriseProjectDeclarationVo.getPublishingDepartment());
        kyEnterpriseAppraise.setAuditStatus(1l);
        enterpriseAppraiseService.insertKyEnterpriseAppraise(kyEnterpriseAppraise);
        //更新申请企业数
        returnInt = projectDeclarationService.updateDeclaredAmount(enterpriseProjectDeclarationVo.getProjectDeclarationId());
        return returnInt;
    }

    @Override
    public int updateKyEnterpriseProjectDeclaration(KyEnterpriseProjectDeclaration enterpriseProjectDeclaration) {
        return kyEnterpriseProjectDeclarationMapper.updateKyEnterpriseProjectDeclaration(enterpriseProjectDeclaration);
    }
}
