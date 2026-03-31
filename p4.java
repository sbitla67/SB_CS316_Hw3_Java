public class p4 {
    public static void main(String[] args) {
        for (RockyPlanets ss : RockyPlanets.values()) {
            System.out.println(ss.name() + " -> ordinal: " + ss.ordinal());
        }

        // Show all constants still appear despite shared custom value
        for (Priority p : Priority.values()) {
            System.out.println(p.name() + " -> level: " + p.getLevel() + ", ordinal: " + p.ordinal());
        }

    }

    enum RockyPlanets {
        MERCURY,
        VENUS,
        EARTH,
        MARS;
    }

    enum Priority {
        LOW(1), MEDIUM(2), HIGH(2);  // HIGH and MEDIUM share the same custom value

        private final int level;

        Priority(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }
}
