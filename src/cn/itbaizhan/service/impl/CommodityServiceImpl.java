package cn.itbaizhan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.itbaizhan.dao.CommodityDao;
import cn.itbaizhan.po.Commodity;
import cn.itbaizhan.po.CommodityClass;
import cn.itbaizhan.service.CommodityService;

//把类交给spring管理(如同配置bean节点)此类受spring事务管理
@Component("commodityServiceImpl")
public class CommodityServiceImpl implements CommodityService {
	//要调用dao层代码,所以要有CommodityDao的对象，把其实现类靠spring注入
	@Resource(name="commodityDaoImpl")
	private CommodityDao commodityDao;
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	public void delete(Commodity commodity) {
		this.commodityDao.delete(commodity);

	}
	public List<Commodity> findAllCommoditys() {
		return this.commodityDao.findAllCommoditys();
	}
	public Commodity findCommodityById(int id) {
		
		return this.commodityDao.findCommodityById(id);
	}

	public void save(Commodity commodity) {
		this.commodityDao.save(commodity);

	}

	public void update(Commodity commodity) {
		this.commodityDao.update(commodity);
	}
	
	public List<Commodity> findCommodityByName(String Name) {
		return this.commodityDao.findCommodityByName(Name);
	}

	public List<Commodity> findCommodityByClass(CommodityClass commodityclass) {
		
		return this.commodityDao.findCommodityByClass(commodityclass);
	}
	public List<Commodity> findCommodityBName(String Name) {
		return this.commodityDao.findCommodityBName(Name);
	}
}
