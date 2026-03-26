

    public PerformOperation isOdd() {
        return (a) -> a % 2 != 0;
    }
    public PerformOperation isPrime() {
        return (a) -> {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }
    public PerformOperation isPalindrome() {
        return (a) -> {
            int original = a, rev = 0;
            while (a > 0) {
                rev = rev * 10 + a % 10;
                a /= 10;
            }
            return original == rev;
        };
    }
}   


