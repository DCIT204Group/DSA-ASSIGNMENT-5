import java.util.Arrays;

public class ClosestPair {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public double findClosestPair(Point[] points) {
        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, (p1, p2) -> Integer.compare(p1.x, p2.x));

        Point[] sortedByY = points.clone();
        Arrays.sort(sortedByY, (p1, p2) -> Integer.compare(p1.y, p2.y));

        return closestPair(sortedByX, sortedByY, 0, points.length - 1);
    }

    private double closestPair(Point[] sortedByX, Point[] sortedByY, int left, int right) {
        if (right - left <= 3) {
            return bruteForceClosestPair(sortedByX, left, right);
        }

        int mid = (left + right) / 2;
        Point midPoint = sortedByX[mid];

        Point[] sortedByYLeft = Arrays.copyOfRange(sortedByY, left, mid + 1);
        Point[] sortedByYRight = Arrays.copyOfRange(sortedByY, mid + 1, right + 1);

        double dLeft = closestPair(sortedByX, sortedByYLeft, left, mid);
        double dRight = closestPair(sortedByX, sortedByYRight, mid + 1, right);

        double d = Math.min(dLeft, dRight);

        return Math.min(d, stripClosest(sortedByY, left, right, midPoint, d));
    }

    private double stripClosest(Point[] sortedByY, int left, int right, Point midPoint, double d) {
        Point[] strip = Arrays.stream(sortedByY)
                              .filter(p -> Math.abs(p.x - midPoint.x) < d)
                              .toArray(Point[]::new);

        double minDist = d;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < minDist; j++) {
                minDist = Math.min(minDist, distance(strip[i], strip[j]));
            }
        }
        return minDist;
    }

    private double bruteForceClosestPair(Point[] points, int left, int right) {
        double minDist = Double.MAX_VALUE;
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                minDist = Math.min(minDist, distance(points[i], points[j]));
            }
        }
        return minDist;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
