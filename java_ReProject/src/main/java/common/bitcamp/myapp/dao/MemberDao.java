package common.bitcamp.myapp.dao;


import common.bitcamp.myapp.vo.Member;

import java.util.List;

public interface MemberDao {
  void insert(Member member);
  List<Member> list();
  Member findBy(int no);
  int update(Member member);
  int delete(int no);
}
