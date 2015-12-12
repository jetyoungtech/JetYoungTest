package com.jet.spring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法：直接调用某一个类的静态方法就可以返回bean的实例
 * @author Jet Young
 *
 */
public class StaticCarFactory {
	
	private static Map<String, Car> car = new HashMap<String, Car>();
	
	static{
		car.put("audi", new Car("audi", 300000));
		car.put("ford", new Car("ford", 200000));
	}

	//静态工厂方法
	public static Car getCar(String name){
		
		return car.get(name);
	}
}
