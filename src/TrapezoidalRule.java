public class TrapezoidalRule{

    public String Func;

    public static void main(String[] args) {
        /*
        함수를 f(x) = qx + w
        */

        //함수의 계수
        int q = 1;
        int w = 0;

        //적분 구간
        double a = 0;
        double b = 1;

        // 구간을 4개로 나누자.
        int n = 4;

        double dx = (b - a) / n;

        double xn[] = new double[n + 1]; //n등분 했으므로 n + 1개의 함숫값이 필요하다
        for (int k = 0; k <= n; k++) {
            xn[k] = a + (k * dx); // 중요! 소수점 이하 자리를 얻으려면 두 수 중 하나는 반드시 실수형이어야 한다
        }

        double resultArray[] = new double[n + 1];
        double resultSum = 0;
        for (int i = 0; i <= n; i++) {
            resultArray[i] = (q * xn[i]) + w;

            // 첫 항과 마지막 항을 제외하고 계수가 2이다
            if ((i != 0) && (i != n)) {
                resultArray[i] = 2 * resultArray[i];
            }

            //디버그 전용
            System.out.println("resultArray[" + i + "] : " + resultArray[i]);
            resultSum += resultArray[i];
        }

        double result = resultSum * (dx / 2);

        System.out.println("sum = : " + result);


    }

    public static void inputFunc() {
        //수식을 입력 받자
        System.out.println("수식을 입력하십시오: ");

    }
}
