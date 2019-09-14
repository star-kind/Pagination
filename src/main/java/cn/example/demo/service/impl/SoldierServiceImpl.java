package cn.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.example.demo.bean.Soldier;
import cn.example.demo.mapper.SoldierMapper;
import cn.example.demo.service.SoldierService;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gene
 * @since 2019-09-11
 */
@Service
public class SoldierServiceImpl extends ServiceImpl<SoldierMapper, Soldier> implements SoldierService {
	@Override
	public int insert(Soldier soldier) {
		return baseMapper.insert(soldier);
	}

	@Override
	public List<Soldier> selectAll(Wrapper<Soldier> queryWrapper) {
		return baseMapper.selectList(queryWrapper);
	}

	@Override
	public Soldier selectById(Integer soldierId) {
		return baseMapper.selectById(soldierId);
	}

	@Override
	public int updateOne(Soldier soldier) {
		return baseMapper.updateById(soldier);
	}

	@Override
	public int deleteOne(Soldier soldier) {
		return baseMapper.deleteById(soldier);
	}

	@Override
	public IPage getSoldierPage(Page page, Soldier Soldier) {
		return baseMapper.getSoldiersPage(page, Soldier);
	}

	public Soldier selectBaseOnId(Soldier soldier) {
		return baseMapper.selectById(soldier.getSoldierId());
	}

}
