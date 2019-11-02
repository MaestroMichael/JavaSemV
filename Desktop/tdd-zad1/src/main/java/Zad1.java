

public class Zad1 {

    private Character[][] board={{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private static char check='X';
    public String play(int x, int y){
        String result="Brak zwyciezcy";
        if (x<1||x>3) throw new RuntimeException("Wartość X wykracza poza planszę");
        if (y<1||y>3) throw new RuntimeException("Wartość Y wykracza poza planszę");

//        if(board[x-1][y-1]!='\0'){
//            throw new RuntimeException("Pole jest zajete");
//        }else{
//            board[x-1][y-1]='X';
//        }

        char lastPlayer = nextPlayer();
        if (nextPlayer() == 'X') check = 'O';
        else check = 'X';

        setBox(x,y,check);
        result=isWin(check);
        if( result == "Brak Wygranego") result = checkDraw();
//        if (nextPlayer() == 'X') check = 'O';
//        else check = 'X';
        return result;
    }

    private String checkDraw() {
        for(Character[] b2 :board){
            for(Character temp:b2){
                if(temp=='\0'){
                    return "Brak Wygranego";
                }
            }
        }
        return "Remis";
    }

    private void setBox(int x, int y, char lastPlayer){
    if(board[x-1][y-1]!='\0'){
        throw new RuntimeException("Pole jest zajete");
    }else{
        board[x-1][y-1]=lastPlayer;
    }
}
    public char nextPlayer() {
        if (check=='X')check='O';
        else check='X';
        return check;
    }

    public String isWin(char player){
        int count=0;
        for(Character[] b1:board){
            for(Character e1:b1){
                if(e1==player) {
                    count++;
                }else{
                    count=0;
                }
            }
            if(count==3){
                return "Wygrał "+player;
            }
        }
        if(board[0][0]==player&&board[1][1]==player&&board[2][2]==player)return "Wygrał "+player;
        if(board[0][2]==player&&board[1][1]==player&&board[2][0]==player)return "Wygrał "+player;

        return "Brak Wygranego";
    }
    public void restart(){
        board= new Character[][] {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
         char check='X';
    }



    public static void main(String[] args) {

    }
}
