package ex3

class `ex3-1` {
    // 피보나치의 수학적 귀납법 증명
    /*
    명제 : 피보나치 수열 fiboRecursion(n)은 음이 아닌 정수 n에 대해서 f(n-1) + f(n-2) 의 합을 올바르게 계산한다.
    n=0인 경우 0을 반환한다.
    n=1인 경우 1을 반환한다.
    임의의 양의정수 k에 대해서 n<k인 경우, f(n) 까지의 합을 올바르게 계산하여 반환한다고 가정한다.
    n=k인 경우, f(k -1)을 호출할때 이전의 가정에 의해 f(k-2), f(k-3)을 올바르게 계산한다. 이렇게 나온 값을 합하여 반환하므로 fiboRecursion(n)은 올바르게 계산한다.
     */
}