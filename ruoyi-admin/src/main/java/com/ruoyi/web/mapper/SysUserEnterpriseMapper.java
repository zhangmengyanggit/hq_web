package com.ruoyi.web.mapper;

import com.ruoyi.common.core.domain.entity.SysUserEnterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
public interface SysUserEnterpriseMapper
{

    public void updateSysUserEnterpriseByParams(SysUserEnterprise sysUserEnterprise);
}
