package level5;

public class II_Normal_Maze {
    public static void main(String[] args) {
        int[][] maze = new int[3][3];
        maze_path2(maze, 0, 0);
    }

    public static void maze_path2(int[][] maze, int currentRow, int currentCol) {
        if (currentRow == maze.length - 1 && currentCol == maze[0].length - 1) {
            maze[currentRow][currentCol] = 1;
            display(maze);
            maze[currentRow][currentCol] = 0;
            return;
        }

        if (currentRow < 0 || currentRow >= maze.length || currentCol < 0 || currentCol >= maze[0].length || maze[currentRow][currentCol] == 1) {
            return;
        }

        int[] row = {0, 1, 0, -1};
        int[] col = {1, 0, -1, 0};

        maze[currentRow][currentCol] = 1;

        for (int i = 0; i < col.length; i++) {
            maze_path2(maze, currentRow + row[i], currentCol + col[i]);
        }

        maze[currentRow][currentCol] = 0;
    }

    public static void display(int[][] maze) {
        for (int[] ints : maze) {
            for (int i1 = 0; i1 < maze[0].length; i1++) {
                System.out.print(ints[i1] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
