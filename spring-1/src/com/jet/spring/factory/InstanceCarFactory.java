package com.jet.spring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ʵ������������ʵ�������ķ�����������Ҫ�������������ٵ��ù�����ʵ������������bean��ʵ��
 * @author Jet Young
 *
 */

public class InstanceCarFactory {
	
	private Map<String, Car> cars = null;
	
	public InstanceCarFactory(){
		cars = new HashMap<String, Car>();
		cars.put("audi", new Car("audi", 300000));
		cars.put("ford", new Car("ford", 200000));
	}
	
	public Car getCar(String brand){
		return cars.get(brand);
	}

}
