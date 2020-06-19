package dynamicprogramming;

/**
 * Created by rahulchakraborty on 8/21/16.
 */
public class KnightsShortestPath {

    /*static int[,] offsets = { { -2, -1 }, { -1, -2 }, { 2, -1 }, { 1, -2 }, { -2, 1 }, { -1, 2 }, { 2, 1 }, { 1, 2 } };

    static int GetIndex(int row, int col)
    {
        return row * 8 + col;
    }

    static int GetRow(int ind)
    {
        return ind / 8;
    }

    int GetCol(int ind)
    {
        return ind % 8;
    }

    List<int> FindShortestPath(int startInd, int endInd)
    {
        var path = new List<int>();
        List<int> resultPath = null;
        int[] field = new int[64];
        for (int i = 0; i < 64; i++)
        {
            field[i] = -1;
        }
        FindRecursive(field, startInd, endInd, path, ref resultPath);
        return resultPath;
    }


    List<int> GetNextIndexes(int curInd)
    {
        var row = GetRow(curInd);
        var col = GetCol(curInd);
        var nextInds = new List<int>();
        for (int i = 0; i < offsets.GetLength(0); i++)
        {
            var newRow = row + offsets[i, 0];
            var newCol = col + offsets[i, 1];
            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8)
            {
                nextInds.Add(GetIndex(newRow, newCol));
            }
        }
        return nextInds;
    }

    void FindRecursive(int[] field, int curInd, int endInd, List<int>path, ref List<int> resultPath)
    {
        field[curInd] = path.Count;
        if (curInd == endInd && (resultPath == null || resultPath.Count > path.Count))
        {
            resultPath = new List<int>(path);
            return;
        }
        foreach (var nextInd in GetNextIndexes(curInd))
        {
            if (path.Count <= 6 && (field[nextInd] == -1 || field[nextInd] > path.Count + 1))
            {
                path.Add(nextInd);
                FindRecursive(field, nextInd, endInd, path, ref resultPath);
                path.Remove(nextInd);
            }
        }
    }*/
}
