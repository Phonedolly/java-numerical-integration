import java.util.Scanner;

public class SimpsonRule{
    public static void main(String[] args) {
        //새 Func 인스턴트를 생성할 때 생성자에 의해 조건이 입력된다
        Func func = new Func();
        double resultSum = 0;
        for (int i = 0; i < func.xN.length; i++) {
            func.func(i); // 함수값 구하기

            // 심프슨 공식에 의해, 첫 항과 마지막 항은 계수가 1, 나머지는 4, 2, 4, 2, ...로 반복된다
            //짝수번째는 4f(xN), 홀수번째는 2f(xN)
            //첫 항과 마지막 항이 아닌 것 걸러내기
            if ((i != 0) && (i != func.intN)) {
                //짝수번째라면 4f(xN)
                if(i % 2 == 1) {
                    func.funcResult[i] = 4 * func.funcResult[i];
                }
                //홀수번째라면 2f(xN)
                else {
                    func.funcResult[i] = 2 * func.funcResult[i];
                }
            }

            //디버그 전용
            System.out.println("funcResult[" + i + "] : " + func.funcResult[i]);
            resultSum += func.funcResult[i];
        }
        double result = resultSum * (func.dx / 3);
        System.out.println("정적분의 근사값 = : " + result);
    }
}

class Func{
    public double[] xN; //배열을 선언한 뒤에 공간을 지정해줘야 한다
    public double[] funcResult;
    public double intStart; //적분 시작구간
    public double intFinal; //적분 끝나는 구간
    public int intN; //나누는 구간의 수
    public double dx;

    public Func() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("적분구간의 시작점을 입력하십시오: x = ");
        intStart = scanner.nextInt();

        System.out.print("적분 구간의 끝점을 입력하십시오: x = ");
        intFinal = scanner.nextInt();

        do {
            System.out.print("적분 구간을 몇 등분할 것인지 입력하십시오(단, n >= 1): n = ");
            intN = scanner.nextInt();
        } while (intN < 1);

        xN = new double[intN + 1]; //n등분 했으므로 n + 1개의 x좌표가 필요하다
        funcResult = new double[intN + 1]; //n등분 했으므로 n + 1개의 함숫값이 필요하다

        //소구간의 길이
        dx = (intFinal - intStart) / intN;

        //등분한 구간의 x좌표 구하기
        for (int k = 0; k < xN.length; k++) {
            xN[k] = intStart + (k * dx); // 중요! 소수점 이하 자리를 얻으려면 두 수 중 하나는 반드시 실수형이어야 한다
            System.out.println("xN[" + k + "] : " + xN[k]);
        }
    }

    // f(x) = x^2
    public void func1(int cycle) {
        funcResult[cycle] = (1 * Math.pow(xN[cycle], 2)) + 0;
    }

    //f(x) = x^3 * e^x * sinx
    public void func(int cycle) {
        funcResult[cycle] = Math.pow(xN[cycle], 3) * Math.exp(xN[cycle]) * Math.sin(xN[cycle]);
    }

    //TODO 수식 입력 방법 연구
    public static void inputFunc() {
        //수식을 입력 받자
        System.out.println("수식을 입력하십시오: ");
    }
}