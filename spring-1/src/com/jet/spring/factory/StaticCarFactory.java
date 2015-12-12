package com.jet.spring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬����������ֱ�ӵ���ĳһ����ľ�̬�����Ϳ��Է���bean��ʵ��
 * @author Jet Young
 *
 */
public class StaticCarFactory {
	
	private static Map<String, Car> car = new HashMap<String, Car>();
	
	static{
		car.put("audi", new Car("audi", 300000));
		car.put("ford", new Car("ford", 200000));
	}

	//��̬��������
	public static Car getCar(String name){
		
		return car.get(name);
	}
}
