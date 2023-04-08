package com.ruoyi.web.controller.system;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUserEnterprise;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.OfficialSealUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.sign.Md5Utils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.system.service.ISysMenuService;
import com.ruoyi.web.domain.KyOriginalPolicy;
import com.ruoyi.web.service.IKyOriginalPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private IKyOriginalPolicyService kyOriginalPolicyService;
    @Autowired
    private ServerConfig serverConfig;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        SysUserEnterprise user = SecurityUtils.getLoginUser().getUser();

        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }

    /**
     * 根据加密的政策id查询文件返回前端
     *
     * @return 路由信息
     */
    @GetMapping("/originalpolicyView")
    public String getMd5Hash(String id, HttpServletResponse response) throws IOException {
        KyOriginalPolicy originalPolicyParams = new KyOriginalPolicy();
        originalPolicyParams.setMd5Hash(id);
        List<KyOriginalPolicy> originalPolicies = kyOriginalPolicyService.selectKyOriginalPolicyList(originalPolicyParams);
        if (originalPolicies.size() == 0) {
            throw new ServiceException("找不到当前政策文件");
        }
        String[] urlArr = originalPolicies.get(0).getMeansUrl().split(",");

        String urlNeed = null;
        for (String url : urlArr) {
            if (url.endsWith(".pdf")) {
                urlNeed = RuoYiConfig.getAdminProfile() + url;
                break;
            }
        }
        // 清空response
        // response.reset();
        // 设置编码
        //response.setCharacterEncoding("UTF-8");
        //response.setContentType("application/octet-stream");
        // response.addHeader("Content-Disposition", "inline;filename="+ URLEncoder.encode(urlPdf.substring(urlOfd.lastIndexOf("/"),urlOfd.length()), "UTF-8"));
        //try {
        //FileInputStream in = new FileInputStream(new File(urlPdf));
        //FileCopyUtils.copy(in, response.getOutputStream());
        //} catch (FileNotFoundException e) {
        //   throw new ServiceException("文件不存在") ;
        // } catch (IOException e) {
        // e.printStackTrace();
        //}

        return urlNeed;
    }

}
