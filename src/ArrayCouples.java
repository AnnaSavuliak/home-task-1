import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayCouples {

    public static void main(String[] args) {
        System.out.println(arrayChallenge(readArrayFromConsole()));
    }

    private static int[] readArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] inputArr = input.split(",");
        int[] arr = new int[inputArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        return arr;
    }

    public static String arrayChallenge(int[] arr) {
        if (arr.length % 2 != 0) return "Array length is not even.";
        List<int[]> invalidPairs = new ArrayList<>();
        for (int i0 = 0; i0 < arr.length; i0 += 2) {
            int i1 = i0 + 1;
            int[] base = {arr[i0], arr[i1]};
            boolean found = false;
            int j = (arr.length - 1) - ((i0 == arr.length - 2) ? 2 : 0);
            for (int j1 = j; j1 - 1 >= 0; j1 -= 2) {
                int j0 = j1 - 1;
                int[] pair = {arr[j1], arr[j0]};

                if (base[0] == pair[0] && base[1] == pair[1]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                invalidPairs.add(base);
            }

        }
        return invalidPairs.isEmpty() ? "yes" : listPairsToString(invalidPairs);
    }

    private static String listPairsToString(List<int[]> pairs) {
        StringBuilder result = new StringBuilder();
        for (int[] pair : pairs) {
            result.append(pair[0]);
            result.append(",");
            result.append(pair[1]);
            result.append(",");
        }
        result.deleteCharAt(result.length() -1);
        return result.toString();
    }
}