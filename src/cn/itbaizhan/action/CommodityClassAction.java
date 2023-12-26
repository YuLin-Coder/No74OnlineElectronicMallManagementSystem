package cn.itbaizhan.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itbaizhan.po.CommodityClass;
import cn.itbaizhan.service.CommodityClassService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



@SuppressWarnings("serial")
@Component("commodityClassAction")
@Scope("prototype")//多例，每个请求生成一个新的action
public class CommodityClassAction extends ActionSupport {
	private CommodityClass commodityClass;
	
	//要调用CommodityClassService的方法，所以要声明,让spring把其实现类注入
	@Resource(name="commodityClassServiceImpl")
	CommodityClassService service;
	public CommodityClassService getService() {
		return service;
	}

	public void setService(CommodityClassService service) {
		this.service = service;
	}

	public CommodityClass getCommodityClass() {
		return commodityClass;
	}

	public void setCommodityClass(CommodityClass commodityClass) {
		this.commodityClass = commodityClass;
	}
	
	@SuppressWarnings("unchecked")
	public String listCommodityClass(){
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("listCommodityClasses", service.findAllCommodityClasses());
		System.out.println("listCommodityClasses");
		return "listCommodityClass";
	}
	public String deleteCommodityClass(){
		System.out.println(commodityClass.getCommodityClassName());
		this.service.delete(commodityClass);
		return "deleteCommodityClass";
	}
	public String findCommodityClassById(){
		commodityClass = this.service.findCommodityClassById(commodityClass.getCommodityClassId());
		return "findCommodityClass";
	}
	public String updateCommodityClass(){
		this.service.update(commodityClass);
		return "updateCommodityClass";
	}
	public String inputCommodityClass(){
		return "input";
	}
	//添加商品种类
	@SuppressWarnings("unchecked")
	public String addCommodityClass(){
		//查询商品种类是否存在
		CommodityClass commclass=this.service.findCommodityClassBName(commodityClass.getCommodityClassName());
		System.out.println("commclass:"+commclass);
		if(commclass==null){
		this.service.save(this.commodityClass);
		System.out.println("commodityClass:"+commodityClass.getCommodityClassName());
		ActionContext.getContext().put("message", commodityClass.getCommodityClassName()+"添加成功");
		}
		else ActionContext.getContext().put("message", "该商品种类："+commodityClass.getCommodityClassName()+"已经存在，请重新输入信息！");
		return "addCommodityClass";
	}

	
	
}
