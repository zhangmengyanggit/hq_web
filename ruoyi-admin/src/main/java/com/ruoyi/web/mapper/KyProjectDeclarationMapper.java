package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.KyProjectDeclaration;

import java.util.List;

/**
 * 项目申报Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-15
 */
public interface KyProjectDeclarationMapper 
{
    /**
     * 修改项目申请主表申请数
     *
     * @param projectDeclarationId
     * @return int
     */
    int updateDeclaredAmount(Long projectDeclarationId);
}
