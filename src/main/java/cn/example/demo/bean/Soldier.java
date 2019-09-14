package cn.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gene
 * @since 2019-09-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Soldier implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 士兵编号
	 */
	@TableId(value = "soldier_id", type = IdType.AUTO)
	private Integer soldierId;

	/**
	 * 士兵名字
	 */
	private String soldierName;

	/**
	 * 参军时间
	 */
	private LocalDateTime joinArmyTime;

	/**
	 * id/name/time's constructor
	 * 
	 * @param soldierId
	 * @param soldierName
	 * @param joinArmyTime
	 */
	public Soldier(Integer soldierId, String soldierName, LocalDateTime joinArmyTime) {
		this.soldierId = soldierId;
		this.soldierName = soldierName;
		this.joinArmyTime = joinArmyTime;
	}

	/**
	 * int's constructor
	 * 
	 * @param i
	 */
	public Soldier(int i) {
	}

	public Soldier(String string, LocalDateTime now) {
		System.err.println(string + " +++ " + now);
		this.soldierName = string;
		this.joinArmyTime = now;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Soldier [soldierId=");
		builder.append(soldierId);
		builder.append(", soldierName=");
		builder.append(soldierName);
		builder.append(", joinArmyTime=");
		builder.append(joinArmyTime);
		builder.append("]");
		return builder.toString();
	}

}
