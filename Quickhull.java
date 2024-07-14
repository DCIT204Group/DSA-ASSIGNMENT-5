import java.util.ArrayList;
import java.util.List;

public class Quickhull {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Point> quickHull(Point[] points) {
        List<Point> convexHull = new ArrayList<>();
        if (points.length < 3) {
            return convexHull;
        }

        Point minPoint = points[0];
        Point maxPoint = points[0];
        for (Point point : points) {
            if (point.x < minPoint.x) {
                minPoint = point;
            }
            if (point.x > maxPoint.x) {
                maxPoint = point;
            }
        }

        convexHull.add(minPoint);
        convexHull.add(maxPoint);

        List<Point> leftSet = new ArrayList<>();
        List<Point> rightSet = new ArrayList<>();
        for (Point point : points) {
            if (point == minPoint || point == maxPoint) {
                continue;
            }
            if (isLeft(point, minPoint, maxPoint)) {
                leftSet.add(point);
            } else {
                rightSet.add(point);
            }
        }

        findHull(convexHull, leftSet, minPoint, maxPoint);
        findHull(convexHull, rightSet, maxPoint, minPoint);

        return convexHull;
    }

    private void findHull(List<Point> hull, List<Point> set, Point A, Point B) {
        int insertPosition = hull.indexOf(B);
        if (set.isEmpty()) {
            return;
        }
        if (set.size() == 1) {
            Point point = set.get(0);
            set.remove(point);
            hull.add(insertPosition, point);
            return;
        }

        int dist = Integer.MIN_VALUE;
        Point furthestPoint = null;
        for (Point point : set) {
            int distance = distance(A, B, point);
            if (distance > dist) {
                dist = distance;
                furthestPoint = point;
            }
        }

        set.remove(furthestPoint);
        hull.add(insertPosition, furthestPoint);

        List<Point> leftSetAP = new ArrayList<>();
        for (Point point : set) {
            if (isLeft(point, A, furthestPoint)) {
                leftSetAP.add(point);
            }
        }

        List<Point> leftSetPB = new ArrayList<>();
        for (Point point : set) {
            if (isLeft(point, furthestPoint, B)) {
                leftSetPB.add(point);
            }
        }

        findHull(hull, leftSetAP, A, furthestPoint);
        findHull(hull, leftSetPB, furthestPoint, B);
    }

    private int distance(Point A, Point B, Point C) {
        int ABx = B.x - A.x;
        int ABy = B.y - A.y;
        int num = ABx * (A.y - C.y) - ABy * (A.x - C.x);
        return Math.abs(num);
    }

    private boolean isLeft(Point C, Point A, Point B) {
        int position = (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);
        return position > 0;
    }
}
