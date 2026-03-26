import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) { 
        int m = matrix.size();
        int n = matrix.get(0).size();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = matrix.get(i).get(j);
        int layers = Math.min(m, n) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int perimeter = 2 * (m - 2 * layer) + 2 * (n - 2 * layer) - 4;
            int[] temp = new int[perimeter];
            int idx = 0;
            for (int j = layer; j < n - layer; j++)
                temp[idx++] = arr[layer][j];
            for (int i = layer + 1; i < m - layer - 1; i++)
                temp[idx++] = arr[i][n - layer - 1];
            for (int j = n - layer - 1; j >= layer; j--)
                temp[idx++] = arr[m - layer - 1][j];
            for (int i = m - layer - 2; i > layer; i--)
                temp[idx++] = arr[i][layer];
            int rot = r % perimeter;
            int[] rotated = new int[perimeter];
            for (int i = 0; i < perimeter; i++)
                rotated[i] = temp[(i + rot) % perimeter];
            idx = 0;
            for (int j = layer; j < n - layer; j++)
                arr[layer][j] = rotated[idx++];
            for (int i = layer + 1; i < m - layer - 1; i++)
                arr[i][n - layer - 1] = rotated[idx++];
            for (int j = n - layer - 1; j >= layer; j--)
                arr[m - layer - 1][j] = rotated[idx++];
            for (int i = m - layer - 2; i > layer; i--)
                arr[i][layer] = rotated[idx++];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
