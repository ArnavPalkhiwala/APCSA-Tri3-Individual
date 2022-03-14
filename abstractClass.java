public abstract class abstractClass {
    String t1;

    public abstractClass(String t1) {
        this.t1 = t1;
    }

    public abstract void run();

    @Override
    public String toString() {
        return t1;
    }


    
}