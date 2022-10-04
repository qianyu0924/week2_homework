import java.security.SecureRandom;

class ticketClass implements Runnable {
    
    static int ticket = 10000;
    int getTicket;
    Thread t;
    
    ticketClass(String name) {
        getTicket = 0;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        SecureRandom random = new SecureRandom();
        int number = 1 + random.nextInt(4);
        while (grabTicket(number) == true) {
            getTicket += number;
            //System.out.println(t.getName()+"賣出"+getTicket+"張票");
        }
        System.out.println(t.getName()+"總共賣出"+getTicket+"張票");
    }

    private synchronized static boolean grabTicket(int num) {    
        if(ticket >= num) {    
            ticket -= num;
            return true; 
        }else {
            return false;
        }
    }
}

public class homework {
    public static void main(String[] args) {
        ticketClass tA = new ticketClass("售票機A");
        ticketClass tB = new ticketClass("售票機B");
        ticketClass tC = new ticketClass("售票機C");
        ticketClass tD = new ticketClass("售票機D");
    }
}
