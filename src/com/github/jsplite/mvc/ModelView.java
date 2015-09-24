package com.github.jsplite.mvc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 从controller传回view端的数据
 *
 * @author lpn
 */
public class ModelView implements Iterable<Map.Entry<String, Object>> {
    private Map<String, Object> map;

    public ModelView() {
        this.map = new LinkedHashMap<String, Object>();
    }

    public <T> T getObject(String attributeName) {
        T value = (T) this.map.get(attributeName);
        return value;
    }

    public Map<String, Object> getAllObjects() {
        return this.map;
    }

    public <T> void addObject(String attributeName, T attributeValue) {
        map.put(attributeName, attributeValue);
    }


    public void addAllObjects(Map<String, Object> map) {
        this.map.putAll(map);
    }

    public Object removeObject(String attributeName) {
        return map.remove(attributeName);
    }

    public void removeAllObjects() {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    @Override
    public Iterator<Entry<String, Object>> iterator() {
        return this.map.entrySet().iterator();
    }

    @Override
    public String toString() {
        if (map == null || map.isEmpty())
            return "null";

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Set<?> keySet = map.keySet();
        for (Object key : keySet) {
            sb.append("\"" + key + "\":\"" + map.get(key) + "\"");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length());
        sb.append("}");

        return sb.toString();
    }

}
