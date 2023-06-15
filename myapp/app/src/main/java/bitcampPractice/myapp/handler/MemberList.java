package bitcampPractice.myapp.handler;

import bitcamp.myapp.vo.Member;


public class MemberList {
    private static final int DEFAULT_SIZE = 3; // variable initializer(변수초기화 문장)

    private Member[] members = new Member[DEFAULT_SIZE]; // variable initializer(변수초기화 문장)
    private int length;




    public void add(Member m) {
        if(this.length == members.length) {
            increase();
        }
        this.members[this.length++] = m;
    }

    public void increase() {
        Member[] mArr = new Member[members.length + (members.length) >> 1];

        for(int i = 0 ; i < mArr.length; i++) {
            mArr[i] = members[i];
            members = mArr;
        }
    }
public Member[] mList() {
    //Member[] 가 리턴값 = > Member[]가 리턴될 배열을 먼저 선언
    Member[] mArr = new Member[this.length];
    for(int i = 0; i < length; i++) {
        mArr[i] = this.members[i];
    }
    return mArr;
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

public boolean delete(int no) {
    int deletedIndex = indexOf(no);
    if (deletedIndex == -1) {
        return false;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
        members[i] = this.members[i + 1];
    }
    members[--this.length] = null;
    return true;
}

    private int indexOf(int memberNo){
        for (int i = 0; i < this.length; i++) {
            Member m = this.members[i];
            if (m.getNo() == memberNo) {
                return i;
            }
        }
        return -1;
}


}

