package com.somnus.apache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
