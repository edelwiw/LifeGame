public class Field {
    private boolean[][] field;
    private int width;
    private int height;

    public Field(int width, int height){
        this.field = new boolean[height][width];
        this.height = height;
        this.width = width; // replace with arr.size() ?
    }

    public void setCell(int x, int y){
        this.field[y][x] = true;
    }

    public void clearCell(int x, int y){
        this.field[y][x] = false;
    }

    public void printField(){
        System.out.print("+");
        for(int i = 0; i < this.width; i++){ // top border
            System.out.print("--");
        }
        System.out.println("+");

        for(int i = 0; i < this.height; i++){
            System.out.print("|");
            for (int j = 0; j < this.width; j++) {
                if (this.field[i][j]) System.out.print("* ");
                else System.out.print(". ");
            }
            System.out.println("|");
        }

        System.out.print("+");
        for(int i = 0; i < this.width; i++){ // bottom border
            System.out.print("--");
        }
        System.out.println("+");
    }

    private int calcNumberOfNeighbours(int x, int y){
        int numberOfNeighbours = 0;
        for(int i = Math.max(0, y - 1); i <= Math.min(this.height - 1, y + 1); i++){
            for(int j = Math.max(0, x - 1); j <= Math.min(this.width - 1, x + 1); j++) {
                if(i != y || j != x) if(this.field[i][j]) numberOfNeighbours++;
                }
            }
        return numberOfNeighbours;
    }

    private boolean checkCell(int x, int y){
        int numberOfNeighbours = calcNumberOfNeighbours(x, y);
        if(this.field[y][x] && numberOfNeighbours <= 3 && numberOfNeighbours > 1) return true;
        if(!this.field[y][x] && numberOfNeighbours == 3) return true;
        return false;
    }

    public void turn(){
        // create a copy of field
        boolean[][] newField = new boolean[this.height][this.width];
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                newField[i][j] = this.field[i][j];
            }
        }

        // check cells
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                if(checkCell(j, i)) newField[i][j] = true;
                else newField[i][j] = false;
            }
        }

        this.field = newField;
    }

}
