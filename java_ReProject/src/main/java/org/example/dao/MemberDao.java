package org.example.dao;


import org.example.vo.Member;

import java.util.List;

public interface MemberDao {
  void insert(Member member);

  List<Member> list();

  Member findBy(int no);

  int update(Member member);

  int delete(int no);
}
