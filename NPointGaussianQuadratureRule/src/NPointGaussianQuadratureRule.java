import java.util.Scanner;

public class NPointGaussianQuadratureRule{


    public static void main(String[] args) {

        //새 Func 인스턴트를 생성할 때 생성자에 의해 조건이 입력된다
        Func func = new Func();

        /*만들어야 할 것
        INT f(x) dx, x from a to b = ((b-a)/2) * INT f(((b-a)/2)xi) + (b+a)/2) dx
         = ((b-a)/2) * SUM wi * f(((b-a)/2)xi) + (b+a)/2), i 1 to n

         Reference: https://pomax.github.io/bezierinfo/legendre-gauss.html
         */


        double resultSum = 0;

        for (int i = 0; i < func.xN.length; i++) {

            func.func(i, func.numP, func.numM); // 함수값 구하기

            //디버그 전용
            System.out.println("funcResult[" + i + "] : " + func.funcResult[i]);
            resultSum += func.funcResult[i];
        }
        double result = func.numM * resultSum;
        System.out.println("정적분의 값 = : " + result);
    }
}

class Func{
    public double[][] xN; //배열을 선언 후 공간을 지정해줘야 한다. Sample Point.
    public double[] funcResult;
    public double intStart; //적분 시작구간
    public double intFinal; //적분 끝나는 구간
    public int intN; //나누는 구간의 수
//    public double dx;

    double numP; // (b+a)/2
    double numM; // (b-a)/2

    public Func() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("적분구간의 시작점을 입력하십시오: x = ");
        intStart = scanner.nextInt();

        System.out.print("적분 구간의 끝점을 입력하십시오: x = ");
        intFinal = scanner.nextInt();

        numP = (intFinal + intStart) / 2; // (b+a)/2
        numM = (intFinal - intStart) / 2; // (b-a)/2

        System.out.print("Sample Point의 수를 입력하십시오: n = ");
        intN = scanner.nextInt();

        funcResult = new double[intN]; //sample point가 n개이므로, 배열 요소의 개수는 n
        xN = new double[intN][intN]; //sample point가 n개이므로, 배열 요소의 개수는 n. wi와 xi를 저장.
        // [0 가중치, 1 x좌표][순서]
        for(int j = 0; j < xN.length; j++) {

        }

        //먼저 n = 2일때로 해보자
        //가중치
        xN[0][0] = 1.000000;
        xN[0][1] = 1.000000;

        //x좌표
        xN[1][0] = -0.577350;
        xN[1][1] = 0.577350;
    }

    // f(x) = x^3
    public void func(int cycle, double numP, double numM) {
//        funcResult[cycle] = (1 * Math.pow(xN[cycle], 3)) + 0;
        funcResult[cycle] = xN[0][cycle] * (Math.pow(((numM * xN[1][cycle]) + numP), 3) + 0) ;
    }

    //TODO 수식 입력 방법 연구
    public static void inputFunc() {
        //수식을 입력 받자
        System.out.println("수식을 입력하십시오: ");
    }
}

enum WeightsAbscissae {

}