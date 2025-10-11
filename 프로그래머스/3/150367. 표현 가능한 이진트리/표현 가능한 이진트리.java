import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (long number : numbers) {
            if (isBinaryTree(number)) {
                answer.add(1);
            } else {
                answer.add(0);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isBinaryTree(long number) {
        String binary = Long.toBinaryString(number);
        String fullBinary = getFullBinary(binary);
        int len = fullBinary.length();

        int root = len / 2;
        String leftSubTree = fullBinary.substring(0, root);
        String rightSubTree = fullBinary.substring(root + 1);

        if (fullBinary.charAt(root) == '0') {
            return false;
        }

        return isBinaryTree(leftSubTree) && isBinaryTree(rightSubTree);
    }

    private String getFullBinary(String binary) {

        int length = binary.length();
        int nodeCount = 1;
        int level = 1;
        while (length > nodeCount) {
            level *= 2;
            nodeCount += level;
        }

        int offset = nodeCount - length;
        return "0".repeat(offset) + binary;
    }

    private boolean isBinaryTree(String binary) {
        int len = binary.length();
        if (binary.length() == 0) return true;

        int root = len / 2;
        String leftSubTree = binary.substring(0, root);
        String rightSubTree = binary.substring(root + 1);

        if (binary.charAt(root) == '0') {
            return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
        }

        return isBinaryTree(leftSubTree) && isBinaryTree(rightSubTree);
    }

    private boolean isZeroTree(String binary) {
        int len = binary.length();
        if (binary.length() == 0) return true;

        int root = len / 2;
        String leftSubTree = binary.substring(0, root);
        String rightSubTree = binary.substring(root + 1);

        if (binary.charAt(root) == '1') {
            return false;
        }

        return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
    }
}

