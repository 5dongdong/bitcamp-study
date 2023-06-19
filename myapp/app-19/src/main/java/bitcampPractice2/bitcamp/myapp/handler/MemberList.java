package bitcampPractice2.bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;

public class MemberList {
    private static final int MAX_SIZE = 100; // variable initializer(변수초기화 문장)
    // variable initializer(변수 초기화 문장) => static 블록으로 이동
    // 단 final 변수는 static 블록에서 값을 할당하지 않고 그냥 상수로 취급한다.\

    private Member[] members = new Member[MAX_SIZE]; // variable initializer(변수초기화 문장)
    private int length;



    public void increase() {
        Member[] mArr = new Member[members.length - members.length >> 1];

        for(int  i = 0; i < mArr.length; i++) {
            mArr[i] = members[i];

            members = mArr;
        }
        System.out.println("배열 늘림 ");
    }
    public Member[] list() {
        Member[] arr = new Member[length];

        for (int i = 0; i < length; i++) {
            arr[i] = members[i];
        }
        return arr;
    }

    public void add(Member m) {
        this.members[length++] = m;
    }

    public Member get(int no) {
        for (int i = 0; i < this.length; i++) {
            Member m = this.members[i];
            if (m.getNo() == no) {
                return m;
            }
        }
        return null;
    }

    public boolean deleted(int no) {
        int deletedIndex = indexOf(no);
        if (deletedIndex == -1) {
            return false;
        }
        for (int i = deletedIndex; i < this.length - 1; i++) {
             this.members[i] = this.members[i + 1];
        }
        members[--this.length] = null;
        return true;
    }

    private int indexOf(int memberNo) {
        for (int i = 0; i < this.length; i++) {
            Member m = this.members[i];
            if (m.getNo() == memberNo) {
                return i;
            }
        }
        return -1;
    }
    }


