package myapp;


public class car {



    private String color;
    private boolean started =false;


    public car (String  color, boolean started){
        this.color=color;
        this.started=started;
    }
    public String getColor() { return this.color; }
    public void setColor(String color) { this.color= color; }
    public boolean isStarted() { return this.started; }

    public void start() {
        // Start the car
        this.started= true;
        }
        public void stop() {
        // Stop the car
        this.started= false;
        }

    void display(){System.out.println(color+" "+started);}
    public static void main (String[] args){

        car blackcar= new car("black", false);
        car redcar= new car("red", true);

        blackcar.display();
        redcar.display();

    }
    

    
}
