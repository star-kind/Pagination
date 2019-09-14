package cn.example.demo.mapper;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.example.demo.bean.Soldier;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author gene
 * @since 2019-09-11
 */
public interface SoldierMapper extends BaseMapper<Soldier> {
	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param Soldier
	 * @return
	 */
	IPage<List<Soldier>> getSoldiersPage(Page page, @Param("query") Soldier Soldier);
}
