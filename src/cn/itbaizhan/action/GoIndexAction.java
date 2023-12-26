package cn.itbaizhan.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itbaizhan.po.Commodity;
import cn.itbaizhan.po.CommodityClass;
import cn.itbaizhan.service.CommodityClassService;
import cn.itbaizhan.service.CommodityService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("goIndexAction")
@Scope("prototype")//多例，每个请求生成一个新的action
public class GoIndexAction extends ActionSupport {
	private CommodityClassService commodityClassService;
	private List<CommodityClass> commodityClasses;// 商品种类列表


	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}

	@Resource
	public void setCommodityClassService(
			CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}

	public List<CommodityClass> getCommodityClasses() {
		return commodityClasses;
	}


	public void setCommodityClasses(List<CommodityClass> commodityClasses) {
		this.commodityClasses = commodityClasses;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");

		commodityClasses = commodityClassService.findAllCommodityClasses();// 查询所有的商品种类
		request.put("listCommodityClasses", commodityClasses);
		
		System.out.println(commodityClasses);
				
		return "success";
	}
}
