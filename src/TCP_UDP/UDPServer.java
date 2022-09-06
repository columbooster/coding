package TCP_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    /*public static void main(String[] args) {
        try {
            // 상대방이 연결할 수 있도록 UDP 소켓 생성
            DatagramSocket dsoc = new DatagramSocket(7777);
            // 전송받은 데이터를 지정할 바이트 배열선언
            byte[] date = new byte[66536];

            //UDP 통신으로 전송을 받을 packet 객체 생성
            DatagramPacket dp = new DatagramPacket(date, date.length);

            System.out.println("데이터 수신 준비 완료...");
            while (true){
                //데이터 전송 받기
                dsoc.receive(dp);
                //데이터 보낸곳 확인
                System.out.println("송신 IP: " + dp.getAddress());
                //보낸 데이터를 UTF-8에 문자열로 변환
                String msg = new String(dp.getData(),"UTF-8");
                System.out.println("보내 온 내용 : " + msg);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }*/

    public UDPServer(int port) {
        try {
            DatagramSocket ds = new DatagramSocket(port);
            while (true) {
                byte buffer[] = new byte[512];
                DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
                System.out.println("ready");
                ds.receive(dp);
                String str = new String(dp.getData());
                System.out.println("수신된 데이터 : " + str);

                InetAddress ia = dp.getAddress();
                port = dp.getPort();
                System.out.println("client ip : " + ia + " , client port : " + port);
                dp = new DatagramPacket(dp.getData(),dp.getData().length, ia,port);
                ds.send(dp);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new UDPServer(3000);
    }




}
