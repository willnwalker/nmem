package xyz.willnwalker.nmem;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.jmr.wrapper.common.Connection;
import com.jmr.wrapper.common.listener.SocketListener;
import com.jmr.wrapper.server.Server;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * <h1>Network Memory</h1>
 * The NetworkMemory program implements a dynamically-sized memory bank that can be
 * accessed using standard Java Networking Sockets on TCP port 2148.
 *
 * @author William Walker
 * @version 1.0
 * @since 2016-9-16
 */
public class NetworkMemory {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd.HHmmss");
    private static Server server;
    private static PrintWriter log;

    public static void main(String[] args){

        try{
            //Log Initialization
            String init_time = DATE_FORMAT.format(new Date());
            log = new PrintWriter(new File("log"+init_time+".txt"));
            writeOut("Log initialized successfully at "+init_time+".");

            //Server Initialization
            server = new Server(2148, 2148);
            if(server.isConnected()){
                writeOut("Server started successfully. Listening on port 2148.");
            }

            //Screen Initialization
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            writeOut("Terminal size: "+screen.getTerminalSize().toString());

            //Storage Initialization
            //byte[] bank = new byte[100000000];
            byte[] bank = new byte[2000];

        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

    }

    private static void writeOut(String s){
        System.out.println(s);
        log.println(s);
        log.flush();
    }

    private class ServerListener implements SocketListener{

        @Override
        public void received(Connection con, Object obj){
            return;
        }

        @Override
        public void connected(Connection con){
            return;
        }

        @Override
        public void disconnected(Connection con){

        }

    }

}
