package array;

public class LC_1232_CheckIfItIsAStraightLine {

    public static void main(String[] args) {

        int[][] coordinates = {{1,2}, {2,3}, {3,4},{4,5}};

        for(int i = 0; i<coordinates.length-2;i++) {
            if(caluclate(coordinates, i) != 0) {
                System.out.println(false);
            }
        }
        System.out.println(true);

    }
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) {
            return true;
        }
        for(int i = 0; i<coordinates.length-2;i++) {
            if(caluclate(coordinates, i) != 0) {
                return false;
            }
        }
        return true;
    }

    private static int caluclate(int[][] coordinates, int first) {
        int x1 = coordinates[first][0];
        int y1 = coordinates[first][1];
        int x2 = coordinates[first+1][0];
        int y2 = coordinates[first+1][1];
        int x3 = coordinates[first+2][0];
        int y3 = coordinates[first+2][1];

        return x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2);

    }

}
