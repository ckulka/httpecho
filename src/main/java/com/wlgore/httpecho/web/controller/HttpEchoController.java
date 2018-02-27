package com.wlgore.httpecho.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class HttpEchoController {

	@RequestMapping("/**")
	public Map getIndex(HttpServletRequest request) {

		final Map<Object, Object> headers = Collections.list(request.getHeaderNames())
				.stream()
				.collect(Collectors.toMap((e) -> e, request::getHeader));

		final Map<String, Object> map = new HashMap<>();
		map.put("headers", headers);
		map.put("parameters", request.getParameterMap());
		map.put("remoteHost", request.getRemoteHost());
		map.put("requestURL", request.getRequestURL());
		return map;
	}
}
