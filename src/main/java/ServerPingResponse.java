import jdk.internal.util.xml.impl.Input;

import java.io.*;
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

    public static void responseV2(Socket socket) {

        String response = "+PONG\r\n";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true) {
                    String line = reader.readLine();
                    if ("ping".equals(line)) {
                        writer.write(response);
                        writer.flush();
                        break;
                    }
                    if (line == null) {
                        break;
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
