package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.service.ISysDictDataService;
import com.ruoyi.web.domain.KyEnterprise;
import com.ruoyi.web.domain.SysArea;
import com.ruoyi.web.domain.Tag;
import com.ruoyi.web.mapper.KyEnterpriseMapper;
import com.ruoyi.web.service.IKyEnterpriseProjectDeclarationService;
import com.ruoyi.web.service.IKyEnterpriseService;
import com.ruoyi.web.service.ISysAreaService;
import com.ruoyi.web.service.ITagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 企业Service业务层处理
 *
 * @author ruoyi
 * @date 2023-03-08
 */
@Service
public class KyEnterpriseServiceImpl implements IKyEnterpriseService {
    private static final Logger log = LoggerFactory.getLogger(KyEnterpriseServiceImpl.class);
    @Autowired
    private KyEnterpriseMapper kyEnterpriseMapper;
    @Autowired
    protected Validator validator;




    /**
     * 修改企业
     *
     * @param kyEnterprise 企业
     * @return 结果
     */
    @Override
    public int updateKyEnterprise(KyEnterprise kyEnterprise) {
        return kyEnterpriseMapper.updateKyEnterprise(kyEnterprise);
    }

    @Override
    public KyEnterprise selectKyEnterpriseById(Long id) {
        return kyEnterpriseMapper.selectKyEnterpriseById(id);
    }



    @Override
    public Long selectKyEnterpriseCount(KyEnterprise kyEnterprise) {
        return kyEnterpriseMapper.selectKyEnterpriseCount(kyEnterprise);
    }

    
}
