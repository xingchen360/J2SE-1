package com.somnus.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** 
 * @Description: TODO
 * @author Somnus
 * @date 2015年11月20日 下午2:10:04 
 * @version V1.0 
 */
public class JacksonJsonUtil {

    private static Logger log = LoggerFactory.getLogger(JacksonJsonUtil.class);
    
    /**
     * 空JSON字符串
     */
    private final static String EMPTY_JSON_STRING = "{}";
    
    /**
     * Object转换为JSON字符串
     * @Description
     * @param obj
     * @return
     */
    public static String obj2JsonString(Object obj){    
        try{
            ObjectMapper objectMapper = instanceObjectMapper();
            if(obj == null)return EMPTY_JSON_STRING;
            return objectMapper.writeValueAsString(obj);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * List转换为JSON字符串
     * @Description
     * @param list
     * @return
     */
    public static<E> String list2JsonString(List<E> list){  
        try{
            ObjectMapper objectMapper = instanceObjectMapper();
            if(list == null || list.isEmpty())return EMPTY_JSON_STRING;
            return objectMapper.writeValueAsString(list);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * Map转换为JSON字符串
     * @param map 需要转换的Map
     * @return
     */
    public static<E, V> String map2JsonString(Map<E, V> map){   
        try{
            ObjectMapper objectMapper = instanceObjectMapper();
            if(map == null || map.isEmpty())return EMPTY_JSON_STRING;
            return objectMapper.writeValueAsString(map);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
// *************************************以下JSON转换为对象***************************************************************
    
    /**
     * JSON字符串转换为Object
     * @param strJsonString 需要转换的JSON字符串
     * @param clazz
     * @return
     */
    public static<T> T jsonString2Object(String strJsonString, Class<T> clazz){
        try {
            ObjectMapper objectMapper = instanceObjectMapper();
            if(StringUtils.isBlank(strJsonString))strJsonString = EMPTY_JSON_STRING;
            return objectMapper.readValue(strJsonString, clazz);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * json转换为list
     * @param jsonStr
     * @param clazz
     * @return
     */
    public static<T> List<T> json2ObjectList(String jsonStr , Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,clazz);
        try {
            jsonStr = replaceString(jsonStr, "&quot;", "\"");
            return mapper.readValue(jsonStr, javaType);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * JSON字符串转换为Map
     * @param strJsonString 需要转换的JSON字符串
     * @return
     */
    @SuppressWarnings("unchecked")
    public static<E, V> Map<E, V> jsonString2Map(String strJsonString){
        try {
            ObjectMapper objectMapper = instanceObjectMapper();
            if(StringUtils.isBlank(strJsonString))strJsonString = EMPTY_JSON_STRING;
            return objectMapper.readValue(strJsonString, Map.class);
        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    /**
     * 
     * 替换一个字符串中的某些指定字符
     * 
     * @param strData
     *            String 原始字符串
     * 
     * @param regex
     *            String 要替换的字符串
     * 
     * @param replacement
     *            String 替代字符串
     * 
     * @return String 替换后的字符串
     */
    public static String replaceString(String strData, String regex,String replacement){
        if (strData == null) {
            return null;
        }
        int index;
        index = strData.indexOf(regex);
        String strNew = "";
        if (index >= 0) {
            while (index >= 0) {
                strNew += strData.substring(0, index) + replacement;
                strData = strData.substring(index + regex.length());
                index = strData.indexOf(regex);
            }
            strNew += strData;
            return strNew;
        }
        return strData;
    }
    
    /**
     * 实例化ObjectMapper
     * @return
     */
    public static ObjectMapper instanceObjectMapper(){
        JsonFactory jf = new JsonFactory();
        jf.configure(Feature.WRITE_NUMBERS_AS_STRINGS, true);
        return new ObjectMapper(jf);
    }
    
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        user.setAge(20);
        User user2 = new User();
        user2.setUsername("admin2");
        user2.setPassword("123456");
        user2.setAge(24);
        List<Plot> listt = Arrays.asList(new Plot("diudiu"),new Plot("dudu") );
        user.setList(listt);
        Map<String,List<String>> mapp = new HashMap<String, List<String>>();
        mapp.put("somnus",Arrays.asList("1","2"));
        user.setMap(mapp);
        System.out.println("一：" + obj2JsonString(user));

        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user2);
        String listStr = list2JsonString(list);
        System.out.println("二：" + listStr);

        Map<String, User> map1 = new HashMap<String, User>();
        map1.put("1", user);
        map1.put("2", user2);
        String mapStr = map2JsonString(map1);
        System.out.println("三：" + mapStr);
        
        User u = jsonString2Object("{\"username\":\"admin\",\"password\":\"123\",\"age\":\"20\"}",User.class);
        System.out.println("四：" +u.getUsername());
        List<User> l = json2ObjectList(listStr,User.class);
        System.out.println("五：" + l.get(0).getPassword());
        
        Map<String, String> m = jsonString2Map("{\"username\":\"admin\",\"password\":\"123\",\"age\":\"20\"}");
        for(Iterator<String> it = m.keySet().iterator();it.hasNext();){
            String key = (String)it.next();
            String value = (String)m.get(key);
            System.out.println(key+":"+value);
        }
        
        Map<String, Map<String, String>> m2 = jsonString2Map(mapStr);
        for(Iterator<String> it = m2.keySet().iterator();it.hasNext();){
            String key = (String)it.next();
            Map<String, String> map = (Map<String, String>)m2.get(key);
            System.out.println(key+":"+map.get("username")+"|"+map.get("password"));
        }
    }
}
