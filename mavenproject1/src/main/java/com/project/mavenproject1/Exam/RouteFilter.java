/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1.Exam;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trung
 */
public class RouteFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public RouteFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RouteFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RouteFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("RouteFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpRespond = (HttpServletResponse) response;
        HttpSession session = httprequest.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("idUser") != null);

        //Check loginurl
        String loginURI = httprequest.getContextPath() + "/LoginServlet";
        boolean isLoginRequest = httprequest.getRequestURI().equals(loginURI);

        //Check DesServletUrl
        String DesServletUrl = httprequest.getContextPath() + "/DesServlet";
        boolean isDesServletUrlRequest = httprequest.getRequestURI().equals(DesServletUrl);

        String DestinationServlet = httprequest.getContextPath() + "/DestinationServlet";
        boolean isDestinationServlet = httprequest.getRequestURI().equals(DestinationServlet);

        //Onother
        String ursl = httprequest.getServletPath();
        boolean isCheckEndJsp = httprequest.getRequestURI().endsWith(".jsp");
        boolean isLoginPage = httprequest.getRequestURI().endsWith("login.jsp");
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the admin is already logged in and he's trying to login again
            // then forwards to the admin's homepage
            httpRespond.sendRedirect("IndexServlet");
        } else if (isCheckEndJsp && !ursl.endsWith("login.jsp") && !ursl.contains("Error.jsp")) {
            httpRespond.sendRedirect("Error.jsp");
        } else if (isLoggedIn && (isDesServletUrlRequest)) {
            int idUsers = (int) session.getAttribute("idUser");
            switch (idUsers) {
                case 3:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("DesServlet");
                    dispatcher.forward(request, response);
//                    httpRespond.sendRedirect("DesServlet");
                    break;
                default:
                  try (PrintWriter out = response.getWriter()) {
                    out.println("<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
                    out.println("<body>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("\n"
                            + "                Swal.fire({\n"
                            + "                    icon: 'warning',\n"
                            + "                    title: 'Access Denied',\n"
                            + "                    text: 'You seem to have accessed an address that you do not have permission to access, do you want to go back to the previous page?',\n"
                            + "                    allowOutsideClick: false,\n"
                            + "                    allowEscapeKey: false,\n"
                            + "                    allowEnterKey: false,\n"
                            + "                    confirmButtonText: `Back to home`,\n"
                            + "                }).then((result) => {\n"
                            + "                    /* Read more about isConfirmed, isDenied below */\n"
                            + "                    if (result.isConfirmed) {\n"
                            + "                        location = 'IndexServlet';\n"
                            + "                    }"
                            + "                })");
                    out.println("</script>");
                    out.println("</body>");
                }
                break;
            }
        } else if (isLoggedIn && (isDestinationServlet)) {
            int idUsers = (int) session.getAttribute("idUser");
            switch (idUsers) {
                case 3:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("DestinationServlet");
                    dispatcher.forward(request, response);
//                    httpRespond.sendRedirect("DesServlet");
                    break;
                default:
                  try (PrintWriter out = response.getWriter()) {
                    out.println("<script src=\"//cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
                    out.println("<body>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("\n"
                            + "                Swal.fire({\n"
                            + "                    icon: 'warning',\n"
                            + "                    title: 'Access Denied',\n"
                            + "                    text: 'You seem to have accessed an address that you do not have permission to access, do you want to go back to the previous page?',\n"
                            + "                    allowOutsideClick: false,\n"
                            + "                    allowEscapeKey: false,\n"
                            + "                    allowEnterKey: false,\n"
                            + "                    confirmButtonText: `Back to home`,\n"
                            + "                }).then((result) => {\n"
                            + "                    /* Read more about isConfirmed, isDenied below */\n"
                            + "                    if (result.isConfirmed) {\n"
                            + "                        location = 'IndexServlet';\n"
                            + "                    }"
                            + "                })");
                    out.println("</script>");
                    out.println("</body>");
                }
                break;
            }
        } else if (isLoggedIn || isLoginRequest) {
            // continues the filter chain
            // allows the request to reach the destination
            chain.doFilter(request, response);

        } else {
            // the admin is not logged in, so authentication is required
            // forwards to the Login page
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);

        }
        Throwable problem = null;
        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem
                != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("RouteFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("RouteFilter()");
        }
        StringBuffer sb = new StringBuffer("RouteFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
