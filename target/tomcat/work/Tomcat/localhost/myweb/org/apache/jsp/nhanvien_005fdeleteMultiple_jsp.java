/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-12-04 19:44:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.example.model.BEAN.nhanvienBEAN;

public final class nhanvien_005fdeleteMultiple_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Xoá nhân viên</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h2>Xoá nhân viên</h2>\r\n");
      out.write("    ");
 if (request.getAttribute("error") != null) { 
      out.write("\r\n");
      out.write("        <p style=\"color: red;\">");
      out.print( request.getAttribute("error") );
      out.write("</p>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form action=\"nhanvien?action=deleteMultiple\" method=\"post\"> \r\n");
      out.write("        <table border=\"1\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>IDNV</th>\r\n");
      out.write("                    <th>Họ tên</th>\r\n");
      out.write("                    <th>IDPB</th>\r\n");
      out.write("                    <th>Địa chỉ</th>\r\n");
      out.write("                    <th>Action</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("                ");

                    List<nhanvienBEAN> nhanviens = (List<nhanvienBEAN>) request.getAttribute("nhanviens");
                    if (nhanviens != null) {
                        for (nhanvienBEAN nv : nhanviens) {
                
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>");
      out.print( nv.getIdnv() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( nv.getHoten() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( nv.getIdpb() );
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.print( nv.getDiachi() );
      out.write("</td>                   \r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input class=\"delete\" type=\"checkbox\" name=\"idnvList\" value=\"");
      out.print( nv.getIdnv() );
      out.write("\">\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                ");

                        }
                    }
                
      out.write("\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        <br>\r\n");
      out.write("        <input type=\"submit\" value=\"Xóa Nhân Viên Đã Chọn\">\r\n");
      out.write("    </form>\r\n");
      out.write("    <br /> <br/>\r\n");
      out.write("    <form action=\"admin\" method=\"get\">\r\n");
      out.write("        <button type=\"submit\">Trang chủ</button>\r\n");
      out.write("      </form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
