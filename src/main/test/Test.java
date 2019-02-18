public class Test {
    public static void main(String[] args) {
        test2(new String[]{"1", "2"});
    }

    private static void test2(String[] args){
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
