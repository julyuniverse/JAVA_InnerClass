class OutClass {
    // 멤버 변수
    private int num = 10;
    private static int sNum = 20;
    private InClass inClass;

    // 생성자
    public OutClass() {
        inClass = new InClass();
    }

    // inner class는 주로 private를 선언한다.
    private class InClass { // inner class 선언
        int iNum = 100;

        // InClass는 OutClass가 생성되기 전으로 static 변수를 사용할 수 없다.
        // static int siNum = 500;

        void inTest() {
            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass iNum = " + iNum + "(내부 클래스의 인스턴스 변수)");
            System.out.println();
        }
    }

    // public inner class도 호출이 가능하다. 하지만 권장되진 않는다.
    public class InClass2 { // inner class 선언
        int iNum2 = 100;

        // InClass는 OutClass가 생성되기 전으로 static 변수를 사용할 수 없다.
        // static int siNum = 500;

        void inTest() {
            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass2 iNum2 = " + iNum2 + "(내부 클래스의 인스턴스 변수)");
            System.out.println();
        }
    }

    public void usingClass() {
        inClass.inTest();
    }

    // 정적 내부 클래스 선언
    static class StaticInClass {
        int iNum = 100;
        static int siNum = 200;

        void inTest() { // 이 메서드에서는 해당 클래스가 정적 내부 클래스이기 때문에 내부 클래스에 변수는 모두 사용 가능하지만 외부 클래스의 스태틱 변수만 사용 가능하다.
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("StaticInClass iNum = " + iNum + "(내부 클래스의 인스턴스 변수)");
            System.out.println("StaticInClass siNum = " + siNum + "(내부 클래스의 스태틱 변수)");
            System.out.println();
        }

        static void sTest() { // 해당 클래스와 그에 속한 메서드 모두 정적 클래스, 메서드이기 때문에 외부 클래스의 스태틱 변수와 내부 클래스의 스태틱 변수만 사용 가능하다.
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("StaticInClass siNum = " + siNum + "(내부 클래스의 스태틱 변수)");
            System.out.println();
        }
    }
}

public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingClass();

        // 결과
        // OutClass num = 10(외부 클래스의 인스턴스 변수)
        // OutClass sNum = 20(외부 클래스의 스태틱 변수)
        // InClass iNum = 100(내부 클래스의 인스턴스 변수)

        OutClass.InClass2 inClass2 = outClass.new InClass2();
        inClass2.inTest();

        // 결과
        // OutClass num = 10(외부 클래스의 인스턴스 변수)
        // OutClass sNum = 20(외부 클래스의 스태틱 변수)
        // InClass2 iNum2 = 100(내부 클래스의 인스턴스 변수)

        OutClass.StaticInClass staticInClass = new OutClass.StaticInClass();
        staticInClass.inTest();

        // 결과
        // OutClass sNum = 20(외부 클래스의 스태틱 변수)
        // StaticInClass iNum = 100(내부 클래스의 인스턴스 변수)
        // StaticInClass siNum = 200(내부 클래스의 스태틱 변수)

        OutClass.StaticInClass.sTest(); // 해당 메서드는 정적 메서드이기 때문에 new 키워드 없이 바로 사용 가능하다.

        // 결과
        // OutClass sNum = 20(외부 클래스의 스태틱 변수)
        // StaticInClass siNum = 200(내부 클래스의 스태틱 변수)
    }
}
