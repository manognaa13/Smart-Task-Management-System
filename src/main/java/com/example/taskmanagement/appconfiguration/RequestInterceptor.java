package com.example.taskmanagement.appconfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * interceptor for handling http requests and responses.
 * 
 * this class implements the @HandlerInterceptor interface to intercept requests before
 * they reach the controller, after the controller has processed the request, and after
 * the response has been sent. It logs important information about the request and response.
 */
@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

	/**
     * Pre-handle method that is executed before the request reaches the controller.
     * 
     * Logs the request method, uri, and servlet path, as well as the controller and method
     * names if the handler is a @HandlerMethod
     * 
     * @param request the @HttpServletRequest
     * @param response the @HttpServletResponse
     * @param object the handler (either a @HandlerMethod or a simple handler)
     * @return true to continue the request processing; false to abort
     * @throws @Exception in case of errors
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {
		logger.info("1 - pre handle.");
		logger.info("METHOD type : " + request.getMethod());
		logger.info("Request URI : " + request.getRequestURI());
		logger.info("Servlet PATH : " + request.getServletPath());
		if (object instanceof HandlerMethod) {
			Class<?> controllerClass = ((HandlerMethod) object).getBeanType();
			String methodName = ((HandlerMethod) object).getMethod().getName();
			logger.info("Controller name : " + controllerClass.getName());
			logger.info("Method name : " + methodName);
		}
		return true; // Continue with the request processing
	}

	/**
     * Post-handle method that is executed after the controller processes the request.
     * 
     * Can be used to modify the @ModelAndView before rendering the view.
     * 
     * @param request the @HttpServletRequest
     * @param response the @HttpServletResponse
     * @param object the handler (either a @HandlerMethod or a simple handler)
     * @param model the @ModelAndView
     * @throws @Exception in case of errors
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView model) {
		logger.info("2 - Post-handle : Request processed by controller.");
		// Additional logic can be added here if needed
	}

	/**
     * after completion method that is executed after the complete request has finished.
     * 
     * Logs any exceptions that occurred during request processing.
     * 
     * @param request the @HttpServletRequest
     * @param response the @HttpServletResponse
     * @param object the handler (either a @HandlerMethod or a simple handler)
     * @param exception any exception that occurred during request processing
     * @throws @Exception in case of errors
     */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {
		if(exception != null) {
            logger.info("An error occurred during request processing: {} ", exception.getMessage());
        }
        logger.info("3 - After completion: Request processing finished.");
	}
}