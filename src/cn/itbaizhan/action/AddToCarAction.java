package cn.itbaizhan.action;

import java.util.ArrayList;
import java.util.Iterator;
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
@Component("addToCarAction")
@Scope("prototype")//多例，每个请求生成一个新的action
public class AddToCarAction extends ActionSupport {
	private CommodityService commodityService;// 业务逻辑层
	private Commodity commodity;

	private Integer comamount;
	private double totalPrice=0;
	
	public CommodityService getCommodityService() {
		return commodityService;
	}
	@Resource
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Commodity getCommodity() {
		return commodity;
	}
	
	public void setComamount(Integer comamount) {
		this.comamount = comamount;
	}

	public Integer getComamount() {
		return comamount;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		
				
		int commodityId= commodity.getCommodityId();
		System.out.println("商品id："+commodityId);
		Map session =(Map) ActionContext.getContext().getSession(); 
		
		Commodity commoditys = commodityService.findCommodityById(commodityId);//获得商品信息
		if(commoditys.getCommodityLeaveNum()==0){
			ActionContext.getContext().getSession().put("comnull","商品已无货！");
			return "error";
		}
		else{
		System.out.println("test1");
						
		List<Commodity> car = null;	//声明一个购物车
		
		System.out.println("test2");
		if(session.get("car") == null) {	//如果session中不存在购物车
			System.out.println("test3");
				car = new ArrayList<Commodity>();	//新建一个ArrayList实例
				
				car.add(commoditys);//将商品添加到购物车中
				commoditys.setCommodityLeaveNum(commoditys.getCommodityLeaveNum()-1);
				commodityService.update(commoditys);
				System.out.println("car1:"+car.size());
		}
		else {
			System.out.println("test4");
			car = (List<Commodity>)session.get("car"); //取得购物车
			
			System.out.println("test4.5");
				
				if(car.size()==0){  //如果购物车为空
					System.out.println("test4.6");	
					car.add(commoditys);//将商品添加到购物车中
					commoditys.setCommodityLeaveNum(commoditys.getCommodityLeaveNum()-1);
					commodityService.update(commoditys);
					System.out.println("car2:"+car.size());
					
				}
				else{
					for(int i = car.size();i>0;i--){
						System.out.println("test4.7");
						
						Commodity com = car.get(i-1); //获取商品
						System.out.println("test4.8");
						if(com.getCommodityId() == commodityId) { //商品已经存在
							System.out.println("test5");
							System.out.println("car2:"+car.size());
						}
						else{		//商品不存在
							System.out.println("test5.1");	
							car.add(commoditys);//将商品添加到购物车中
							commoditys.setCommodityLeaveNum(commoditys.getCommodityLeaveNum()-1);
							commodityService.update(commoditys);
							System.out.println("car3:"+car.size());
						}
					}
				}
		}
		Iterator<Commodity>  it = car.iterator();
		for(int i = car.size();it.hasNext();i--){
			Commodity com = it.next();
				 totalPrice+=com.getCommodityPrice();      
		}
		
		System.out.println("test7");
		session.put("car", car);//将购物车保存在session中
		System.out.println("car:"+car.size());
		session.put("totalPrice", totalPrice);//将总价保存在session中
		System.out.println(totalPrice);
		return "success";
		}
	}
	
	@SuppressWarnings("unchecked")
	public String deleteFromCar(){
		
		int commodityId= commodity.getCommodityId();
		System.out.println("商品id："+commodityId);
		
		Commodity commoditys = commodityService.findCommodityById(commodityId);
		commoditys.setCommodityLeaveNum(commoditys.getCommodityLeaveNum()+1);
		commodityService.update(commoditys);
		
		Map session = ActionContext.getContext().getSession();//获得session对象
		List<Commodity> car = (List<Commodity>)session.get("car");//取得购物车
		Iterator<Commodity>  it = car.iterator();
		for(int i = car.size();it.hasNext();i--){
			Commodity com = it.next();
			if(com.getCommodityId() == commodityId) {
				 int index = car.indexOf(com); 
				 it.remove();        //这行代码是关键。删除该商品
			}
		}
		Iterator<Commodity>  is = car.iterator();
		for(int i = car.size();is.hasNext();i--){
			Commodity com = is.next();
				 totalPrice+=com.getCommodityPrice();      
		}
		session.put("car",car);//将重新购物车保存到session中
		System.out.println("car:"+car.size());
		return "delete";
	}
	
}
