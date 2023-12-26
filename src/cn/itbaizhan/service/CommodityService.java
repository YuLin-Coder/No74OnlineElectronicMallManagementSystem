package cn.itbaizhan.service;

import java.util.List;

import cn.itbaizhan.po.Commodity;
import cn.itbaizhan.po.CommodityClass;

public interface CommodityService {
//	和CommodityDao的方法一样，可以封装，因为这边只是调用
	public void save(Commodity commodity);
	public void delete(Commodity id);
	public Commodity findCommodityById(int id);
	public List<Commodity> findAllCommoditys();
	public void update(Commodity commodity); 
	public List<Commodity> findCommodityByName(String Name);
	public List<Commodity> findCommodityByClass(CommodityClass commodityclass);
	public List<Commodity> findCommodityBName(String commodityName);
}
