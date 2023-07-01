package HungarianAlgorithm;

public class methods extends header {
    private void initLabels() {
        for (int i = 0; i < n; i++) {
            lx[i] = Integer.MIN_VALUE;
            ly[i] = 0;
            for (int j = 0; j < n; j++) {
                lx[i] = Math.max(lx[i], cost[i][j]);
            }
        }
    }

    private void updateLabels() {  //PANGGIL DI AUGMENT
        int x, y;
        int delta = Integer.MAX_VALUE;  
        for (y = 0; y < n; y++) {  
            if (!T[y]) {
                delta = Math.min(delta, slack[y]);
            }
        }
        for (x = 0; x < n; x++) {  
            if (S[x]) {
                lx[x] -= delta;
            }
        }
        for (y = 0; y < n; y++) {  
            if (T[y]) {
                ly[y] += delta;
            }
        }
        for (y = 0; y < n; y++) {  
            if (!T[y]) {
                slack[y] -= delta;
            }
        }
    }

    private void addToTree(int x, int prevX) {
        S[x] = true;  
        previous[x] = prevX;  
        for (int y = 0; y < n; y++) {  
            if (lx[x] + ly[y] - cost[x][y] < slack[y]) {
                slack[y] = lx[x] + ly[y] - cost[x][y];
                slackx[y] = x;
            }
        }
    }

    private void augment() {
        if (maxMatch == n) return;  
        int x, y;  
        int q[] = new int[n], wr = 0, rd = 0;  
        S = new boolean[n];  
        T = new boolean[n];  
        previous = new int[n];  
        int root = -1;

        for (x = 0; x < n; x++) {  
            if (xy[x] == -1) {
                q[wr++] = root = x;
                previous[x] = -2;
                S[x] = true;
                break;
            }
        }

        if (root == -1) {
            return;
        }

        for (y = 0; y < n; y++) {  
            slack[y] = lx[root] + ly[y] - cost[root][y];
            slackx[y] = root;
        }

        while (true) {
            while (rd < wr) {
                x = q[rd++];  
                for (y = 0; y < n; y++) {  
                    if (cost[x][y] == lx[x] + ly[y] && !T[y]) {
                        if (yx[y] == -1) {
                            break;  
                        }
                        T[y] = true;  
                        q[wr++] = yx[y];  
                        addToTree(yx[y], x);  
                    }
                }
                if (y < n) {
                    break;  
                }
            }
            if (y < n) {
                break;  
            }

            updateLabels();  

            wr = rd = 0;
            for (y = 0; y < n; y++) {
                if (!T[y] && slack[y] == 0) {
                    if (yx[y] == -1) {  
                        x = slackx[y];
                        break;
                    } else {
                        T[y] = true;  
                        if (!S[yx[y]]) {
                            q[wr++] = yx[y];  
                            addToTree(yx[y], slackx[y]);  
                        }
                    }
                }
            }
            if (y < n) {
                break;  
            }
        }

        if (y < n) {
            maxMatch++;  
            for (int cx = x, cy = y, ty; cx != -2; cx = previous[cx], cy = ty) {
                ty = xy[cx];
                yx[cy] = cx;
                xy[cx] = cy;
            }
            augment();  
        }
    }

    public int findResult(int array[][], int N) {
        //inisialisasi variable di header
        n = N;
        cost = new int[n][n];
        lx = new int[n];
        ly = new int[n];
        S = new boolean[n];
        T = new boolean[n];
        slack = new int[n];
        slackx = new int[n];
        previous = new int[n];
        maxMatch = 0;  
        xy = new int[n];
        yx = new int[n];
        int res = 0;  

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = -1 * array[i][j];
            }
        }
        
        for(int i = 0; i < xy.length; i++){
            xy[i] = -1;
            yx[i] = -1;
        }

        initLabels();  
        augment();  

        for (int x = 0; x < n; x++) {
            res += cost[x][xy[x]];
        }

        return -1 * res;
    }
}
