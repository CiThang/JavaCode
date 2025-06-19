/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ChatSocket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Desktop
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Tạo server socket và lắng nghe
            int port = 10;
            ServerSocket serverSocket = new ServerSocket(port);
            
            // Chấp nhận nhiều kết nối
            while(true){
                // Chấp nhận kết nối từ 1 Client
                Socket clientSocket = serverSocket.accept();
                Process mp = new Process(clientSocket);
                mp.start();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
