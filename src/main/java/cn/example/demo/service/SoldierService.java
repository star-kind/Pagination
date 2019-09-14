package cn.example.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.example.demo.bean.Soldier;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gene
 * @since 2019-09-11
 */
public interface SoldierService extends IService<Soldier> {
	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param Soldier
	 * @return
	 */
	IPage getSoldierPage(Page page, Soldier Soldier);

	/**
	 * 增加
	 * 
	 * @param soldier
	 * @return
	 */
	int insert(Soldier soldier);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<Soldier> selectAll(Wrapper<Soldier> queryWrapper);

	/**
	 * 据ID而查
	 * 
	 * @param soldier
	 * @return
	 */
	Soldier selectById(Integer soldierId);

	/**
	 * 更改1行
	 * 
	 * @param soldier
	 * @return
	 */
	int updateOne(Soldier soldier);

	/**
	 * 删除一行
	 * 
	 * @param soldier
	 * @return
	 */
	int deleteOne(Soldier soldier);
}
