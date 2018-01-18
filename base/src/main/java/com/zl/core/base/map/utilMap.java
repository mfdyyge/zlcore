package com.zl.core.base.map;

import com.zl.core.base.string.utilString;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;


public class utilMap extends com.xiaoleilu.hutool.util.MapUtil {



	// 判断Map是否非空 <Map!=null>
	public static boolean isNotNull(Map<?, ?> map) {
		return MapUtils.isNotEmpty(map);
	}

	// 判断Map是否为空  <Map==null>
	public static boolean isNull(Map<?, ?> map) {
		return MapUtils.isEmpty(map);
	}



	//******************************************************************************************************************
	//******************************************************************************************************************
	//******************************************************************************************************************

	/**
	 *  获取:Map 中的 Key[Array]=> Object params[] = { "钢背猪☣", "123", "gacl@sina.com", new Date() };
	 * @param   map
	 * @return  Object[] 数组
	 */
	public static Object[] getKey(Map<String, Object> map)
	{
		//map.keySet().toArray();
		//map.values().toArray();
		//utilMap.isNull(mapTable);

		utilMap.removeNull(map);
				Set<String> keySet = map.keySet();//Keys
				Object[] key_array=keySet.toArray();

		return key_array;
	}

	/**
	 * 获取:Map 中的 KeyValues[Array]=> Object params[] = { "钢背猪☣", "123", "gacl@sina.com", new Date() };
	 * @param   map
	 * @return  Object[] 数组
	 */
	public static Object[] getValues(Map<String, String> map)
	{
		//map.values().toArray();
		//Set<String> set = map.keySet();//Keys

		utilMap.removeNull(map);
				Collection<String> values_collection=map.values();//values
				Object[] values_array=values_collection.toArray();


		return values_array;
	}


	//******************************************************************************************************************
	//******************************************************************************************************************
	//******************************************************************************************************************

	//******************************************************************************************************************
	//******************************************************************************************************************
	//******************************************************************************************************************


	/**
	 * 移除map中空key或者value空值
	 * @param map
	 */
	public static void removeNull(Map map){
		removeNullKey(map);
		removeNullValue(map);
	}

	/**
	 * 移除map的空key
	 * @param map
	 * @return 没有返回:直接对Map操作
	 */
	public static void removeNullKey(Map map){
		Set set = map.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object obj = (Object) iterator.next();
			remove(obj, iterator);
		}
	}

	/**
	 * 移除map中的value空值
	 * @param map
	 * @return 没有返回:直接对Map操作
	 */
	public static void removeNullValue(Map map){
		Set set = map.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object obj = (Object) iterator.next();
			Object value =(Object)map.get(obj);
			remove(value, iterator);
		}
	}

	/**
	 * Iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。
	 * Iterator 被创建之后会建立一个指向原来对象的单链索引表，当原来的对象数量发生变化时，这个索引表的内容不会同步改变，
	 * 所以当索引指针往后移动的时候就找不到要迭代的对象，所以按照 fail-fast 原则 Iterator 会马上抛出 java.util.ConcurrentModificationException 异常。
	 * 所以 Iterator 在工作的时候是不允许被迭代的对象被改变的。
	 * 但你可以使用 Iterator 本身的方法 remove() 来删除对象， Iterator.remove() 方法会在删除当前迭代对象的同时维护索引的一致性。
	 * @param obj
	 * @param iterator
	 */
	private static void remove(Object obj,Iterator iterator){
		if(obj instanceof String){
			String str = (String)obj;
			if(utilString.isNull(str)){
				iterator.remove();
			}
		}else if(obj instanceof Collection){
			Collection col = (Collection)obj;
			if(col==null||col.isEmpty()){
				iterator.remove();
			}

		}else if(obj instanceof Map){
			Map temp = (Map)obj;
			if(temp==null||temp.isEmpty()){
				iterator.remove();
			}

		}else if(obj instanceof Object[]){
			Object[] array =(Object[])obj;
			if(array==null||array.length<=0){
				iterator.remove();
			}
		}else{
			if(obj==null){
				iterator.remove();
			}
		}
	}




	/** ****************************************************************************************************************
	 * 使用org.apache.commons.beanutils进行转换
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;

		Object obj = beanClass.newInstance();

		org.apache.commons.beanutils.BeanUtils.populate(obj, map);

		return obj;
	}

	public static Map<?, ?> objectToMap(Object obj) {
		if(obj == null)
			return null;

		return new org.apache.commons.beanutils.BeanMap(obj);
	}


	/** ****************************************************************************************************************
	 * 使用 Introspector 进行转换
	 */
	public static Object mapToObject_Introspector(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;

		Object obj = beanClass.newInstance();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			Method setter = property.getWriteMethod();
			if (setter != null) {
				setter.invoke(obj, map.get(property.getName()));
			}
		}

		return obj;
	}

	public static Map<String, Object> objectToMap_Introspector(Object obj) throws Exception {
		if(obj == null)
			return null;

		Map<String, Object> map = new HashMap<String, Object>();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (key.compareToIgnoreCase("class") == 0) {
				continue;
			}
			Method getter = property.getReadMethod();
			Object value = getter!=null ? getter.invoke(obj) : null;
			map.put(key, value);
		}

		return map;
	}

	/** ****************************************************************************************************************
	 * 使用 reflect 进行转换
	 */
	public static Object mapToObject_reflect(Map<String, Object> map, Class<?> beanClass) throws Exception
	{
		if (map == null)
			return null;

		Object obj = beanClass.newInstance();

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
				continue;
			}

			field.setAccessible(true);
			field.set(obj, map.get(field.getName()));
		}

		return obj;
	}

	public static Map<String, Object> objectToMap_reflect(Object obj) throws Exception
	{
		if(obj == null){
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(obj));
		}

		return map;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//对Map中为Null的Key & Values 操作
	@Test
	public  void main_1() {
		Map map = new HashMap();
		map.put(1, "第一个值是数字");
		map.put("2", "第2个值是字符串");
		map.put(new String[]{"1","2"},"第3个值是数组");
		map.put(new ArrayList(), "第4个值是List");
		map.put(new HashMap(), "Map 无值");
		map.put("5", "第5个");
		map.put("6",null);
		map.put("7", "");
		map.put("8", "  ");
		System.out.println(map);

		utilMap.removeNullKey(map);
		System.out.println();
		System.out.println(map);

		utilMap.removeNullValue(map);
		System.out.println();
		System.out.println(map);
	}


	/**
	 * 有序map
	 commons-collections为maps提供了一个新的接口，
	 orderedmap，这个接口是有顺序的，但是并没有进行排序。
	 linkedmap和listorderedmap(封装器)是这个接口的两种实现。
	 这个接口支持map迭代，同时允许对map进行前向迭代和反向迭代。
	 */
	@Test
	public  void main_2() {
		/**
		 * 得到集合里按顺序存放的key之后的某一Key
		 */
		OrderedMap map = new LinkedMap();
		map.put("FIVE", "5");
		map.put("SIX", "6");
		map.put("SEVEN", "7");
		map.firstKey(); // returns "FIVE"
		map.nextKey("FIVE"); // returns "SIX"
		map.nextKey("SIX"); // returns "SEVEN"

		/**
		 * BidiMap
		 * 通过key得到value
		 * 通过value得到key
		 * 将map里的key和value对调
		 */
		BidiMap bidi = new TreeBidiMap();
		bidi.put("SIX", "6");
		bidi.get("SIX");  // returns "6"
		bidi.getKey("6");  // returns "SIX"
		//       bidi.removeValue("6");  // removes the mapping
		BidiMap inverse = bidi.inverseBidiMap();  // returns a map with keys and values swapped
		System.out.println(inverse);

		/**
		 * CollectionUtils.retainAll
		 * 得到两个集合中相同的元素
		 */
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		List<String> list2 = new ArrayList<String>();
		list2.add("2");
		list2.add("3");
		list2.add("5");
		Collection c = CollectionUtils.retainAll(list1, list2);
		System.out.println(c);
	}

}






