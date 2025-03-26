import java.net.*;
import java.util.Scanner;

class UDPClient {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        DatagramSocket dgSocket = new DatagramSocket();
        String message;
        byte[] buffer;
        DatagramPacket dgPacket;
        InetAddress address = InetAddress.getByName("127.0.0.1");
        
        System.out.println("Enter messages to send: ");
        while (true) {
            message = in.nextLine();
            buffer = message.getBytes();
            dgPacket = new DatagramPacket(buffer, buffer.length, address, 4000);
            dgSocket.send(dgPacket);

            if (message.equalsIgnoreCase("exit")) {
                dgSocket.close();
                break;
            }

        }
    }

}