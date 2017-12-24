package com.gencore.jetty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.webapp.WebAppContext;

public class Start extends AbstractHandler {

    private static Server server;

    public static void main(String[] args) throws Exception {

        server = new Server(8083);

        WebAppContext context = new WebAppContext();
        
        context.setWar("build/test/Gencore_portal_test.war");

        //context.setDescriptor("D:/WORK/workspace/Gencore_portal/src/main/webapp/WEB-INF/web.xml");
        //context.setResourceBase("D:/WORK/workspace/Gencore_portal/src/main/webapp");
        context.setExtraClasspath("/src/main/deploy");
        context.setContextPath("/Gencore_portal");
        context.setParentLoaderPriority(true);
        server.setHandler(context);

        Thread monitor = new MonitorThread();
        monitor.start();
        server.start();
        server.join();

    }

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
            throws IOException, ServletException {
        // TODO Auto-generated method stub

    }

    private static class MonitorThread extends Thread {

        private ServerSocket socket;

        public MonitorThread() {
            setDaemon(true);
            setName("StopMonitor");
            try {
                socket = new ServerSocket(8079, 1, InetAddress.getByName("127.0.0.1"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            System.out.println("*** running jetty 'stop' thread");
            Socket accept;
            try {
                accept = socket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                reader.readLine();
                System.out.println("*** stopping jetty embedded server");
                server.stop();
                accept.close();
                socket.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
