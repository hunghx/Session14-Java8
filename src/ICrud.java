public interface ICrud {
    void getAll();
    void add();
    void edit();
    void delete();
    default void search(){
        System.out.println("tim kiếm");
    };
    static void displayName(){

    };
}
