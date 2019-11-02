import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class Zad1Spec {
    @Rule
    public ExpectedException exception= ExpectedException.none();
    private Zad1 zad1;
    @Before
    public final void before(){
        zad1=new Zad1(); }
    @Test
    public void whenXOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        zad1.play(5,2);
        zad1.play(3,4);}

    @Test
    public void whenOccupiedThenRuntimeException(){
        zad1.play(2,1);
        exception.expect(RuntimeException.class);
        zad1.play(2,1);}

    @Test
    public void whenYOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        zad1.play(1,6);
    }

    @Test
    public void givesFirstTurnWhenNextPlayerThenX(){
        zad1.restart();
        assertEquals('X',zad1.nextPlayer());
    }

    @Test
    public void givenlastTurnWasXWhenNextPlayerThenO(){
        zad1.restart();
        zad1.play(1,1);
        assertEquals('O',zad1.nextPlayer());
    }
//@Test
//    public void givenLastTurnWasXWhenNextPlayerThenX(){
//        zad1.restart();
//        zad1.play(1,1);
//        assertEquals('X', zad1.nextPlayer());
//}

    @Test
    public void whenPlayThenNoWinner(){
        String actual=zad1.play(1,1);
        assertEquals("Brak zwyciezcy",actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner(){
        zad1.restart();
        zad1.play(1,1);
        zad1.play(1,2);
        zad1.play(2,1);
        zad1.play(2,2);
        String actual=zad1.play(3,1);
        assertEquals("Wygrał X",actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner(){
        zad1.restart();
        zad1.play(1,1);
        zad1.play(2,1);
        zad1.play(1,2);
        zad1.play(2,2);
        String actual=zad1.play(1,3);
        assertEquals("Wygrał X",actual);
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner(){
        zad1.restart();
        zad1.play(1,1);
        zad1.play(1,2);
        zad1.play(2,2);
        zad1.play(2,3);
        String actual=zad1.play(3,3);
        assertEquals("Wygrał X",actual);
    }

    @Test
    public void whenPlayAndBottomTopLineThenWinner(){
        zad1.restart();
        zad1.play(3,1);
        zad1.play(1,2);
        zad1.play(2,2);
        zad1.play(2,3);
        String actual=zad1.play(1,3);
        assertEquals("Wygrał X",actual);
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw(){
        zad1.restart();
        zad1.play(1,1);
        zad1.play(1,2);
        zad1.play(1,3);


        zad1.play(3,1);
        zad1.play(2,2);
        zad1.play(2,3);
        zad1.play(2,1);
        zad1.play(3,3);
        String actual = zad1.play(3,2);

        assertEquals("Remis",actual);
    }



}
