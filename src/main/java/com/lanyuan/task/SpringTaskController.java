package com.lanyuan.task;

import java.util.Properties;

import javax.inject.Inject;

import org.hyperic.sigar.Sigar;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lanyuan.entity.ServerInfoFormMap;
import com.lanyuan.mapper.ServerInfoMapper;
import com.lanyuan.util.Common;
import com.lanyuan.util.EmailUtils;
import com.lanyuan.util.PropertiesUtils;
import com.lanyuan.util.SystemInfo;


/**
 * Spring调度，指定时间执行
 * 利用了spring中使用注解的方式来进行任务调度。 
* @ClassName: SpringTaskController
* @Description: 
* @author zhy(505177876@qq.com)
* @date 2016年3月22日
*
 */
@Component
@Lazy(false)
public class SpringTaskController {
	@Inject
	private ServerInfoMapper serverInfoMapper;

	public static void main(String[] args) {
		SpringTaskController action = new SpringTaskController();
		try {
			action.task();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 与用户设置的使用率比较 spirng 调度
	 * 
	 * @throws Exception
	 * 
	 **  一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。
	 	*按顺序依次为
		*秒（0~59）
		*分钟（0~59）
		*小时（0~23）
		*天（月）（0~31，但是你需要考虑你月的天数）
		*月（0~11）
		*天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
		*7.年份（1970－2099）
		*“/”字符用来指定数值的增量
		*例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟
		     *    在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样
		*“？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值
		*当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”
		*/
	//5秒执行一次
	@Scheduled(cron = "0/5 * *  * * ? ")
	public void task() throws Exception {
		System.out.println("定时器输出----->");
	}
}