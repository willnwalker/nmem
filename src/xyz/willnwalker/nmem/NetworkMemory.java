package xyz.willnwalker.nmem;
import com.jmr.wrapper.server.Server;
import com.jmr.wrapper.common.exceptions.NNCantStartServer;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

/**
 * <h1>Network Memory</h1>
 * The NetworkMemory program implements a dynamically-sized memory bank that can be
 * accessed using standard Java Networking Sockets on port 2148.
 *
 * @author William Walker
 * @version 1.0
 * @since 2016-9-16
 */
public class NetworkMemory {

    static private Server server;
    static private PrintWriter log;

    public static void main(String[] args){

        try{
            //Log Initialization
            Date date = new Date();
            log = new PrintWriter(new File("log.txt"));

            //Server Initialization
            server = new Server(2148, 2148);
            if(server.isConnected()){
                writeOut("Server started successfully. Listening on port 2148.");
            }

            //Screen Initialization
            
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

}
