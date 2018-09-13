package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;
/**
 * 品牌管理
 * @author Youla
 *
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
		@Reference
		private BrandService brandService;
		/**
		 * 查询所有  未分页
		 * @return
		 */
		@RequestMapping("/findAll")
		public List<TbBrand> findAll(){
			return brandService.findAll();
		}
		/**
		 * 分页查询
		 * @param page
		 * @param size
		 * @return
		 */
		@RequestMapping("/findByPage")
		public PageResult findByPage(int page,int size) {
			 return  brandService.findByPage(page, size);
		}
		/**
		 * 新增品牌
		 * @param tbBrand
		 * @return
		 */
		@RequestMapping("/add")
		public Result add(@RequestBody TbBrand tbBrand) {
			return brandService.add(tbBrand);
		}
		/**
		 * 根据ID查询后  返回前台显示
		 * @param id
		 * @return
		 */
		@RequestMapping("/findById")
		public TbBrand findById(long id) {
			return brandService.findById(id);
		}
		/**
		 * 跟新数据
		 * @param tbBrand
		 * @return
		 */
		@RequestMapping("/update")
		public Result update(@RequestBody TbBrand tbBrand) {
				return brandService.update(tbBrand);
		}
		/**
		 * 删除选中
		 * @param ids
		 * @return
		 */
		@RequestMapping("/deleteSelect")
		public Result deleteSelect(long[] ids) {
			return brandService.deleteSelect(ids);
		}
		/**
		 * 条件查询
		 * @param tbBrand
		 * @param page
		 * @param size
		 * @return
		 */
		@RequestMapping("/selectByExample")
		public PageResult selectByExample(@RequestBody TbBrand tbBrand,int page, int size) {
			return brandService.searchByExample(tbBrand, page, size);
		}
		
}
