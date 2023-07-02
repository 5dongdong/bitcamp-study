    package util;

    import java.io.InputStream;
    import java.util.NoSuchElementException;
    import java.util.Scanner;

    public class Prompt {
        private Scanner sc;

        public Prompt() {
            this.sc = new Scanner(System.in);
        }

        public Prompt(InputStream in) {
            this.sc = new Scanner(in);
        }

        public String inputString(String title, Object... args){
            System.out.printf(title, args);

            try {
                return this.sc.nextLine();
            } catch (NoSuchElementException e) {
                // 예외 처리
                System.out.println("입력 오류가 발생했습니다.");
                return null;
            }
        }
        public String next() {
            return this.sc.next();
        }

        public int inputInt(String title, Object... args) {
            return Integer.parseInt(inputString(title, args));
        }

        public void close() {
            sc.close();
        }

        
    }
