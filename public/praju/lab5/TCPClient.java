import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String args[]) throws Exception {
        Socket sock = new Socket("127.0.0.1", 4000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Filename : ");
        String fname = sc.next();
        OutputStream oStream = sock.getOutputStream();
        PrintWriter pWrite = new PrintWriter(oStream, true);
        pWrite.println(fname);
        InputStream istream = sock.getInputStream();
        sc = new Scanner(istream);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}