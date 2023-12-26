package cn.itbaizhan.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itbaizhan.po.Commodity;
import cn.itbaizhan.po.CommodityClass;
import cn.itbaizhan.service.CommodityClassService;
import cn.itbaizhan.service.CommodityService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



@SuppressWarnings("serial")
@Component("commodityAction")
@Scope("prototype")//多例，每个请求生成一个新的action
public class CommodityAction extends ActionSupport {
	private int commodityClassId;
	private Commodity commodity;
	
	private File image;					//上传图片文件
	private String imageContentType;		//上传图片文件类型
	private String imageFileName;			//上传图片文件名
	
	//要调用CommodityService的方法，所以要声明,让spring把其实现类注入
	@Resource(name="commodityServiceImpl")
	CommodityService service;
	
	private CommodityClass commodityclass;
	
	@Resource(name="commodityClassServiceImpl")
	CommodityClassService commodityClassService;
	
	public int getCommodityClassId() {
		return commodityClassId;
	}
	public void setCommodityClassId(int commodityClassId) {
		this.commodityClassId = commodityClassId;
	}
	public void setService(CommodityService service) {
		this.service = service;
	}
	public CommodityService getService() {
		return service;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodityClassService(CommodityClassService commodityClassService) {
		this.commodityClassService = commodityClassService;
	}
	public CommodityClassService getCommodityClassService() {
		return commodityClassService;
	}
	public void setCommodityclass(CommodityClass commodityclass) {
		this.commodityclass = commodityclass;
	}

	public CommodityClass getCommodityclass() {
		return commodityclass;
	}
	
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	//所有商品列表
	@SuppressWarnings("unchecked")
	public String listCommodity(){
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("listCommoditys", service.findAllCommoditys());
		System.out.println("listCommoditys");
		return "listCommodity";
	}
	//删除商品
	public String deleteCommodity(){
		System.out.println(commodity.getCommodityName());
		this.service.delete(commodity);
		return "deleteCommodity";
	}
	//按id查找商品	
	public String findCommodityById(){
		int commId= commodity.getCommodityId();
		System.out.println(commId);
		Commodity commodity = this.service.findCommodityById(commId);
		ActionContext.getContext().getSession().put("commodityById", commodity);
		
		return "findCommodityById";
	}
	//按名称查找商品
	@SuppressWarnings("unchecked")
	public String findCommodityByName(){
		String commodityName= commodity.getCommodityName();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("commoditybyName",this.service.findCommodityByName(commodityName));
		
		ActionContext.getContext().getSession().put("searchnameMessage", commodityName);	
			return "findCommodityByName";
		
	}
	//按分类查找商品
	@SuppressWarnings("unchecked")
	public String findCommodityByClass(){
		List<CommodityClass> commodityClasses;// 商品种类列表
		
		System.out.println("commodityClassId:"+commodityClassId);
		CommodityClass commodityclasses=commodityClassService.findCommodityClassById(commodityClassId);
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("commodityByClass", service.findCommodityByClass(commodityclasses));
		System.out.println("分类："+service.findCommodityByClass(commodityclasses));
		commodityClasses = commodityClassService.findAllCommodityClasses();// 查询所有的商品种类
		request.put("listCommodityClasses", commodityClasses);
		ActionContext.getContext().getSession().put("searchClassMessage", commodityclasses.getCommodityClassName());
			return "findCommodityByClass";
	}
	public String updateCommodity(){
		this.service.update(commodity);
		return "updateCommodity";
	}
	
	@SuppressWarnings("unchecked")
	public String adCommodity(){
	List<CommodityClass> commodityClasses;// 商品种类列表
	Map request = (Map) ActionContext.getContext().get("request");
	
	commodityClasses = commodityClassService.findAllCommodityClasses();// 查询所有的商品种类
	request.put("commodityClasses", commodityClasses);
	System.out.println(commodityClasses.size());
	return "addComm";
	}
	//添加商品
	@SuppressWarnings("unchecked")
	public String addCommodity(){
		List<CommodityClass> commodityClasses;// 商品种类列表
		Map request = (Map) ActionContext.getContext().get("request");	
		commodityClasses = commodityClassService.findAllCommodityClasses();// 查询所有的商品种类
		request.put("commodityClasses", commodityClasses);
		
		//图片处理
		try{
		String RealPath=ServletActionContext.getServletContext().getRealPath("/product");
		String fileName=imageFileName;
		File file=new File(RealPath,fileName);
		FileUtils.copyFile(image,file);
		
		}catch(Exception e){
			ActionContext.getContext().put("addComessage", "图片上传失败！");	
			return "addCommodityError";
		}
		
		commodity.setImage(imageFileName);
		
		CommodityClass com=commodityClassService.findCommodityClassById(commodity.getCommodityClass().getCommodityClassId());
		System.out.println(com);
		
		commodity.setCommodityClass(com);
		
		List<Commodity> commodityFindname=this.service.findCommodityBName (commodity.getCommodityName());//查询该商品是否存在
		if(commodityFindname.size()==0){		
		this.service.save(this.commodity);
		System.out.println("commodity:"+commodity.getCommodityName());
		ActionContext.getContext().put("addComessage", commodity.getCommodityName()+"添加成功");	
		}
		else {
			ActionContext.getContext().put("addComessage", commodity.getCommodityName()+"已经存在，请重新填写商品信息！");
		}
		
		return "addCommoditySuccess";
	}
	
}
