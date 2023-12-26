package cn.itbaizhan.service;

import java.util.List;

import cn.itbaizhan.po.CommodityClass;

public interface CommodityClassService {
//	和CommodityClassDao的方法一样，可以封装，因为这边只是调用
	public void save(CommodityClass commodityClass);
	public void delete(CommodityClass id);
	public CommodityClass findCommodityClassById(int id);
	public List<CommodityClass> findAllCommodityClasses();
	public void update(CommodityClass commodityClass);
	public CommodityClass findCommodityClassByName(String name);
	public CommodityClass findCommodityClassBName(String name);
	
}
