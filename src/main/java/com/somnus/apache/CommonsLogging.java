package com.somnus.apache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @Title: CommonsLogging.java 
 * @Package com.somnus.apache 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月12日 下午5:40:01 
 * @version V1.0
 */
public class CommonsLogging {
	private static Log log = LogFactory.getLog(CommonsLogging.class);

	public static void main(String[] args) {
		log.error("ERROR");
		log.debug("DEBUG");
		log.warn("WARN");
		log.info("INFO");
		log.trace("TRACE");
		System.out.println(log.getClass());
	}
}
