package lesson01;

public class Ex08_JaggedArray {
    public static void main(String[] args) {
        int[][] jagged = new int[3][];

        // 가변 배열
        jagged[0] = new int[] {1,2};
        jagged[1] = new int[] {3,4,5};
        jagged[2] = new int[] {6};

        System.out.println("jagged[0][0] = " + jagged[0][0]);
        System.out.println("jagged[0][1] = " + jagged[0][1]);

        System.out.println("jagged[1][0] = " + jagged[1][0]);
        System.out.println("jagged[1][1] = " + jagged[1][1]);
        System.out.println("jagged[1][2] = " + jagged[1][2]);

        System.out.println("jagged[2][0] = " + jagged[2][0]);

    }
}
