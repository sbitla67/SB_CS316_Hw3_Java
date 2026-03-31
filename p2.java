public class p2 {
    public static void main(String[] args) {
        TrafficLight myTurn = TrafficLight.RED;

        switch(myTurn){
            case RED:
                System.out.println("Red light!");
                break;
            case YELLOW:
                System.out.println("Yellow light!");
                break;
            case GREEN:
                System.out.println("Green light!");
                break;
        }

    }

    enum TrafficLight {
        RED,
        YELLOW,
        GREEN,
        PURPLE;
    }
}
