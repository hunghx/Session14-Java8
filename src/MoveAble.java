
@FunctionalInterface // kiểm tra xem có phải là 1 functional interface không
public interface MoveAble {
    void move();
//    void run();

    default void display(){

    };
}
