package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

import com.pinyougou.mapper.TbBrandMapper;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper tbBrandMpper;
	@Override
	public List<TbBrand> findAll() {
	
		return  tbBrandMpper.selectByExample(null);
	}
	
	@Override
	public PageResult findByPage(int page, int size) {
		PageHelper.startPage(page, size);
		Page selectByExample = (Page) tbBrandMpper.selectByExample(null);
		 return new PageResult(selectByExample.getTotal(),selectByExample.getResult());
	}
	
	@Override
	public Result add(TbBrand tbBrand) {
			Result result = new Result();
			int i = tbBrandMpper.insert(tbBrand);
			if (i>0) {
				result.setSuccess(true);
				result.setMessage("添加成功");
			}else {
				result.setSuccess(false);
				result.setMessage("添加失败");
			}
		return result;
	}
	
	@Override
	public TbBrand findById(long id) {
		TbBrand brand = tbBrandMpper.selectByPrimaryKey(id);
		
		return brand;
	}
	@Override
	public Result update(TbBrand tbBrand) {
		Result result = new Result();
		 int i= tbBrandMpper.updateByPrimaryKey(tbBrand);
		if (i>0) {
			result.setSuccess(true);
			result.setMessage("添加成功");
		}else {
			result.setSuccess(false);
			result.setMessage("添加失败");
		}
	return result;
	}
	@Override
	public Result deleteSelect(long[] ids) {
		Result result = new Result();
		int i = 0;
		for(long id:ids) {
			i = tbBrandMpper.deleteByPrimaryKey(id);
		}
		if (i>0) {
			result.setSuccess(true);
			result.setMessage("添加成功");
		}else {
			result.setSuccess(false);
			result.setMessage("添加失败");
		}
	return result;
	}

	@Override
	public PageResult searchByExample(TbBrand rBrand, int page, int size) {
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if (rBrand!=null) {
			if (rBrand.getName()!=null&&rBrand.getName().length()!=0) {
				criteria.andNameLike("%"+rBrand.getName()+"%");
			}
			if (rBrand.getFirstChar()!=null&&rBrand.getFirstChar().length()!=0) {
				criteria.andFirstCharLike("%"+rBrand.getFirstChar()+"%");
			}
		}
		PageHelper.startPage(page,size);
		Page  selectByExample = (Page) tbBrandMpper.selectByExample(example);
		return new PageResult(selectByExample.getTotal(),selectByExample.getResult());
	}
	/**
	 * 查询品牌的List《Map》 响应给前台
	 */
	@RequestMapping("/brandList")
	public List<Map> brandList(){
		return tbBrandMpper.brandList();
	};
}
