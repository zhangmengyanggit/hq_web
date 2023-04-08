package com.ruoyi.web.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysUserEnterprise;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.web.domain.KyEnterprise;
import com.ruoyi.web.mapper.SysUserEnterpriseMapper;
import com.ruoyi.web.service.ISysUserEnterpriseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;
import java.util.List;

/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserEnterpriseServiceImpl implements ISysUserEnterpriseService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserEnterpriseServiceImpl.class);

    @Autowired
    private SysUserEnterpriseMapper userMapper;




    @Autowired
    protected Validator validator;


    @Override
    public void updateSysUserEnterpriseByEnterprise(KyEnterprise enterpriseOrld, KyEnterprise kyEnterprise) {
        if(enterpriseOrld==null||kyEnterprise.getLinkmanPhone().equals(enterpriseOrld.getLinkmanPhone())){
            return;
        }
        SysUserEnterprise sysUserEnterprise=new SysUserEnterprise();
        sysUserEnterprise.setNickName(kyEnterprise.getLinkman());
        sysUserEnterprise.setPhonenumber(kyEnterprise.getLinkmanPhone());
        sysUserEnterprise.setUserName(kyEnterprise.getLinkmanPhone());
        sysUserEnterprise.setEnterpriseId(enterpriseOrld.getId());
        userMapper.updateSysUserEnterpriseByParams(sysUserEnterprise);
    }
}
