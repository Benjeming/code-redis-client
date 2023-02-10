import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author ludans
 * @program codecrafters-redis-java
 * @date 2023/2/10 14:20
 */
public class ServerPingResponse {
    public static void response(Socket socket) {
        String response = "+PONG\r\n";
        try {
            DataOutputStream outputStream =
                    new DataOutputStream(socket.getOutputStream());
            outputStream.writeBytes(response);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
