/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-12-04 19:18:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class trangkhach_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>Trang Khách</title>\n");
      out.write("    <style>\n");
      out.write("      body {\n");
      out.write("        font-family: Arial, sans-serif;\n");
      out.write("      }\n");
      out.write("      .container {\n");
      out.write("        text-align: center;\n");
      out.write("        margin-top: 50px;\n");
      out.write("      }\n");
      out.write("      .button {\n");
      out.write("        display: inline-block;\n");
      out.write("        margin: 10px;\n");
      out.write("        padding: 15px 30px;\n");
      out.write("        font-size: 16px;\n");
      out.write("        color: #fff;\n");
      out.write("        background-color: #007bff;\n");
      out.write("        border: none;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        text-decoration: none;\n");
      out.write("        cursor: pointer;\n");
      out.write("      }\n");
      out.write("      .button:hover {\n");
      out.write("        background-color: #0056b3;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <p>Hệ thống quản lý nhân sự phòng ban.</p>\n");
      out.write("      <a href=\"nhanvien?action=readAll\" class=\"button\"\n");
      out.write("        >Xem thông tin nhân viên</a\n");
      out.write("      >\n");
      out.write("      <a href=\"phongban?action=readAll\" class=\"button\"\n");
      out.write("        >Xem thông tin phòng ban</a\n");
      out.write("      >\n");
      out.write("      <a href=\"nhanvien?action=search\" class=\"button\">Tìm kiếm nhân viên</a>\n");
      out.write("      <a href=\"login.jsp\" class=\"button\">Đăng nhập</a>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
