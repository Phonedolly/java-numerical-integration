import java.util.Scanner;

public class TrapezoidalRule{

    public static String Func;
    public static double intStart;
    public static double intFinal;
    public static int intN;

    public static void main(String[] args) {

        //조건 입력
        inputCondition();


        /*
        함수를 f(x) = qx + w
        */

        //함수의 계수
        int q = 1;
        int w = 0;

        //구간의 길이
        double dx = (intFinal - intStart) / intN;

        //등분한 구간의 x좌표 구하기
        double xN[] = new double[intN + 1]; //n등분 했으므로 n + 1개의 함숫값이 필요하다
        for (int k = 0; k <= intN; k++) {
            xN[k] = intStart + (k * dx); // 중요! 소수점 이하 자리를 얻으려면 두 수 중 하나는 반드시 실수형이어야 한다
        }

        double funcResult[] = new double[intN + 1];
        double resultSum = 0;
        for (int i = 0; i <= intN; i++) {
            funcResult[i] = (q * xN[i]) + w;

            // 첫 항과 마지막 항을 제외하고 계수가 2이다
            if ((i != 0) && (i != intN)) {
                funcResult[i] = 2 * funcResult[i];
            }

            //디버그 전용
            System.out.println("funcResult[" + i + "] : " + funcResult[i]);
            resultSum += funcResult[i];
        }

        double result = resultSum * (dx / 2);

        System.out.println("정적분의 값 = : " + result);
    }

    //TODO 수식 입력 방법 연구
    public static void inputFunc() {
        //수식을 입력 받자
        System.out.println("수식을 입력하십시오: ");
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
