public class Main {
    public static void main(String[] args) {
        Field field = new Field(15, 15);

        // (3, 8), (4, 7), (5, 7), (5, 8), (5, 9), (10, 7), (10, 8), (10, 9), (11, 7), (12, 8), (3, 2), (4, 3), (5, 1), (5, 2), (5, 3), (9, 1), (9, 2), (9, 3), (10, 3), (11, 2).
        field.setCell(3, 8);
        field.setCell(4, 7);
        field.setCell(5, 7);
        field.setCell(5, 8);
        field.setCell(5, 9);
        field.setCell(10, 7);
        field.setCell(10, 8);
        field.setCell(10, 9);
        field.setCell(11, 7);
        field.setCell(12, 8);
        field.setCell(3, 2);
        field.setCell(4, 3);
        field.setCell(5, 1);
        field.setCell(5, 2);
        field.setCell(5, 3);
        field.setCell(9, 1);
        field.setCell(9, 2);
        field.setCell(9, 3);
        field.setCell(10, 3);
        field.setCell(11, 2);

        field.printField();
        for(int i = 0; i < 12; i++) {
            System.out.println("Turn number " + (i + 1));
            field.turn();
            field.printField();
        }

    }

}