package com.zl.core.jdbc.sql;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuidiwhere on 2017/8/12.
 * http://blog.csdn.net/cuidiwhere/article/details/8130434
 * @author 实现javaBean与Map<String,Object>相互转换 <br/>
 * MapToBean1 <br/>
 * BeanToMap <br/><br/>
 * 1.为什么要实现javaBean与Map<String,Object>相互转换？<br/>
 * 用过spring的都知道spring的MVC框架中有一个BaseCommandController对象，<br/>
 * 利用这个对象我们就可以很方便的将从客户端传递过来的参数封装到一个JavaBean对象中去，<br/>
 * 而不需要我们request.getParameter("name");bean.setName(name);了，<br/>
 * 从而也简化了不少的工作。如果大家用过BeanUtils.populate的话，<br/>
 * 就知道，这个方法是可以很方便的将request提交的页面表单自动填写到你创建的对象中<br/><br/>
 *
 * 2. 如何实现javaBean与Map<String,Object>相互转换？<br/>
 * 方法1： 利用Java.beans.Introspector和java.beans.PropertyDescriptor实现 javaBean与Map<String,Object>互转<br/>
 * 方法2： 利用org.apache.commons.beanutils.BeanUtils工具类，BeanUtils.populate实现Map 转换为javaBean <br/>
 */
public class TransForMation {


    /**
     * Map --> Bean 1: 利用org.apache.commons.beanutils 工具类实现[Map 转 Bean]
     *
     * @param map
     * @param obj
     */
    public static void MapToBean1(Map<String, Object> map, Object obj) {
        if (map == null || obj == null) {
            return;
        }
        try {
            BeanUtils.populate(obj, map);
        } catch (Exception e) {
            System.out.println("transMap2Bean2 Error " + e);
        }
    }

    /**
     * Map --> Bean 2: 利用Introspector,PropertyDescriptor实现 [Map 转 Bean]
     *
     * @param map
     * @param obj
     */
    public static void MapToBean2(Map<String, Object> map, Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }

            }

        } catch (Exception e) {
            System.out.println("transMap2Bean Error " + e);
        }

        return;

    }

    /**
     * Bean --> Map 1: 利用Introspector和PropertyDescriptor 实现[Bean 转 Map]
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> BeanToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }

        return map;

    }
}