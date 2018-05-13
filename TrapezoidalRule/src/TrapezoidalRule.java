import java.util.Scanner;

public class TrapezoidalRule{

    public static double intStart;
    public static double intFinal;
    public static int intN;

    public static void main(String[] args) {

        //조건 입력
        inputCondition();

        Func func1 = new Func();

        //소구간의 길이
        double dx = (intFinal - intStart) / intN;

        //등분한 구간의 x좌표 구하기
        for (int k = 0; k < func1.xN.length; k++) {
            func1.xN[k] = intStart + (k * dx); // 중요! 소수점 이하 자리를 얻으려면 두 수 중 하나는 반드시 실수형이어야 한다
        }

        double resultSum = 0;
        for (int i = 0; i < func1.xN.length; i++) {

            func1.func(i); // 함수값 구하기

            // 사다리꼴 공식에 의해, 첫 항과 마지막 항을 제외하고 계수가 2이다
            if ((i != 0) && (i != intN)) {
                func1.funcResult[i] = 2 * func1.funcResult[i];
            }

            //디버그 전용
            System.out.println("funcResult[" + i + "] : " + func1.funcResult[i]);
            resultSum += func1.funcResult[i];
        }
        double result = resultSum * (dx / 2);
        System.out.println("정적분의 값 = : " + result);
    }

    //적분 구간, n 지정
    public static void inputCondition(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("적분구간의 시작점을 입력하십시오: x = ");
        intStart = scanner.nextInt();

        System.out.print("적분 구간의 끝점을 입력하십시오: x = ");
        intFinal = scanner.nextInt();

        System.out.print("적분 구간을 몇 등분할 것인지 입력하십시오: n = ");
        intN = scanner.nextInt();
    }
}

class Func{
    public double[] xN; //배열을 선언 후 공간을 지정해줘야 한다
    public double[] funcResult;


    public Func() {
        xN = new double[TrapezoidalRule.intN + 1]; //n등분 했으므로 n + 1개의 x좌표가 필요하다
        funcResult = new double[TrapezoidalRule.intN + 1]; //n등분 했으므로 n + 1개의 함숫값이 필요하다
    }

    // f(x) = x
    public void func(int cycle) {
        funcResult[cycle] = (1 * xN[cycle]) + 0;
    }

    //TODO 수식 입력 방법 연구
    public static void inputFunc() {
        //수식을 입력 받자
        System.out.println("수식을 입력하십시오: ");
    }


}
