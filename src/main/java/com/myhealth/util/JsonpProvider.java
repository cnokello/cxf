package com.myhealth.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.apache.cxf.jaxrs.utils.HttpUtils;

@SuppressWarnings("rawtypes")
@Produces("application/javascript")
public class JsonpProvider extends JSONProvider {

  @SuppressWarnings("unchecked")
  @Override
  public void writeTo(Object obj, Class cls, Type genericType, Annotation[] anns, MediaType m,
      MultivaluedMap headers, OutputStream os) throws IOException {

    String requestURI = getContext().getHttpServletRequest().getRequestURI();
    if (requestURI.contains(".jsonp")) {
      String prefix = getContext().getHttpServletRequest().getParameter("_jsonp");
      if (prefix != null && !prefix.isEmpty()) {
        os.write(prefix.getBytes(HttpUtils.getSetEncoding(m, headers, "UTF-8")));
      } else {
        os.write("callback".getBytes(HttpUtils.getSetEncoding(m, headers, "UTF-8")));
      }
      os.write('(');
      super.writeTo(obj, cls, genericType, anns, m, headers, os);
      os.write(')');
    } else {
      super.writeTo(obj, cls, genericType, anns, m, headers, os);
    }
  }
}
