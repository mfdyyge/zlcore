package com.zl.base.map;

import org.apache.commons.collections4.MapUtils;

import java.util.Map;



public class MapUtil {

	// 判断Map是否非空 <Map!=null>
	public static boolean isNotEmpty(Map<?, ?> map) {
		return MapUtils.isNotEmpty(map);
	}

	// 判断Map是否为空  <Map==null>
	public static boolean isEmpty(Map<?, ?> map) {
		return MapUtils.isEmpty(map);
	}
}
