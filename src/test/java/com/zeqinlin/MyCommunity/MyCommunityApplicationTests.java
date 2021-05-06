package com.zeqinlin.MyCommunity;

import com.zeqinlin.MyCommunity.dao.AlphaDao;
import com.zeqinlin.MyCommunity.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =MyCommunityApplication.class)	//启用这个类作为配置类
class MyCommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	/**
	 * 三种主动获取bean的方法，是bean依赖注入的底层实现方式。
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Test
	public void testApplicationContext(){
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);	//实例化AlphaDao接口的实现类
		//默认的实例化都是单例模式。只实例化一次。
		System.out.println(alphaDao.select());
		AlphaDao hibernate = applicationContext.getBean("hibernate", AlphaDao.class);
		System.out.println(hibernate.select());
	}

	@Test
	public void testBeanManagement(){
		AlphaService alphaService = applicationContext.getBean(AlphaService.class);	//默认只实例化一次。
		System.out.println(alphaService);
	}
	@Test
	public void testConfig(){
		SimpleDateFormat simpleDateFormat =
				applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	/**
	 * 依赖注入的方法
	 */
	//如果要实例化Hibernate这个实现类
	//@Qualifier("hibernate")
	@Autowired
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Test
	public void testDependencyInjection(){
		System.out.println(alphaDao);
		System.out.println(alphaService);
		System.out.println(simpleDateFormat);

		/**
		 * com.zeqinlin.MyCommunity.dao.AlphaDaoMybatisImpl@b5ac0c1
		 * com.zeqinlin.MyCommunity.service.AlphaService@224c7de4
		 * java.text.SimpleDateFormat@4f76f1a0
		 * 可见都被实例化了
		 */
	}
}


