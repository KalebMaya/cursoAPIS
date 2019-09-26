package com.everis.springcloudzuulserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

	//del paquete slf4, framework que permite almacenar logs
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	//Si deseas que el filtro sea ejecutado o no
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	//Instrucciones a ejecutar en el filtro
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		//info es para informacion general
		//por default lo manda a consola
		logger.info("Peticion -> {} URL -> {}", request, request.getRequestURL());
		//debug para cuando se esta desarrollando
		//warn para warnings (algo puede fallar)
		//error (algo trono, pero aun funciona)
		//fatal (algo trono, se cayo el sistema)
		return null;
	}

	@Override
	//Indicamos en que momento queremos que el filtro se ejecute
	//valores: pre, post o error
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	//orden en que se va a ejecutar el filtro
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
