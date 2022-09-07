package TCP_UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient extends Thread {

    /*TCP(Transmission Control Protocol)
    송/수신 호스트 내 프로세스 상호 간에 신뢰적인 연결지향성 서비스를 제공
    IP의 비신뢰적인 최선형 서비스에다가 신뢰적인 연결지향성 서비스를 제공하게 됨
    신뢰적인 전송을 보장함으로써, 어플리케이션 구현이 한층 쉬워지게 됨
    신뢰성 있음 (Reliable)
    패킷 손실, 중복, 순서바뀜 등이 없도록 보장
    TCP 하위계층인 IP 계층의 신뢰성 없는 서비스에 대해 다방면으로 신뢰성을 제공
    연결지향적 (Connection-oriented)
    같은 전송계층의 UDP가 비연결성(connectionless)인 것과는 달리, TCP는 연결지향적임
    이 경우, 느슨한 연결(Loosly Connected)을 갖으므로 강한 연결을 의미하는 가상회선이라는 표현 보다는 오히려 연결지향적이라고 말함
    연결 관리를 위한 연결설정 및 연결해제 필요
    양단간 어플리케이션/프로세스는 TCP가 제공하는 연결성 회선을 통하여 서로 통신

    UDP
    전송 계층의 통신 프로토콜의 하나 (TCP에 대비됨)
    신뢰성이 낮은 프로토콜로써 완전성을 보증하지 않으나,
    가상회선을 굳이 확립할 필요가 없고 유연하며 효율적 응용의 데이타 전송에 사용
    비연결성이고, 신뢰성이 없으며, 순서화되지 않은 Datagram 서비스 제공
    메세지가 제대로 도착했는지 확인하지 않음 (확인응답 없음)
    수신된 메세지의 순서를 맞추지 않음 (순서제어 없음)
    흐름 제어를 위한 피드백을 제공하지 않음 (흐름제어 없음)
    검사합을 제외한 특별한 오류 검출 및 제어 없음 (오류제어 거의 없음)
    UDP를 사용하는 프로그램 쪽에서 오류제어 기능을 스스로 갖추어야 함
    데이터그램 지향의 전송계층용 프로토콜 (논리적인 가상회선 연결이 필요없음)
    비연결접속상태 하에서 통신
    실시간 응용 및 멀티캐스팅 가능
    빠른 요청과 응답이 필요한 실시간 응용에 적합
    여러 다수 지점에 전송 가능 (1:多)
    헤더가 단순함
    UDP는 TCP 처럼 16 비트의 포트 번호를 사용하나,
    헤더는 고정크기의 8 바이트(TCP는 20 바이트) 만 사용
    즉, 헤더 처리에 많은 시간과 노력을 요하지 않음

    TCP vs UDP
    가장 큰 차이는 신뢰성과 연결성에 있음
    TCP는 신뢰성 있고 연결지향적이지만 UDP는 신뢰성이 없고, 비연결적
    TCP는 송신자-수신자 연결이 되어야 통신가능, UDP는 연결 없이도 통신 가능
    TCP UDP 사용 예
    TCP는 순서를 보장한다는 점과 신뢰도가 있다는 점에서 대부분의 HTTP 통신, 이메일이나 파일전송처럼 순서대로 도착해야 하는 상황에서 사용된다.

    UDP는 순서는 보장해주지 못하지만 실시간으로 반응해야하는 실시간 동영상 플레이어나 게임, 혹은 DNS에서 사용.
    DNS의 경우 누군가 도메인을 쳤을때마다 그때 그때 서버와 클라이언트가 커넥션을 맺으면 속도가 느려지기 때문에 UDPf를 사용한다.

    cf. 채팅에서 TCP를 사용하는 이유?
    채팅에서 TCP를 사용하는 이유는 연결된 상태에서 순서대로 송신자와 수신자가 보낸 메세지를 그대로 전송할 수 있기 때문이다.
    고로 양뱡향통신에 유리하다. (UDP는 그 순서를 보장해주지 못하기 때문이다.)
*/

    private String str;
    private BufferedReader file;
    private static int SERVERPORT=3000;
    public UDPClient(String ip,int port){
        try{
            InetAddress ia = InetAddress.getByName(ip);
            DatagramSocket ds = new DatagramSocket(port);
            System.out.print("message : ");
            file = new BufferedReader(new InputStreamReader(System.in));
            str = file.readLine();
            byte buffer[] = str.getBytes();
            DatagramPacket dp = new DatagramPacket(
                    buffer,buffer.length,ia,SERVERPORT);
            ds.send(dp);
            buffer = new byte[512];
            dp = new DatagramPacket(buffer,buffer.length);
            ds.receive(dp);
            System.out.println("server ip : "+dp.getAddress() + " , server port : "+dp.getPort());
            System.out.println("수신된 데이터 : "+ new String(dp.getData()).trim());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void main(String[] args){
        new UDPClient("localhost",2000);
    }

}
