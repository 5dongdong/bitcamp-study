package bitcampPractice.myapp.handler;

// 핸들러 사용 규칙
// => 즉 메서드 호출 규칙을 정의
// => 메서드 시그니처와 리턴 타입을 정의
// 시그니처(signature)? 메서드명, 파라미터 목록
// => 메서드 몸체는 작성하지 않는다.
// 왜? 호출 규칙만 정의하는 것이기 때문이


public interface Handler {
  void execute(); // public abstract 가 기본 default값이므로 작성하지 않아도 괜찮다............

}
