package cn.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.example.demo.bean.Soldier;
import cn.example.demo.service.SoldierService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gene
 * @since 2019-09-11
 */
@Controller
@RequestMapping("/soldier")
public class SoldierController {
	@Autowired
	private SoldierService service;

	/**
	 * http://localhost:8080/boot-demo/soldier/soldierTableHandler?pageNum=0
	 * 
	 * <br>
	 * 0是第1页,1也是第1页
	 * 
	 * @param pageNum
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "soldierTableHandler", method = RequestMethod.GET)
	public PageInfo<Soldier> soldierTableHandler(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
		PageHelper.startPage(pageNum, 3);
		System.err.println("查询第 " + pageNum + " 页");

		QueryWrapper<Soldier> queryWrapper = new QueryWrapper<Soldier>();
		List<Soldier> list = service.selectAll(queryWrapper);

		PageInfo<Soldier> info = new PageInfo<Soldier>(list);

		return info;

	}

}
