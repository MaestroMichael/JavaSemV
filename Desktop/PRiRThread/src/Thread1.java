public class Thread1 extends Thread {

    int id;

    public Thread1(int id){
        this.id=id;
    }
    @Override
    public void run(){
        try{
            Thread.sleep((long)(300*Math.random()));
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("Watek: "+this.getName()+" o numerze "+id);
        }

    }
}
