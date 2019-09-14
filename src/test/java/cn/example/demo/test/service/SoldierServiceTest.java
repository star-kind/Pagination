package cn.example.demo.test.service;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.example.demo.bean.Soldier;
import cn.example.demo.service.SoldierService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SoldierServiceTest {
	@Autowired
	private SoldierService ss;

	@Test
	public void insertTest() {
		LocalDateTime now = LocalDateTime.now();

		Soldier soldier = new Soldier("yaoyaole", now);

		int affect = ss.insert(soldier);

		System.err.println("affect- " + affect);
	}

	@Test
	public void selectAllTest() {
		// QueryWrapper<T> extends AbstractWrapper<*> extends Wrapper<T>
		QueryWrapper<Soldier> queryWrapper = new QueryWrapper<Soldier>();

		List<Soldier> list = ss.selectAll(queryWrapper);

		for (Soldier soldier : list) {
			System.err.println(soldier.toString());
		}

	}

	@Test
	public void selectOneTest() {
		Soldier soldier = ss.selectById(1);
		System.err.println(soldier.toString());
	}

	@Test
	public void updateTest() {
		Soldier soldier = new Soldier(1, "mybatis-plus", LocalDateTime.now());

		int effect = ss.updateOne(soldier);

		System.err.println("effect- " + effect);
	}

	@Test
	public void deleteTest() {
		Soldier soldier = new Soldier(1, "mybatis-plus", LocalDateTime.now());

		int effect = ss.deleteOne(soldier);

		System.err.println("effect- " + effect);
	}

	@Test
	public void pageTest() {
		PageHelper.startPage(1, 3);

		QueryWrapper<Soldier> queryWrapper = new QueryWrapper<Soldier>();
		List<Soldier> list = ss.selectAll(queryWrapper);

		PageInfo<Soldier> pageInfo = new PageInfo<Soldier>(list);

		for (Soldier soldier : pageInfo.getList()) {
			System.err.println(soldier.toString());
		}

		System.out.println(pageInfo.toString());
	}

}