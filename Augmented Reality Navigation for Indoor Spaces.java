import java.util.*;

// Class to represent a point of interest (node) in the indoor space
class PointOfInterest {
    String name;
    List<Path> paths;

    public PointOfInterest(String name) {
        this.name = name;
        this.paths = new ArrayList<>();
    }

    public void addPath(Path path) {
        paths.add(path);
    }
}

// Class to represent a path (edge) between points of interest
class Path {
    PointOfInterest target;
    int distance;

    public Path(PointOfInterest target, int distance) {
        this.target = target;
        this.distance = distance;
    }
}

// Class to represent the indoor navigation system
class IndoorNavigationSystem {
    private Map<String, PointOfInterest> pointsOfInterest;

    public IndoorNavigationSystem() {
        this.pointsOfInterest = new HashMap<>();
    }

    public void addPointOfInterest(PointOfInterest poi) {
        pointsOfInterest.put(poi.name, poi);
    }

    public void addPath(String from, String to, int distance) {
        PointOfInterest fromPoi = pointsOfInterest.get(from);
        PointOfInterest toPoi = pointsOfInterest.get(to);
        if (fromPoi != null && toPoi != null) {
            fromPoi.addPath(new Path(toPoi, distance));
        }
    }

    public List<String> findShortestPath(String start, String end) {
        Map<PointOfInterest, Integer> distances = new HashMap<>();
        Map<PointOfInterest, PointOfInterest> previous = new HashMap<>();
        PriorityQueue<PointOfInterest> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (PointOfInterest poi : pointsOfInterest.values()) {
            if (poi.name.equals(start)) {
                distances.put(poi, 0);
            } else {
                distances.put(poi, Integer.MAX_VALUE);
            }
            queue.add(poi);
        }

        while (!queue.isEmpty()) {
            PointOfInterest current = queue.poll();

            if (current.name.equals(end)) {
                break;
            }

            for (Path path : current.paths) {
                int newDist = distances.get(current) + path.distance;
                if (newDist < distances.get(path.target)) {
                    distances.put(path.target, newDist);
                    previous.put(path.target, current);
                    queue.remove(path.target);
                    queue.add(path.target);
                }
            }
        }

        List<String> path = new ArrayList<>();
        for (PointOfInterest at = pointsOfInterest.get(end); at != null; at = previous.get(at)) {
            path.add(at.name);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        IndoorNavigationSystem system = new IndoorNavigationSystem();

        // Define points of interest
        PointOfInterest lobby = new PointOfInterest("Lobby");
        PointOfInterest hallway1 = new PointOfInterest("Hallway1");
        PointOfInterest room101 = new PointOfInterest("Room101");
        PointOfInterest room102 = new PointOfInterest("Room102");
        PointOfInterest cafeteria = new PointOfInterest("Cafeteria");

        // Add points to the system
        system.addPointOfInterest(lobby);
        system.addPointOfInterest(hallway1);
        system.addPointOfInterest(room101);
        system.addPointOfInterest(room102);
        system.addPointOfInterest(cafeteria);

        // Define paths
        system.addPath("Lobby", "Hallway1", 5);
        system.addPath("Hallway1", "Room101", 10);
        system.addPath("Hallway1", "Room102", 10);
        system.addPath("Hallway1", "Cafeteria", 15);
        system.addPath("Room101", "Cafeteria", 5);
        system.addPath("Room102", "Cafeteria", 5);

        // Find shortest path from Lobby to Cafeteria
        List<String> path = system.findShortestPath("Lobby", "Cafeteria");
        System.out.println("Shortest path from Lobby to Cafeteria: " + path);
    }
}
