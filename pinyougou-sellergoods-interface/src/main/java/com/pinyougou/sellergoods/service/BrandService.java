package com.pinyougou.sellergoods.service;
import java.util.List;

import com.pinyougou.pojo.TbBrand;
/**
 * 品牌接口
 * @author Youla
 *
 */

import entity.PageResult;
import entity.Result;
public interface BrandService {

		public List<TbBrand> findAll();
		
		public PageResult findByPage(int page,int size);
		
		public Result add(TbBrand tbBrand);
		
		public TbBrand findById(long id);
		
		public Result update(TbBrand tbBrand);
		
		public Result deleteSelect(long[] ids);
		
		public PageResult   searchByExample(TbBrand rBrand,int page,int size);
}
