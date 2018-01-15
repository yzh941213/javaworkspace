/*package com.aishidai.app.interceptor;

import com.zhezhuo.biz.manager.CacheManager;
import com.zhezhuo.model.entity.SysUsersDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

*//**
 * 
 * @author 51147
 *
 *//*

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	CacheManager cacheManager;

	// 配置不拦截的请求
	private static final String[] IGNORE_URI = { "/edit",
			"/manager/device/hQdeviceListLike.do", "/audit.do",
			"DeviceListLike.do", "/subsite/querySubsiteList.do",
			"/subsite/editSubsite.do", "/upload.do", "/login.html", "/own.do",
			"/login.do", "/out.do", "/admin/resource.do", "/detail.do",
			"/query.do", "/list.do", "/query", "/unemployed.do", "/invest.do",
			"/investDrop.do", "/property/child.do", "/attribute/child.do",
			"/distributor/all.do", "/maker/all.do", "/shop/all.do",
			"/bankCard/all.do", "/tcash/balance.do", "/itemStatus.do",
			"/cropupload.do", "/device/listByshop.do", "/shop/usrByshop.do",
			"/craftsmen/shopName.do", "/shopList.do", "/otherShopList.do",
			"/queryByNameshopLike.do", "/edit.do", "/status.do", "/audit.do",
			"/del.do", "/delItemDO.do", "/itemStatus.do", "/itemsModel.do",
			"/queryByNameshopLike.do", "/editStatus.do", "/listDel.do",
			"/save.do", "/deviceList.do", "/send.do", "/cancel.do",
			"/commission/listShopC.do", "/listOtherShopC.do",
			"/otherShopCommissionDetail.do", "/shopCommissionDetail.do",
			"/addOtherShopCommission.do", "/editOtherShopcommission.do",
			"/addShopCommission.do", "/editShopcommission.do",
			"/queryByNameOtherShopLike.do", "/queryByNameshopLike.do",
			"/queryByNameshopLike.do", "/queryByDistributorNameLike.do",
			"/queryMakerByNameLike.do", "/listHqC.do",
			"/hqCommissionDetail.do", "/addHqCommission.do",
			"/delHqCommission.do", "/delMakerCommission.do",
			"/delShopCommission.do", "/delOtherShopCommission.do",
			"/listHqOtherShopC.do", "/listHqShopC.do",
			"queryDistributorByNameLikeAndSysUserId", "/manager/admin/add.do",
			"/manager/sysusers/role/add.do", "/manager/role/add.do",
			"/manager/role/resource/add.do", "/manager/role/resource/edit.do",
			"/resource/query.do", "/manager/role/update.do",
			"/manager/role/del.do", "/statemen//hq/showStatemen.do",
			"/statemen/db/showStatemen.do",
			"/statemen/hq/showStatemenDetail.do",
			"/statemen/maker/showStatemen.do",
			"/statemen/maker/showStatemenDetail.do",
			"/statemen/db/showStatemenDetail.do",
			"/statemen/shop/showStatemenDetail.do",
			"/statemen/shop/showStatemen.do",
			"/statemen/otherShop/showStatemen.do",
			"/statemen/otherShop/showStatemenDetail.do" };

	private static final String USER_SESSION_KEY = "user_session_key";

	*//**
	 * 拦截请求验证用户是否登录
	 *//*
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		boolean flag = false;
		// 得到访问的路径
		String reqUrl = request.getRequestURI().toString();

		// 如果访问的路径，属于上面的数组中的数据，则自动放行
		for (String url : IGNORE_URI) {
			if (reqUrl.contains(url)) {
				flag = true;
				break;
			}
		}

		if (!flag) {

			SysUsersDO userDO = (SysUsersDO) request.getSession().getAttribute(
					USER_SESSION_KEY);
			if (userDO == null) {
				response.sendRedirect("/manage-server/YXJManage/login.html");
			} else {
				if (reqUrl.indexOf(".do") > 0) {
					try {
						List<String> resources = (List<String>) cacheManager
								.get("adminId" + userDO.getUserId());
						if (null == resources || resources.isEmpty()) {
							response.sendRedirect("/manage-server/power/failed.do");
						} else {
							if (resources.contains(reqUrl.split("manager")[1])) {
								flag = true;
							} else {
								// 重定向到controller
								response.sendRedirect("/manage-server/power/failed.do");
							}
						}
					} catch (IOException e) {
						response.sendRedirect("/manage-server/YXJManage/login.html");
					}
				} else {
					flag = true;
				}
			}
		}
		return flag;
	}

	*//**
	 * This implementation is empty.
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 *//*
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
*/