package com.lzugis.config;

import com.lzugis.proxy.HandlerMethodReturnValueHandlerProxy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfig implements InitializingBean {
  @Autowired
  private RequestMappingHandlerAdapter handlerAdapter;

  @Override
  public void afterPropertiesSet() throws Exception {
    List<HandlerMethodReturnValueHandler> list = handlerAdapter.getReturnValueHandlers();
    List<HandlerMethodReturnValueHandler> newList = new ArrayList<>();
    if (null != list) {
      for (HandlerMethodReturnValueHandler valueHandler: list) {
        if (valueHandler instanceof RequestResponseBodyMethodProcessor) {
          HandlerMethodReturnValueHandlerProxy proxy = new HandlerMethodReturnValueHandlerProxy(valueHandler);
          newList.add(proxy);
        } else {
          newList.add(valueHandler);
        }
      }
    }

    handlerAdapter.setReturnValueHandlers(newList);
  }
}
