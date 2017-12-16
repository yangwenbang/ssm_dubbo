package cn.javaxxw.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class RedisCacheUtil {

	private static RedisUtil redisUtil;

	public static RedisUtil getRedisUtil() {
		return redisUtil;
	}

	public static void setRedisUtil(RedisUtil redisUtil) {
		RedisCacheUtil.redisUtil = redisUtil;
	}

	public static Object getObject(String key) {
		if (StringUtils.isNotEmpty(key)) {
			return redisUtil.ObjectGet(key);
		}
		return null;
	}

	public static String getMapObjectValue(String key, String field) {
		if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(field)) {
			Map<Object, Object> map = getMapObject(key);
			if (map != null && map.size() > 0) {
				return StringUtils.trim((String)map.get(field));
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<Object, Object> getMapObject(String key) {
		if (StringUtils.isNotEmpty(key) && isExistCache(key)) {
			Object object = redisUtil.ObjectGet(key);
			if (object != null) {
				return (Map<Object, Object>) object;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<Map<Object, Object>> getListObject(String key) {
		if (StringUtils.isNotEmpty(key) && isExistCache(key)) {
			Object object = redisUtil.ObjectGet(key);
			if (object != null) {
				return (List<Map<Object, Object>>) object;
			}
		}
		return null;
	}

	public static String addCache(String key, Object object) {
		if (StringUtils.isNotEmpty(key)) {
			return redisUtil.ObjectSet(key, object);
		}
		return null;
	}

	public static long delCache(String key) {
		if (StringUtils.isNotEmpty(key)) {
			return redisUtil.delKey(key).longValue();
		}
		return 0L;
	}

	public static boolean isExistCache(String key) {
		boolean result = false;
		if (StringUtils.isNotEmpty(key)) {
			result = redisUtil.existKey(key).booleanValue();
		}
		return result;
	}

}
