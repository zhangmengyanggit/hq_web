package com.ruoyi.web.service.impl;

import com.ruoyi.web.domain.KyProjectDeclaration;
import com.ruoyi.web.mapper.KyProjectDeclarationMapper;
import com.ruoyi.web.service.IKyProjectDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目申报Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
@Service
public class KyProjectDeclarationServiceImpl implements IKyProjectDeclarationService
{
    @Autowired
    private KyProjectDeclarationMapper kyProjectDeclarationMapper;

    /**
     * 修改项目申请主表申请数
     *
     * @param projectDeclarationId
     * @return int
     */
    @Override
    public int updateDeclaredAmount(Long projectDeclarationId) {
        return kyProjectDeclarationMapper.updateDeclaredAmount(projectDeclarationId);
    }
}
