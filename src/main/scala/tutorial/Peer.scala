package tutorial;

import java.io.IOException;


/**
 * Main method that connects to the GemFire distributed system as a peer and
 * launches a command line user interface for the social networking application.
 * 
 * @author GemStone Systems, Inc.
 */
public class Peer {

  public static void main(String[] args) throws IOException {
    GemfireDAO dao = new GemfireDAO();
    dao.initPeer();
    TextUI ui= new TextUI(dao, System.in, System.out);
    ui.processCommands();
  }

}