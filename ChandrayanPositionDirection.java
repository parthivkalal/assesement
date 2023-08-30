package Chandrayan;
 public class ChandrayanPositionDirection {
    private int x, y, z;
    private char direction;
    private char previousDirection;

    public ChandrayanPositionDirection(int startX, int startY, int startZ, char startDirection) {
        x = startX;
        y = startY;
        z = startZ;
        direction = startDirection;

    }

    public void executeCommands(char[] commands) {
        for (char command : commands) {
            switch (command) {
                case 'f' -> moveForward();
                case 'b' -> moveBackward();
                case 'l' -> turnLeft();
                case 'r' -> turnRight();
                case 'u' -> turnUp();
                case 'd' -> turnDown();
            }
        }

    }

    private void moveForward() {
        switch (direction) {
            case 'N' -> y++;
            case 'S' -> y--;
            case 'E' -> x++;
            case 'W' -> x--;
            case 'U' -> z++;
            case 'D' -> z--;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case 'N' -> y--;
            case 'S' -> y++;
            case 'E' -> x--;
            case 'W' -> x++;
            case 'U' -> z--;
            case 'D' -> z++;
        }
    }

    private void turnLeft() {
        if(previousDirection == ' ') {


            switch (direction) {

                case 'N' -> direction = 'W';
                case 'S' -> direction = 'E';
                case 'E' -> direction = 'N';
                case 'W' -> direction = 'S';
            }
        }
        else{

            switch (previousDirection) {

                case 'N' -> direction = 'W';
                case 'S' -> direction = 'E';
                case 'E' -> direction = 'N';
                case 'W' -> direction = 'S';
            }
        }
    }


    private void turnRight() {
        if(previousDirection == ' ')
        {
            switch (direction) {
                case 'N' -> direction = 'E';
                case 'S' -> direction = 'W';
                case 'E' -> direction = 'S';
                case 'W' -> direction = 'N';
            }

        }
        else{
            switch (direction) {
                case 'N' -> direction = 'E';
                case 'S' -> direction = 'W';
                case 'E' -> direction = 'S';
                case 'W' -> direction = 'N';
            }
        }
    }

//    we assume that here we are not using 2 times up or down ;

    private void turnUp() {


 previousDirection = direction;

            direction = 'U';

    }

    private void turnDown() {
        previousDirection= direction;
            direction = 'D';



    }

    public String getCurrentPosition() {
        return "(" + x + ", " + y + ", " + z + ")";
    }


     public char getDirection() {

    return direction;

     }
 }

class ChandrayanSetCommand {
    public static void main(String[] args) {
        ChandrayanPositionDirection  chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');
        char[] commands = {'f', 'r', 'u', 'b','l'};
        chandra.executeCommands(commands);
        System.out.println("Current Position: " + chandra.getCurrentPosition());
        System.out.println(chandra.getDirection());
    }
}

