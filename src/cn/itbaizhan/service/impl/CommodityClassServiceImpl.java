package cn.itbaizhan.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.itbaizhan.dao.CommodityClassDao;
import cn.itbaizhan.po.CommodityClass;
import cn.itbaizhan.service.CommodityClassService;

//把类交给spring管理(如同配置bean节点)此类受spring事务管理
@Component("commodityClassServiceImpl")
public class CommodityClassServiceImpl implements CommodityClassService {

		//要调用dao层代码,所以要有UserDao的对象，把其实现类靠spring注入
		@Resource(name="commodityClassDaoImpl")
		private CommodityClassDao commodityClassDao;
		public CommodityClassDao getUserDao() {
			return commodityClassDao;
		}

		public void setUserDao(CommodityClassDao commodityClassDao) {
			this.commodityClassDao = commodityClassDao;
		}

		public void delete(CommodityClass commodityClass) {
			this.commodityClassDao.delete(commodityClass);

		}
		public List<CommodityClass> findAllCommodityClasses() {
			return this.commodityClassDao.findAllCommodityClasses();
		}
		public CommodityClass findCommodityClassById(int id) {
			
			return this.commodityClassDao.findCommodityClassById(id);
		}

		public void save(CommodityClass commodityClass) {
			this.commodityClassDao.save(commodityClass);

		}

		public void update(CommodityClass commodityClass) {
			this.commodityClassDao.update(commodityClass);
		}

		public CommodityClass findCommodityClassByName(String name) {
			return this.commodityClassDao.findCommodityClassByName(name);
		}
		public CommodityClass findCommodityClassBName(String name) {
			return this.commodityClassDao.findCommodityClassBName(name);
		}
	}

