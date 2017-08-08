package com.zl.jdbc.apche.dbutils.util;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;

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
