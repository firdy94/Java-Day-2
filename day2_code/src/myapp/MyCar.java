package myapp;


public class MyCar extends car {


    public MyCar() { 
        super (color,started);

    }
    public MyCar(String color) {

        this.setColor(color);
}

    @Override
    public String getColor(){
        return "Matte %s".format(super.getColor());
    }

    public static void main (String [] args){
        car blackcar= new car("black", false);
        car redcar= new MyCar("red");
        MyCar yellowcar =new MyCar("yellow");


        System.out.println(blackcar instanceof car);
        System.out.println(blackcar instanceof MyCar);
        System.out.println(redcar instanceof car);
        System.out.println(redcar instanceof MyCar);
        System.out.println(yellowcar instanceof car);
        System.out.println(yellowcar instanceof MyCar);
        
    }
    
}
