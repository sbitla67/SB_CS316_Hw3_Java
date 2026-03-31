public class p1 {
    public static void main(String[] args) {
        Color myFav = Color.WHITE;
        System.out.println(myFav);
        Color myNew = Color.values()[3];
        System.out.println(myNew);

    }

    enum Color {
        ORANGE,
        BLACK,
        WHITE;
    }
}
